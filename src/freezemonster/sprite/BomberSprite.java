package freezemonster.sprite;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import Framework.sprite.BadSprite;
import Framework.sprite.BadnessBoxSprite;
import freezemonster.Commons;
import java.util.Random;

public class BomberSprite extends BadnessBoxSprite {
    private boolean isFreeze= false;
    private Bomb bomb;

    @Override
    public boolean getIsFreeze() {
        return isFreeze;
    }

    @Override
    public void setIsFreeze(boolean isFreeze) {
        this.isFreeze = isFreeze;
    }
    
    public BomberSprite(int x, int y, String monster) {
        initBomber(x, y,monster);
    }
 
    private void initBomber(int x, int y, String monster){       
        this.x = x;
        this.y = y;       
        bomb = new Bomb(x, y);
        ImageIcon li = new ImageIcon(monster);
        setImage(li.getImage());
     
    }

    public Bomb getBomb() {
        return bomb;
    }

    //LISTA DE TIROS
    @Override
    public LinkedList<BadSprite> getBadnesses() {
        LinkedList<BadSprite> aBomb = new LinkedList<BadSprite>();
        aBomb.add(bomb);
	return aBomb;
    }
    @Override
    public void act(){
        if(this.x <= 0)
            this.x = 10;
                
        if(this.x >= 330)
            this.x = 330;
        
        if(this.y <= 0)
            this.y = 10;
        
        if(this.y >= 300)
            this.y = 300;
        

        Random generator = new Random();
        int valor = (generator.nextInt(15)+1);
        

        if(this.isFreeze == true){
            this.moveX(0);
            this.moveY(0);
        }
        else {
            if (valor == Commons.LEFT) {
                this.moveX(-6);
            }
            if (valor == Commons.RIGHT) {
                this.moveX(5);
            }
            if (valor == Commons.UP) {
                this.moveY(-5);
            }
            if (valor == Commons.DOWN) {
                this.moveY(5);
            }
            if (valor == Commons.DIAGONALPRIMARIAUP) {
                this.moveY(-5);
                this.moveX(-5);
            }
            if (valor == Commons.DIAGONALPRIMARIADOWN) {
                this.moveY(+5);
                this.moveX(+5);
            }
            if (valor == Commons.DIAGONALSECUNDARIAUP) {
                this.moveY(-5);
                this.moveX(5);
            }
            if (valor == Commons.DIAGONALSECUNDARIADOWN) {
                this.moveY(5);
                this.moveX(-5);
            }
        }
    }     
}
