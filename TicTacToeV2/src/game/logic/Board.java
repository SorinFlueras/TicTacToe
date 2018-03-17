package game.logic;

/**
 * @author SorinFlueras
 *
 */
public class Board {
	private int boardSize; //e.g. boardSize = 3 for a 3x3 board
	private char tiles[][]; // array of tiles that form the Board
	
	public Board(int boardSize) {
		//no need to initialize the tiles here, since int is 0 by default
		this.boardSize = boardSize;
		tiles = new char[boardSize][boardSize];
		initializeTiles();
	}
	
	
	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public char[][] getTiles() {
		return tiles;
	}
	
	public void setTiles(int row, int column, char value) {
		tiles[row][column] = value;
	}

	//initialize tiles with empty moves (-) after game over
	public void initializeTiles() {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				tiles[i][j] = '-';
			}
		}
	}
	
	//if empty moves are found return true; else false
	public boolean checkEmptyMoves() {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if(tiles[i][j] == '-') {
					return true;
				}
			}
		}
		return false;
	}
	
	//return winner (X or O) or 0 for draw
	public char checkWinner(){
		//if counterRows, counterColumns, counterMainDiag or counterSecondaryDiag reaches 3 X or O won
		int counterRowsX = 0;
		int counterRowsO = 0;
		int counterColumnsX = 0;
		int counterColumnsO = 0;
		int counterMainDiagX = 0;
		int counterMainDiagO = 0;
		int counterSecondaryDiagX = 0;
		int counterSecondaryDiagO = 0;
		
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				// check for X on rows
				if(tiles[i][j] == 'X') {
					counterRowsX++;
				}
				// check for O on rows
				if(tiles[i][j] == 'O') {
					counterRowsO++;
				}
				// check for X on columns
				if(tiles[j][i] == 'X') {
					counterColumnsX++;
				}
				// check for O on columns
				if(tiles[j][i] == 'O') {
					counterColumnsO++;
				}
				//check for X on main diagonal
				if(tiles[i][j] == 'X' & i == j) {
					counterMainDiagX++;
				}
				//check for O on main diagonal
				if(tiles[i][j] == 'O' & i == j) {
					counterMainDiagO++;
				}
				//check for X on secondary diagonal
				if (tiles[i][j] == 'X' & i == Math.abs(j - 2)) {
					counterSecondaryDiagX++;
				}
				//check for O on secondary diagonal
				if (tiles[i][j] == 'O' & i == Math.abs(j - 2)) {
					counterSecondaryDiagO++;
				}
			}
		}
		if(counterRowsX == boardSize || counterColumnsX == boardSize || counterMainDiagX == boardSize || counterSecondaryDiagX == boardSize) {
			return 'X';
		}
		else if(counterRowsO == boardSize || counterColumnsO == boardSize || counterMainDiagO == boardSize || counterSecondaryDiagO == boardSize) {
			return 'O';
		}
		else {
			return 0; //draw
		}
	}
	
	public void display() {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				System.out.print(tiles[i][j] + " ");
			}
			System.out.println();
		}
	}
}
