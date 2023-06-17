import java.util.Random;

import api.Tile;
import hw3.ConnectGame;
import hw3.Grid;
import ui.GameConsole;

public class simpletest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectGame game = new ConnectGame (5, 20, 2, 6, new Random (0L));
		game.radomizeTiles();
		boolean lessThan;
		
		for (int x = 0; x < game.getGrid().getWidth(); x ++) {
			for(int y =0 ; y<game.getGrid().getHeight(); y++) {
				if(game.getGrid().getTile(x, y).getLevel() >= 6) {
					lessThan = false;
				}
			}
		}
		System.out.println();
		
		
		
	}

}
