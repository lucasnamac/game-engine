package freezemonster;

import java.awt.EventQueue;

import Framework.AbstractBoard;
import Framework.MainFrame;

public class FrezeeMonsterGame extends MainFrame {


	public FrezeeMonsterGame () {
		super("Freeze Monsters");
	}
	
        @Override
	protected  AbstractBoard createBoard() {
		return new FreezeMonsterBoard();
	}

	public static void main(String[] args) {
                EventQueue.invokeLater(() -> {

			new FrezeeMonsterGame();
		});
	}

}