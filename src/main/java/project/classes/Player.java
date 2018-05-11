package project.classes;

/**
 * Class wrapping player information and Switching play.
 */
public enum Player {
	
	/**
	 * First player.
	 */
	PLAYER_X(""),
	/**
	 * Second player.
	 */
	PLAYER_O("");
	
	/**
	 * Identifies a player.
	 */
	private String symbol;

	/**
	 * Creates a <code>Player </code>object.
	 * @param symbol String to identify a player.
	 */
	private Player(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Gets the symbol identifying a player.
	 * @return String which identifies a player.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol identifying a player.
	 * @param symbol String to identify a player.
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	/**
	 * Switches play between Players.
	 * @return Player who will be the current player.
	 */
	public Player opponent() {
		switch(this) {
			case PLAYER_X:
				return PLAYER_O;
			case PLAYER_O:
				return PLAYER_X;
		}
		throw new AssertionError();
	}


}
