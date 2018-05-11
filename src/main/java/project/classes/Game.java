package project.classes;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
/**
 * Class handling the game play.
 */
public class Game {
	/**
	 * Logger Object for logging
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

	/**
	 * Entry point of the game.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		 String name1;
		 String name2;
		
		Scanner sc = new Scanner(System.in);
		State state = new State();
		
		MoveReader reader = new MoveReader();
		
		System.out.println("Enter name of first player: ");
		name1 = sc.nextLine();
		Player.PLAYER_X.setSymbol(name1);
		
		System.out.println("Enter name of second player: ");
		name2 = sc.nextLine();
		Player.PLAYER_O.setSymbol(name2);
		
		System.out.println(state);
		
		while (! state.isGameOver()) {
			Cell cellToMove = null;
			do {
				try {
					System.out.printf("%s's move: ", state.getCurrentPlayer().getSymbol());
					System.out.flush();
					if ((cellToMove = reader.readMove(state)) == null) {
						System.out.println("Game terminated");
						return;
					}
				} catch(IllegalMoveException e) {
					System.err.println(e.getMessage());
					LOGGER.error("Illegal move");
				}
			} while (cellToMove == null);
			System.out.println(cellToMove);
			state.move(cellToMove.getRow(), cellToMove.getCol());
			System.out.println(state);
		}
		if (state.getWinner() != null) {
			System.out.printf("%s won%n", state.getWinner().getSymbol());
			LOGGER.info("We have a winner");
		}
		else {
			System.out.println("Draw"); 
			LOGGER.info("Game is a draw");}
	}

}
