
package spaceInvaders.sprite;

import Framework.Commons;
import Framework.sprite.Player;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Nave extends Player{
    private int width;

    @Override
    protected void loadImage(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/player.png"));
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;   
                
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
        
    }

    @Override
    public void act() {
        x += dx;
        y +=dy;
        
        if (x <= 0) {
            x = 0;
        }       
        if (x >= Commons.BOARD_WIDTH-30) {
            x = Commons.BOARD_WIDTH-30;
        }        
        if (y <= 0) {
            y = 0;
        }
        if (y >= Commons.BOARD_HEIGHT-80) {
            y = Commons.BOARD_HEIGHT-80;
        }
    
    }

    @Override
    public void resetState() {
        setX(Commons.INIT_PLAYER_X-90);
        setY(Commons.INIT_PLAYER_Y);
    }
   
}
