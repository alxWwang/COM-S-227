package hw2;

import static api.BallType.RED;

import static api.BallType.WHITE;
import static api.BallType.YELLOW;
import static api.PlayerPosition.PLAYER_A;
import static api.PlayerPosition.PLAYER_B;


public class SimpleTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeCushion game = new ThreeCushion(PLAYER_A, 3);
		
		game.lagWinnerChooses(true,YELLOW);
		game.cueStickStrike(WHITE);
		System.out.println(game.getCueBall());
		System.out.println(game.isBreakShot());

	}

}
