package project.classes;

/**
 * Wraps information on the state of the game.
 */
public class State {
	
	/**
	 * Initial marker of all Cells on the board.
	 */
	private static final String EMPTY = "_";
	/**
	 * Red marker.
	 */
	private static final String RED = "R";
	/**
	 * Yellow marker.
	 */
	private static final String YELLOW = "Y";
	/**
	 * Green marker.
	 */
	private static final String GREEN = "G";

	/**
	 * The game board.
	 */
	private String[][] board = new String[][] {
		{EMPTY, EMPTY, EMPTY},
		{EMPTY, EMPTY, EMPTY},
		{EMPTY, EMPTY, EMPTY}
	};

	/**
	 * Holds number of moves made by the players.
	 */
	private int nOfMarks = 0;

	/**
	 * Player object with information on current player.
	 */
	private	Player currentPlayer = Player.PLAYER_X;

	/**
	 * Variable to indicate when game is over or not.
	 */
	private boolean	gameOver = false;

	/**
	 * Player object to hold information about the winner.
	 */
	private	Player winner = null;

	/**
	 * Gets the Player who's turn it is.
	 * @return Player object with information on the current player.
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Determines if game is over.
	 * @return true if game is over otherwise false.
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	
	/**
	 * Gets the winner of the game.
	 * @return Player object with information of the winning player.
	 */
	public Player getWinner() {
		return winner;
	}

	/**
	 * Records the move a player made.
	 * @param row the row moved to.
	 * @param col the column moved to.
	 */
	public void move(int row, int col) {
		if(board[row][col] == EMPTY) {
			board[row][col] = RED;
		}else if(board[row][col] == RED) {
			board[row][col] = YELLOW;
		}else if(board[row][col] == YELLOW) {
			board[row][col] = GREEN;
		}
		++nOfMarks;
		nextTurn(row, col);
	}

	/**
	 * Analyzes players move and hands over play to the next player.
	 * @param row the row moved by the player.
	 * @param col the column moved by the player.
	 */
	private void nextTurn(int row, int col) {
		final String symbol = GREEN;
		if ((board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol)
			|| (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol)
			|| (row == col && board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
				|| (col == 2 - row && board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			gameOver = true;
			winner = currentPlayer;
		} else if (nOfMarks == 9) {
			gameOver = true;
		}
		currentPlayer = currentPlayer.opponent();
	}
	
	/**
	 * Checks if a move is valid or not.
	 * @param row the row to move to.
	 * @param col the column to move to.
	 * @return true if the move is valid or false if it is not.
	 */
	public boolean isValidMove(int row, int col) {
		return row >= 0 && row < 3 && col >= 0 && col < 3 && (board[row][col] == EMPTY || board[row][col]==RED || board[row][col]==YELLOW);
	}
	
	/**
	 * Draws the board.
	 * @return String object with the board as its value.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				sb.append(board[row][col]).append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	/**
	 * Main method.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println(new State());
	}

	
}
