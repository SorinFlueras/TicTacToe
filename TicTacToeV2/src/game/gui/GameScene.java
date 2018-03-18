package game.gui;
import game.logic.Board;
import game.logic.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class GameScene extends Application {
    	private int turn = 0;
    	private int scoreXValue = 0;
    	private int scoreOValue = 0;
	private Board board = new Board(3);
	private Player playerX = new Player('X',board);
	private Player playerO = new Player('O',board);
	
	private Button btn0;
    private Button btn1;
    private Button btn2;
    
    private Button btn3;
    private Button btn4;
    private Button btn5;
    
    private Button btn6;
    private Button btn7;
    private Button btn8;
    
    private Button reset;
    private Button restart;
    
    private Label player1 = new Label("   PLAYER X:");
    private Label player2 = new Label("   PLAYER O:");
    private Label scoreX = new Label("	    0");
    private Label scoreO = new Label("	    0");
   
    private GridPane btnMatrix;
    
    
    
	public static void main(String[] args) {
        launch(args);
    }
	
    public void buttonsInit() {
    		btn0 = new Button();
        btn0.setMinSize(100, 100);
        btn1 = new Button();
        btn1.setMinSize(100, 100);
        btn2 = new Button();
        btn2.setMinSize(100, 100);
        
        btn3 = new Button();
        btn3.setMinSize(100, 100);
        btn4 = new Button();
        btn4.setMinSize(100, 100);
        btn5 = new Button();
        btn5.setMinSize(100, 100);
        
        btn6 = new Button();
        btn6.setMinSize(100, 100);
        btn7 = new Button();
        btn7.setMinSize(100, 100);
        btn8 = new Button();
        btn8.setMinSize(100, 100);
        
        reset = new Button("RESET");
        restart = new Button("RESTART");
        reset.setMinSize(100, 100);
        restart.setMinSize(100, 100);
    }
    
    public void checkWin() {
    		if(board.checkWinner() == 'X') {
			playerX.setScore(scoreXValue++);
			scoreX.setText("	    " + scoreXValue);
			reset.fire();            			
		}
		if(board.checkWinner() == 'O') {
			playerO.setScore(scoreOValue++);
			scoreO.setText("	    " + scoreOValue);
			reset.fire();
		}
		if(board.checkEmptyMoves() == false && board.checkWinner() == '%') {
			reset.fire();
		}
    }
    
    public void buttonAction() {
    		for( Node node: btnMatrix.getChildren()) {
    			if( node instanceof Button) {
    			
    				if(((Button) node).getText() == "") {
    					((Button) node).setOnAction(new EventHandler<ActionEvent>() {
    						@Override
        		            public void handle(ActionEvent event) {
        		            		if(turn % 2 == 0) {
            		            			((Button) node).setText("X");
            		            			board.setTiles(GridPane.getRowIndex(node),GridPane.getColumnIndex(node),playerX.getType());
            		            			((Button) node).setStyle("-fx-font: 40 arial;");
            		            			((Button) node).setDisable(true);
            		            			turn++;
            		            			checkWin();
            		            		}
            		            		else {
            		            			((Button) node).setText("O");
            		            			board.setTiles(GridPane.getRowIndex(node),GridPane.getColumnIndex(node),playerO.getType());
            		            			((Button) node).setStyle("-fx-font: 40 arial;");
            		            			((Button) node).setDisable(true);
            		            			turn++;
            		            			checkWin();
            		            		}
        		            		}
        		      	});
    				}
    				
    			}
    		}
    		reset.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            		for( Node node: btnMatrix.getChildren()) {
	            			if( node instanceof Button) {
	            				if(((Button) node).getText() == "X" || ((Button) node).getText() == "O") {
	            					((Button) node).setText("");
	            					((Button) node).setDisable(false);
	            				}
	            			}
	            		}
	            		board.initializeTiles();
	            		turn = 0;
	            }      
	   });
    		restart.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            		reset.fire();
	            		scoreXValue = 0;
	            		scoreOValue = 0;
	            		scoreO.setText("	    0");
	            		scoreX.setText("	    0");
	            }
	   });
    		
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("TicTacToe");
        buttonsInit();
       
        btnMatrix = new GridPane();
        btnMatrix.add(btn0, 0, 0);
        btnMatrix.add(btn1, 0, 1);
        btnMatrix.add(btn2, 0, 2);
        
        btnMatrix.add(btn3, 1, 0);
        btnMatrix.add(btn4, 1, 1);
        btnMatrix.add(btn5, 1, 2);
        
        btnMatrix.add(btn6, 2, 0);
        btnMatrix.add(btn7, 2, 1);
        btnMatrix.add(btn8, 2, 2);
        
        player1.setMinSize(100, 100);
        player2.setMinSize(100, 100);
        btnMatrix.add(player1, 0, 3);
        btnMatrix.add(player2, 0, 4);
        btnMatrix.add(scoreX, 1, 3);
        btnMatrix.add(scoreO, 1, 4);
        
        
        btnMatrix.add(reset, 2, 3);
        btnMatrix.add(restart, 2, 4);
        
        btnMatrix.setGridLinesVisible(true);
        
        buttonAction();
           
        StackPane root = new StackPane();
        root.getChildren().add(btnMatrix);
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }
}