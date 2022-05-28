package freezemonster.sprite;
import Framework.Commons;
import Framework.sprite.Player;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Cowboy extends Player{
  
    @Override
    protected void loadImage(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/woody.png"));
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;   
            posicao ="left";     
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            posicao ="right";
        }
        
        if(key==KeyEvent.VK_UP){
            dy= -2;
            posicao ="up";
                
        }
        if(key==KeyEvent.VK_DOWN){
            dy =2;
            posicao ="down";
            
                    
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
         if(key==KeyEvent.VK_UP){
            dy=-0;           
        }
        if(key==KeyEvent.VK_DOWN){
            dy=0;
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
        setX(Commons.INIT_PLAYER_X-100);
        setY(Commons.INIT_PLAYER_Y-20);
    }
        
    
}
