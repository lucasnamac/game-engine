package freezemonster;


public interface Commons extends Framework.Commons{

    int BOMB_HEIGHT = 5;

    int ALIEN_HEIGHT = 35;
    int ALIEN_WIDTH = 35;
    int ALIEN_INIT_X = 150;
    int ALIEN_INIT_Y = 5;

    int GO_DOWN = 15;
    int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    int CHANCE = 5;
    int PLAYER_WIDTH = 15;
    int PLAYER_HEIGHT = 10;
    
    //Direções pelas quais os monstros podem ir;
    int LEFT = 1;
    int RIGHT = 2;
    int UP = 3;
    int DOWN = 4;
    int DIAGONALPRIMARIAUP=5;
    int DIAGONALPRIMARIADOWN=6;
    int DIAGONALSECUNDARIAUP = 7;
    int DIAGONALSECUNDARIADOWN=8;
    
    
}

