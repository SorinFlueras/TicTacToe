package game.logic;

public class Player {
	private char type; //X or O
	private int score;
	private Board board;
	
	public Player(char type, Board board) {
		this.type = type;
		this.board = board;
		score = 0;
	}
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void move(int row, int column) {
		//if empty moves are available
		if(board.checkEmptyMoves()) {
			// determine player's type
			switch(this.type) {
				case 'X': board.setTiles(row,column,'X'); break;
				case 'O': board.setTiles(row,column,'O'); break;
				default: System.err.println("Invalid player type");
			}
		}
	}
	
	public void increaseScore() {
		if(board.checkWinner() == 'X' || board.checkWinner() == 'O') {
			score++;
		}
	}
	
	public void initialize() {
		score = 0;
	}
}
