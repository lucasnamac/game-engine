package Framework.sprite;
import java.awt.event.KeyEvent;

public abstract class Player extends Sprite {
    public String posicao;

    public String getPosicao() {
        return posicao;
    }
    
    public int width;

    public Player() {
        loadImage();
		getImageDimensions();
		resetState();
    }
    
    protected abstract void loadImage();
    
    public abstract void act();
    
    public abstract void keyPressed(KeyEvent e);
    
    public abstract void keyReleased(KeyEvent e);
           
    public abstract void resetState();
}