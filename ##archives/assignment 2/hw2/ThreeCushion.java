package hw2;

import api.PlayerPosition;
import api.BallType;
import static api.PlayerPosition.*;

import java.util.Scanner;

import static api.BallType.*;

/**
 * Class that models the game of three-cushion billiards.
 * 
 * @author Nicholas Alexander Wang
 */
public class ThreeCushion {

	private static final PlayerPosition BallType = null;
	// TODO: EVERTHING ELSE GOES HERE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The method below is provided for you and you should not modify it.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.

	private BallType PLAYER_A_BALL; // Variable for the Player A's ball
	private BallType PLAYER_B_BALL; // Variable for the Player B's ball
	private BallType currentBall; // Variable for the Current player ball
	private PlayerPosition currentTurn; // Variable for the Current player identity

	private int PLAYER_A_POINTS; // Variable for the Player A's point
	private int PLAYER_B_POINTS; // Variable for the Player B's point

	private PlayerPosition lagWinner1; // Variable fot the lagging winner
	private int pointsToWinGame; // Variable for the total points to win the game

	private boolean shotTaken; // Variable for testing the shot if it has been taken

	private int numberOfImpactCushion; // Variable for the number of times the ball impacted the cushion
	private int numberOfImpactBall; // Variable for the number of times the ball impacted other balls
	private int inning; // Variable for counting the number of innings

	private boolean inningStart; // Variable for the inning started or stopped
	private boolean gameOver; // Variable for the game is over or not
	
	private int redHit; // Variable for the number of times the redBall has been hit
	private int lastHitBall; // Variable for how many times the last hit was a ball
	private boolean lagWinnerVerif; // Variable if the lagWinner has chosen the ball and the turn
	private boolean calledFoul; // Variable if foul(); has been called before
	private boolean firstHitRed; // Variable for if the first hit was red

	/**
	 * Constructs a Three cushion Billiards game. with the variables lagWinner and
	 * points to win. the lagwinner and points to win will be passed on as a
	 * variable to other methods
	 * 
	 * 
	 * Sets the pointsToWinGame to the input of the constructor
	 * <p>
	 * 
	 * Sets the PLAYER_A_BALL to an instance Variable
	 * <p>
	 * Sets the PLAYER_B_BALL to an instance Variable
	 * <p>
	 * Sets the currentTutn to an instance Variable
	 * <p>
	 * 
	 * Sets the shotTaken to an instance Variable
	 * <p>
	 * Sets the inning to 1 in an instance Variable
	 * <p>
	 * Sets the inningStart 1 to an instanve Variable
	 * <p>
	 * 
	 * Sets the redHit to 0 to an instance Variable
	 * <p>
	 * Sets the number of cushion impact to an instance variable
	 * <p>
	 * Sets the number of impact ball to an instance variable
	 * <p>
	 * Sets the lastHitBall to an instance Variable
	 * <p>
	 * Sets the lagWinnerVerification to false in an instance variable
	 * <p>
	 * Sets the gameOver to false in an instance Variable
	 * <p>
	 * Sets the firstHitRed to false in an instance Variable
	 * <p>
	 * 
	 * @param lagWinner The winner of the lag
	 * @param pointsToWin The number of points required
	 * @author Nicholas Alexander Wang
	 */
	public ThreeCushion(PlayerPosition lagWinner, int pointsToWin) {
		lagWinner1 = lagWinner; // Sets the lagWinner1 to the input of the constructor
		pointsToWinGame = pointsToWin; // Sets the pointsToWinGame to the input of the constructor

		PLAYER_A_BALL = null; // Sets the PLAYER_A_BALL to an instance Variable
		PLAYER_B_BALL = null; // Sets the PLAYER_B_BALL to an instance Variable
		PLAYER_A_POINTS = 0;
		PLAYER_B_POINTS = 0;

		currentTurn = null; // Sets the currentTutn to an instance Variable

		shotTaken = false; // Sets the shotTaken to an instance Variable
		inning = 1; // Sets the inning to 1 in an instance Variable
		inningStart = false; // Sets the inningStart 1 to an instanve Variable

		redHit = 0; // Sets the redHit to 0 to an instance Variable
		numberOfImpactCushion = 0; // Sets the number of cushion impact to an instance variable
		numberOfImpactBall = 0; // Sets the number of impact ball to an instance variable

		lastHitBall = 0; // Sets the lastHitBall to an instance Variable
		lagWinnerVerif = false; // Sets the lagWinnerVerification to false in an instance variable
		gameOver = false; // Sets the gameOver to false in an instance Variable
		firstHitRed = false; // Sets the firstHitRed to false in an instance Variable
	}

	/**
	 * Counting the number of times the ball has impacted the cushion, if the shot
	 * has been taken, and the game is not over.
	 * 
	 * Checks if in the break shot the cue ball does not hit the red ball
	 * 
	 * @author Nicholas Alexander Wang
	 */
	public void cueBallImpactCushion() {

		if (shotTaken == true && !gameOver) {
			numberOfImpactCushion += 1;
			lastHitBall = 0;

			if (!firstHitRed && inning == 1) {
				foul();

			}
		}
	}

	/**
	 * Indicates that the cueball has hit the other balls. Checks if the first shot
	 * is red ball and if the cushion was hit before. Checks if the first hit in the
	 * inning is not red, then its a foul.
	 * 
	 * @param ball the ball that is hit by the cue ball
	 * @author Nicholas Alexander Wang
	 */
	public void cueBallStrike(BallType ball) {

		if (shotTaken && !gameOver) {

			if (ball == RED) {
				redHit += 1;

				if (numberOfImpactBall == 0 && numberOfImpactCushion == 0) {
					firstHitRed = true;
				}

			}
			if (!firstHitRed && inning == 1) {
				foul();

			}
			numberOfImpactBall += 1;
			lastHitBall += 1;

		}

	}

	/**
	 * Indicates that the cueStick has hit the ball
	 * <p>
	 * 
	 * Checks if the game is over and if the lag winner has chosen the ball and the
	 * turn
	 * <p>
	 * Checks if the shot is taken, and Checks if the Stick has hit the correct ball
	 * for the player (PLAYER_A/B_BALL)<br>
	 * if true then starts the inning, and take the shot
	 * <p>
	 * 
	 * if the stick hit the wrong ball, then its a foul.
	 * 
	 * @param ball the ball that is hit by the stick
	 * @author Nicholas Alexander Wang
	 */
	public void cueStickStrike(BallType ball) {

		inningStart = false;
		if (!gameOver && lagWinnerVerif) {

			numberOfImpactBall = 0;
			numberOfImpactCushion = 0;
			redHit = 0;

			if (shotTaken == false) {
				if (currentBall == ball) {
					shotTaken = true;
					inningStart = true;
					calledFoul = false;
				} else {
					foul();

				}
			}
		}
	}

	/**
	 * indicates that the shot has ended
	 * <p>
	 * Checks if the game is over and if the lag winner has chosen the ball and the
	 * turn <br>
	 * Checks if the shot is taken, if so then stops the shot <br>
	 * 
	 * Checks the current inning's player<br>
	 * if the Player scored then adds a point to their score, if the score hits the
	 * points to win, sets the gameover to true <br>
	 * if the Player does not score, and foul has not been called before this
	 * inning, if not then calls a foul
	 * 
	 * @author Nicholas Alexander Wang
	 */
	public void endShot() {

		if (!gameOver && lagWinnerVerif) {
			if (shotTaken) {
				shotTaken = false;

				if (currentTurn == PLAYER_A) {
					if (numberOfImpactCushion >= 3 && numberOfImpactBall >= 2 && lastHitBall >= 1) {
						PLAYER_A_POINTS += 1;
						if (PLAYER_A_POINTS == pointsToWinGame) {
							gameOver = true;
						}

						// what happens when hit the correct ball
					} else {
						// what happens when hit the wrong ball / not score
						if (!calledFoul) {
							foul();
						}
					}
				} else if (currentTurn == PLAYER_B) {

					if (numberOfImpactCushion >= 3 && numberOfImpactBall >= 2 && lastHitBall >= 1) {
						PLAYER_B_POINTS += 1;
						if (PLAYER_B_POINTS == pointsToWinGame) {
							gameOver = true;
						}

						// what happens when hit the correct ball

					} else {
						// what happens when hit the wrong ball / not score
						if (!calledFoul) {
							foul();
						}
					}
				}
			}

		}
	}

	/**
	 * Indicates that a foul has happened
	 * <p>
	 * Checks if game over is false<br>
	 * If so changes the current turn and the current ball<br>
	 * adds an inning, and stops the inning
	 * 
	 * @author Nicholas Alexander Wang
	 */
	public void foul() {
		// inning itu tambah kalo misal lagi
		// salah dan dia pemain kedua
		if (!gameOver) {
			if (currentTurn == PLAYER_A) {
				currentTurn = PLAYER_B;
				currentBall = PLAYER_B_BALL;
				inning += 1;
			} else if (currentTurn == PLAYER_B) {
				currentTurn = PLAYER_A;
				currentBall = PLAYER_A_BALL;
				inning += 1;
			}
			inningStart = false;
			calledFoul = true;
		}

	}

	/**
	 * @author Nicholas Alexander Wang
	 * @return Returns the current player cueBall
	 */
	public BallType getCueBall() {
		return currentBall;
	}

	/**
	 * 
	 * @return The current Inning count
	 * @author Nicholas Alexander Wang
	 */
	public int getInning() {
		return inning;
	}

	/**
	 * 
	 * @return Current player turn
	 * @author Nicholas Alexander Wang
	 */
	public PlayerPosition getInningPlayer() {
		return currentTurn;

	}

	/**
	 * 
	 * @return Score of PLAYER A
	 * @author Nicholas Alexander Wang
	 */
	public int getPlayerAScore() {
		return PLAYER_A_POINTS;

	}

	/**
	 * @author Nicholas Alexander Wang
	 * @return Score of PLAYER B
	 */
	public int getPlayerBScore() {
		return PLAYER_B_POINTS;
	}

	/**
	 * If hits the cushion 3 times and hit both balls with a different color
	 * 
	 * @return true if it is a bankShot
	 * @author Nicholas Alexander Wang
	 */
	public boolean isBankShot() {
		boolean res = false;
		if (numberOfImpactCushion >= 3 && lastHitBall >= 2 && redHit == 1) {
			res = true;
		}

		return res;
	}

	/**
	 * If the inning count is 1
	 * 
	 * @return true if it is a break shot
	 * @author Nicholas Alexander Wang
	 */
	public boolean isBreakShot() {
		boolean res = false;

		if (inning == 1) {
			res = true;
		}
		return res;
	}

	/**
	 * Game is over when the point has reached the points required to win in the
	 * constructor
	 * 
	 * @return if game is over then true
	 * @author Nicholas Alexander Wang
	 */
	public boolean isGameOver() {

		return gameOver;
	}

	/**
	 * The inning is started when the cue stick strikes the correct ball, and stops
	 * when it changes players
	 * 
	 * @return true if inning started, false if stopped
	 * @author Nicholas Alexander Wang
	 */
	public boolean isInningStarted() {
		return inningStart;
	}

	/**
	 * The shot is started when the player's stick hits the correct ball and stops
	 * when endshot is initiated
	 * 
	 * @return true if shot started (cuestickstrike), false if shot ended (endshot)
	 */
	public boolean isShotStarted() {
		return shotTaken;
	}

	/**
	 * The lag winner chooses wether they self break or not, and the ball they
	 * choose for themself
	 * <p>
	 * 
	 * If the lagWinner chooses to selfbreak, then the current Inning is given
	 * lagWinner, <br>
	 * If the lagWinner chooses to not selfBreak, then the current Inning is given
	 * to the player other than the other lagWinner.
	 * <P>
	 * 
	 * @param selfBreak if true then current Inning is the lag winner
	 * @param cueBall   The cueball is given to the lag winner
	 */
	public void lagWinnerChooses(boolean selfBreak, BallType cueBall) {

		lagWinnerVerif = true;

		if (selfBreak) {
			currentTurn = lagWinner1;

			if (lagWinner1 == PLAYER_A) {

				PLAYER_A_BALL = cueBall;
				if (PLAYER_A_BALL == WHITE) {
					PLAYER_B_BALL = YELLOW;
				} else {
					PLAYER_B_BALL = WHITE;
				}

				currentBall = PLAYER_A_BALL;
			} else if (lagWinner1 == PLAYER_B) {
				PLAYER_B_BALL = cueBall;
				if (PLAYER_B_BALL == WHITE) {
					PLAYER_A_BALL = YELLOW;
				} else {
					PLAYER_A_BALL = WHITE;
				}

				currentBall = PLAYER_B_BALL;
			}

		} else if (!selfBreak) {

			if (lagWinner1 == PLAYER_A) {
				currentTurn = PLAYER_B;

				PLAYER_A_BALL = cueBall;
				if (PLAYER_A_BALL == WHITE) {
					PLAYER_B_BALL = YELLOW;
				} else {
					PLAYER_B_BALL = WHITE;
				}

				currentBall = PLAYER_B_BALL;
			} else if (lagWinner1 == PLAYER_B) {
				currentTurn = PLAYER_A;

				PLAYER_B_BALL = cueBall;
				if (PLAYER_B_BALL == WHITE) {
					PLAYER_A_BALL = YELLOW;
				} else {
					PLAYER_A_BALL = WHITE;
				}

				currentBall = PLAYER_A_BALL;
			}

		}

	}

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player A*: X Player B: Y, Inning: Z</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which player is at the
	 * table this inning. The number after the player's name is their score. Z is
	 * the inning number. Other messages will appear at the end of the string.
	 * 
	 * @return one-line string representation of the game state
	 */

	public String toString() {
		String fmt = "Player A%s: %d, Player B%s: %d, Inning: %d %s%s";
		String playerATurn = "";
		String playerBTurn = "";
		String inningStatus = "";
		String gameStatus = "";
		if (getInningPlayer() == PLAYER_A) {
			playerATurn = "*";
		} else if (getInningPlayer() == PLAYER_B) {
			playerBTurn = "*";
		}
		if (isInningStarted()) {
			inningStatus = "started";
		} else {
			inningStatus = "not started";
		}
		if (isGameOver()) {
			gameStatus = ", game result final";
		}
		return String.format(fmt, playerATurn, getPlayerAScore(), playerBTurn, getPlayerBScore(), getInning(),
				inningStatus, gameStatus);
	}
}
