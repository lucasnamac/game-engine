package freezemonster;


import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

import Framework.AbstractBoard;
import Framework.sprite.BadSprite;
import Framework.sprite.Player;

import freezemonster.sprite.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

public class FreezeMonsterBoard extends AbstractBoard{  
    //define sprites
    //private List<BadSprite> aliens;
    private Shot shot; 
       
 
    private String explImg = "images/explosion.png";

    @Override
    protected Player createPlayer() {
            return new Cowboy();
    }

    protected void createBadSprites() {  // create sprites
        //ONDE O ALIEN APARECE
        BomberSprite alien = new BomberSprite(Commons.ALIEN_INIT_X, Commons.ALIEN_INIT_Y,"images/monster1.png");      
        badSprites.add(alien);
        BomberSprite alien2 = new BomberSprite(Commons.ALIEN_INIT_X+40, Commons.ALIEN_INIT_Y+30,"images/monster2.png");
        badSprites.add(alien2);
        BomberSprite alien3 = new BomberSprite(Commons.ALIEN_INIT_X+80, Commons.ALIEN_INIT_Y,"images/monster3.png");
        badSprites.add(alien3);
        BomberSprite alien4 = new BomberSprite(Commons.ALIEN_INIT_X+120, Commons.ALIEN_INIT_Y+300,"images/monster4.png");
        badSprites.add(alien4);
        BomberSprite alien5 = new BomberSprite(Commons.ALIEN_INIT_X+180, Commons.ALIEN_INIT_Y,"images/monster5.png");
        badSprites.add(alien5);
        BomberSprite alien6 = new BomberSprite(Commons.ALIEN_INIT_X+230, Commons.ALIEN_INIT_Y+200,"images/monster6.png");
        badSprites.add(alien6);
        BomberSprite alien7 = new BomberSprite(Commons.ALIEN_INIT_X+180, Commons.ALIEN_INIT_Y+250,"images/monster7.png");
        badSprites.add(alien7);
        BomberSprite alien8 = new BomberSprite(Commons.ALIEN_INIT_X+170, Commons.ALIEN_INIT_Y+200,"images/monster8.png");
        badSprites.add(alien8);
        BomberSprite alien9 = new BomberSprite(Commons.ALIEN_INIT_X+210, Commons.ALIEN_INIT_Y+170,"images/monster9.png");
        badSprites.add(alien9);  
    }
   
    protected void createOtherSprites() {
        shot = new Shot();  
    }

    private void drawShot(Graphics g) {
        if (shot.isVisible()) {
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    // Override
    protected void drawOtherSprites(Graphics g) {
         drawShot(g);
    }
    
    protected void processOtherSprites(Player player, KeyEvent e) {
		int x = player.getX();
		int y = player.getY();
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			if (inGame) {
				if (!shot.isVisible()) {
					shot = new Shot(x, y);
                                        shot.setPosicao(player.getPosicao());
				}
			}
		}
	}

    @Override
    protected void update() {
        int cont=0;
        for(int i=0; i<badSprites.size();i++){
            if(badSprites.get(i).getIsFreeze()==true){
                cont++;
            }
        }
        if (cont ==9) {
            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (Player player: players) 
        	player.act();

        // shot
        if (shot.isVisible()) {
            for(int j=0; j<badSprites.size();j++) {

                int alienX = badSprites.get(j).getX();
                int alienY = badSprites.get(j).getY();
                int shotX = shot.getX();
                int shotY = shot.getY();

                if (badSprites.get(j).isVisible() && shot.isVisible() && !badSprites.get(j).getIsFreeze()) {
                    if (shotX >= (alienX)
                            && shotX <= (alienX + freezemonster.Commons.ALIEN_WIDTH)
                            && shotY >= (alienY)
                            && shotY <= (alienY + freezemonster.Commons.ALIEN_HEIGHT)) {

                        int congelado = j+1;
                        ImageIcon ii = new ImageIcon("images/monster"+congelado+"bg.png");
                        badSprites.get(j).setImage(ii.getImage());
                        badSprites.get(j).setIsFreeze(true);
                        shot.die();
                    }
                }
            }
           
            //Tiro segue na posição direcionada
            shot.act();
            
          
        }

        // aliens            
        for(int k=0; k<badSprites.size(); k++){
            badSprites.get(k).act(); 
        }        
        updateOtherSprites();
    }
    

    protected void updateOtherSprites() {
	Random generator = new Random();

        for (BadSprite alien : badSprites) {
            if(alien.getIsFreeze()==true){
                int shot = generator.nextInt(1);
                Bomb bomb = ((BomberSprite)alien).getBomb();

                if (!bomb.isDestroyed()) {

                    bomb.setY(bomb.getY() + 1);

                    if (bomb.getY() >= Commons.GROUND - Commons.BOMB_HEIGHT) {
                        bomb.setDestroyed(true);
                    }
                }
            }
            else{
                int shot = generator.nextInt(15);
                Bomb bomb = ((BomberSprite)alien).getBomb();

                if (shot == Commons.CHANCE && alien.isVisible() && bomb.isDestroyed()) {
                    bomb.setDestroyed(false);
                    bomb.setX(alien.getX());
                    bomb.setY(alien.getY());
                }
                
                int bombX = bomb.getX();
                int bombY = bomb.getY();
                int playerX = players.get(0).getX();
                int playerY = players.get(0).getY();

                if (players.get(0).isVisible() && !bomb.isDestroyed()) {

                    if (bombX >= (playerX)
                            && bombX <= (playerX + Commons.PLAYER_WIDTH)
                            && bombY >= (playerY)
                            && bombY <= (playerY + Commons.PLAYER_HEIGHT)) {

                        ImageIcon ii = new ImageIcon(explImg);
                        players.get(0).setImage(ii.getImage());
                        players.get(0).setDying(true);
                        bomb.setDestroyed(true);
                    }
                }

                if (!bomb.isDestroyed()) {

                    bomb.setY(bomb.getY() + 1);

                    if (bomb.getY() >= Commons.BOARD_HEIGHT) {

                        bomb.setDestroyed(true);
                    }
                }
            }
        }
        
    }    

    @Override
    protected void doDrawing(Graphics g1){ // Template Method
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.darkGray);

        if (inGame) {

            g.drawLine(0, Commons.GROUND,
                    Commons.BOARD_WIDTH, Commons.GROUND);

            drawBadSprites(g);
            drawPlayers(g);
            drawOtherSprites(g);

        } else{

            if (timer.isRunning()) {
                timer.stop();
            }

            gameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
}