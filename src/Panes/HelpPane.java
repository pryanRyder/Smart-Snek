package Panes;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;




 public class HelpPane extends Pane {
	
	public void finalize() throws Throwable{
		super.finalize();
	}
	Scene scene;
	
	public HelpPane (double width, double height)
	{
		Pane gamePane = new GamePane(width, height);
		Pane cc = new ControlPane(width, height);
		//BorderPane mainBorderPane = new BorderPane();
		getChildren().add(gamePane);
	
		//create buttons
		Button help = new Button (" ? ");
		//change buttons background color
		help.setStyle("-fx-background-color: white");
		
		//change location of buttons
		help.setLayoutX(gamePane.getPrefWidth()*0.85);
		help.setLayoutY(gamePane.getPrefHeight()*.1	);
		gamePane.getChildren().add(help);
		help.setStyle("-fx-font-size: 20;");
		
	  help.setOnAction(ex-> {
		
	//create eighth pane, this occurs when the Balance button is clicked
	Pane helpPane = new Pane();
	cc.getChildren().add(helpPane);
	
	

	
	final String aText =  " ☻ To move your Snek use your arrow keys  ";
	      String bText =  " ☻ Click 'Upload Net' to upload a .nn file and click 'Save'  ";
	      String cText =  " ☻ To create a network click 'Create Network ";
	      String dText =  " ☻ Click on the 'Static AI' button then click on 'Start Game' button down below, If the snake dies the game will automatically restart and the iteration count "
	      + "will go up by 1";
	      String eText =  " ☻  The Snek gains points by eating the apples, It loses point by hitting the wall.  ";
	      String fText =  " ☻  The points can be tracked in the display panel ";
	      String gText =  " ☻  The 'DQN' button Sets the agent to run the DQN Algorithm ";
	     
	Alert popup = new Alert(Alert.AlertType.INFORMATION, aText + "\n" + bText + "\n" + cText + "\n" + dText   + "\n" + eText  + "\n" + fText + "\n" + gText, ButtonType.OK);
	
	popup.setHeaderText("Need Help?");
	popup.setTitle("Help");
	popup.showAndWait();
	
	
			});  
	  }	
}






