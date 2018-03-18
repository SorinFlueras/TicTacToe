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
		int counterX = 0;
		int counterO = 0;
			//check for X and O on rows
			for(int y = 0; y < boardSize; y++) {
				if(tiles[y][0] == 'X') {
					for(int z = 1; z < boardSize; z++) {	
						if(tiles[y][0] == tiles[y][z]) {
							counterX++;
						}
					}
					if(counterX == 2) {
						return 'X';
					}
					else {
						counterX = 0;
					}
				}
				else if(tiles[y][0] == 'O') {
					for(int z = 1; z < boardSize; z++) {	
						if(tiles[y][0] == tiles[y][z]) {
							counterO++;
						}
					}
					if(counterO == 2) {
						return 'O';
					}
					else {
						counterO = 0;
					}
				}
			}
			// check for X and O on columns
			for(int y = 0; y < boardSize; y++) {
				if(tiles[0][y] == 'X') {
					for(int z = 1; z < boardSize; z++) {	
						if(tiles[0][y] == tiles[z][y]) {
							counterX++;
						}
					}
					if(counterX == 2) {
						return 'X';
					}
					else {
						counterX = 0;
					}
				}
				if(tiles[0][y] == 'O') {
					for(int z = 1; z < boardSize; z++) {	
						if(tiles[0][y] == tiles[z][y]) {
							counterO++;
						}
					}
					if(counterO == 2) {
						return 'O';
					}
					else {
						counterO = 0;
					}
				}
			}
			//check for X and O on main diagonal
			for(int y = 0; y < boardSize; y++) {
				if(tiles[y][y] == 'X') {	
					counterX++;
				}
			    if(tiles[y][y] == 'O') {	
					counterO++;
				}
			    
			}
			if(counterX == 3) {
				return 'X';
			}
			else {
				counterX = 0;
			}
			if(counterO == 3) {
				return 'O';
			}
			else {
				counterO = 0;
			}
			//check for X and O on secondary diagonal
			for(int y = 0, z = boardSize - 1; y < boardSize && z >= 0; y++, z--) {
				if(tiles[y][z] == 'X') {
					counterX++;
				}
				if(tiles[y][z] == 'O') {
					counterO++;
				}
			}
			if(counterX == 3) {
				return 'X';
			}
			else {
				counterX = 0;
			}
			if(counterO == 3) {
				return 'O';
			}
			else {
				counterO = 0;
			}
		return '%';
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
