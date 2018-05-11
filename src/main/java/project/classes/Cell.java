package project.classes;

/**
 * Class for wrapping information about a position on the board.
 */
public class Cell {

	/**
	 * Variables to hold value of row and column.
	 */
	int row, col;
	
	/**
	 * Creates a <code> Cell</code> object.
	 * @param row the value of the row of a <code> Cell</code>
	 * @param col the value of the column of a <code> Cell</code>
	 */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}


	/**
	 * Gets the column on which the <code> Cell</code> is.
	 * @return the value of the column the <code> Cell</code> is on.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Sets the column of <code> Cell</code>.
	 * @param col the value of the column of a <code> Cell</code>.
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Gets the row on which a <code> Cell</code> is.
	 * @return the value of the row the <code> Cell</code> is on.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the row of a <code> Cell</code>.
	 * @param row the value of the row of a <code> Cell</code>.
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Displays value of a row and column.
	 * @return String displaying the row and column values.
	 */
	public String toString() {
		return String.format("(%d,%d)", row, col);
	}
	
}
