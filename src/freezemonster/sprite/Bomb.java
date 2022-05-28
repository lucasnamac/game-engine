package freezemonster.sprite;
import javax.swing.ImageIcon;
import Framework.sprite.BadSprite;
public class Bomb extends BadSprite {
    private boolean destroyed;
    public boolean isFreeze=false;
    public Bomb(int x, int y) {
        initBomb(x, y);
    }
    private void initBomb(int x, int y) {
        setDestroyed(true);
        this.x = x;
        this.y = y;
        
        String bombImg = "images/gosma.png";
        ImageIcon ii = new ImageIcon(bombImg);
        setImage(ii.getImage());
    }
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
    
    
}