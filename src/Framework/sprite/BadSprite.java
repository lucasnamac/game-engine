package Framework.sprite;
import java.util.LinkedList;
public abstract class BadSprite extends Sprite {
    public boolean getIsFreeze() {
        return false;
    }
    
    public void setIsFreeze(boolean isFreeze) {    
    }
        
    public LinkedList<BadSprite>  getBadnesses() {
	return null;
    }
    public boolean isDestroyed() {
	return false;
    }
    public void act () {
    }
}