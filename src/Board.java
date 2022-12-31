public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;

	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];


	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	
	public Board() {
		//TODO
		// Intialized board with all elements containing space character (' ')
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j=0; j < NUM_OF_COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public void printBoard() {
		//TODO
		for (int i=0; i < NUM_OF_ROW; i++) {
			for (int j=0; j< NUM_OF_COLUMNS; j++) {
				if (j==6) {
					System.out.print("|"+ board[i][j]+"|");
				}
				else {
					System.out.print("|"+board[i][j]);
				}
			}
			System.out.print("\n");
		}
	}
	
	public boolean containsWin() {
//		return false;
		//TODO

		// check horizontal direction
		for (int col=0; col < NUM_OF_COLUMNS - 3; col++) {
			for (int row=0; row < NUM_OF_ROW; row++) {
				if (board[row][col] == board[row][col + 1] &&
						board[row][col] == board[row][col + 2] &&
						board[row][col] == board[row][col + 3] &&
						board[row][col] != ' ') {
					return true;
				}
			}
		}

		// check vertical direction
		for (int col=0; col < NUM_OF_COLUMNS; col++) {
			for (int row=0; row < NUM_OF_ROW - 3; row++) {
				if (board[row][col] == board[row + 1][col] &&
						board[row][col] == board[row + 2][col] &&
						board[row][col] == board[row + 3][col] &&
						board[row][col] != ' ') {
					return true;
				}
			}
		}

		// check all diagonal directions

		// POSITIVE DIRECTION
		for (int col=0; col < NUM_OF_COLUMNS - 3; col++) {
			for (int row=3; row < NUM_OF_ROW; row++) {
				if (board[row][col] == board[row - 1][col + 1] &&
						board[row][col] == board[row - 2][col + 2] &&
						board[row][col] == board[row - 3][col + 3] &&
						board[row][col] != ' ') {
					return true;
				}
			}
		}

		// NEGATIVE DIRECTION
		for (int col=0; col < NUM_OF_COLUMNS - 3; col++) {
			for (int row=0; row < NUM_OF_ROW - 3; row++) {
				if (board[row][col] == board[row + 1][col + 1] &&
						board[row][col] == board[row + 2][col + 2] &&
						board[row][col] == board[row + 3][col + 3] &&
						board[row][col] != ' ') {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTie() {
		//TODO
		if (containsWin()){return false;}

		for (int col =0; col < NUM_OF_COLUMNS; col++) {
			for (int row = 0; row < NUM_OF_ROW; row++) {
				if (board[row][col] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		//TODO
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j=0; j < NUM_OF_COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public boolean validMove(int input) {
		// our array is 0 indexed so subtract input by 1
		// check if the topmost row has an element already
		return board[0][input - 1] == ' ';
	}

	public void addMove(int input, char symbol) {
		//check if bottom row is empty
		// our array is 0 indexed so subtract input by 1
		if (board[NUM_OF_ROW - 1][input - 1] == ' '){
			board[NUM_OF_ROW - 1][input - 1] = symbol;
			return;
		}
		for (int row = 0; row < NUM_OF_ROW - 1; row++) {
			if (board[row][input - 1] == ' ' && board[row + 1][input - 1] != ' '){
				board[row][input - 1] = symbol;
				return;
			}
		}
	}

	public int getNumCols() {
		return NUM_OF_COLUMNS;
	}

	public void undoMove(int col) {
		// our array is 0 indexed so subtract input by 1
		for (int row=0; row < NUM_OF_ROW; row++) {
			if (board[row][col - 1] != ' ') {
				board[row][col - 1] = ' ';
				return;
			}
		}
	}

	public char oppSymbol(char symbol) {
		for (int row=0; row < NUM_OF_ROW; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				if (board[row][col] != symbol && board[row][col] != ' ') {
					// System.out.println("Opp's Symbol: " + board[row][col]);
					return board[row][col];
				}
			}
		}
		// return space character if another symbol was not found (space character represents empty element in my array)
		return ' ';
	}
}
