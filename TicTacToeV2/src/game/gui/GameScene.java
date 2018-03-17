package game.gui;
import game.resources.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class GameScene extends Application {
    	private int turn = 0;
	
	private Button btn0;
    private Button btn1;
    private Button btn2;
    
    private Button btn3;
    private Button btn4;
    private Button btn5;
    
    private Button btn6;
    private Button btn7;
    private Button btn8;
    
    private Image[] imageX = new Image[9];
    private Image[] imageO = new Image[9];
    private ImageView[] imageViewX = new ImageView[9];
    private ImageView[] imageViewO = new ImageView[9];
    
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
    }
    
    public void imagesInit() {
    		
		for(int i = 0; i < 9; i++) {
			imageX[i] = new Image("game/resources/X.png",true);
			imageO[i] = new Image("game/resources/O.png",true);
        		imageViewX[i] = new ImageView();
        		imageViewX[i].setImage(imageX[i]);
        		imageViewX[i].setFitWidth(100);
        		imageViewX[i].setFitHeight(100);
        		imageViewO[i] = new ImageView();
        		imageViewO[i].setImage(imageO[i]);
        		imageViewO[i].setFitWidth(100);
        		imageViewO[i].setFitHeight(100);
    		}
    }
    
    public void buttonAction() {
    		for( Node node: btnMatrix.getChildren()) {

    			if( node instanceof Button) {
    				((Button) node).setOnAction(new EventHandler<ActionEvent>() {
    		            @Override
    		            public void handle(ActionEvent event) {
    		            		int i = 0;
    		            		if(turn % 2 == 0) {
    		            			((Button) node).setGraphic(imageViewX[i]);
    		            			((Button) node).setDisable(true);
    		            			turn++;
    		            			i++;
    		            		}
    		            		else {
    		            			((Button) node).setGraphic(imageViewO[i]);
    		            			((Button) node).setDisable(true);
    		            			turn++;
    		            			i++;
    		            		}
    		            }
    		        });
    			}
    		}
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("TicTacToe");
        buttonsInit();
        imagesInit();
       
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
        
        btnMatrix.setGridLinesVisible(true);
        
        buttonAction();
        
        StackPane root = new StackPane();
        root.getChildren().add(btnMatrix);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}