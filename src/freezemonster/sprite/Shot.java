package freezemonster.sprite;

import javax.swing.ImageIcon;

import Framework.sprite.BadSprite;


public class Shot extends BadSprite {
    public String posicao;

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    
    public Shot() {      
    }

    public Shot(int x, int y) {
        initShot(x, y);
    }
    
    @Override
    public void act(){
        if(this.x <= 0 || this.x >= 500 || this.y <= 0 || this.y >= 450)
            this.die();
        
       if("left".equals(this.posicao))
            this.moveX(-6);

       if("right".equals(this.posicao))
            this.moveX(6);

       if("up".equals(this.posicao))
            this.moveY(-6);
 
       if("down".equals(this.posicao))
        this.moveY(6);    
    }

    private void initShot(int x, int y) {
        //Esse aqui é o tiro
        String shotImg = "images/ray.png";
        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());
        
        //Posição X que o raio sai
        int H_SPACE = 6;
        setX(x + H_SPACE);
        
        //Posição Y que o raio sai
        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}