package project.classes;

/**
 * Class handling illegal moves in the game.
 */
public class IllegalMoveException extends RuntimeException{

	private static final long serialVersionUID = -6444118508034207252L;

	/**
	 * Creates a <code>IllegalMoveException</code> object with a message as parameter.
	 * @param s exception message.
	 */
	public IllegalMoveException(String s) {
		super(s);
	}
}
