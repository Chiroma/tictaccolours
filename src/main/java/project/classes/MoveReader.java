package project.classes;

import java.util.Scanner;

/**
 * Handles players' moves.
 */
public class MoveReader {

	/**
	 * Object to get player inputs.
	 */
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Reads players input into the appropriate Cell.
	 * @param state the current state of the game.
	 * @return Cell object with information on the row and column the player chose.
	 */
	public Cell readMove(State state) {
		if (state.isGameOver())
			throw new IllegalStateException("Game over");
		try {
			if (! scanner.hasNextLine())
				return null;
			String[] tokens = scanner.nextLine().trim().split("\\s+");
			if (tokens.length != 2)
				throw new IllegalMoveException("Invalid input");
			int row = Integer.parseInt(tokens[0]) - 1;
			int col = Integer.parseInt(tokens[1]) - 1;
			if (! state.isValidMove(row, col))
				throw new IllegalMoveException("The square is out of bounds or non-empty");
			return new Cell(row, col);
		} catch (NumberFormatException e) {
			throw new IllegalMoveException("Invalid input");
		}
	}
}
