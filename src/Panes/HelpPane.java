package Panes;

import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
 import javafx.stage.Stage;



 public class HelpPane extends Pane {
	
	public void finalize() throws Throwable{
		super.finalize();
	}
	Scene scene;
	
	public HelpPane (double width, double height)
	{
		Pane gamePane = new GamePane(width, height);
		Pane cc = new ControlPane(width, height);
		BorderPane mainBorderPane = new BorderPane();
		getChildren().add(gamePane);

	
		//setPrefSize(width * 0.40, height);
		
		
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
	mainBorderPane.setTop(helpPane);
	
	//pane title (creating text)
	Text helpTitle = new Text (20,200, " HELP");
	
	//changing color, font, size of the text
	helpTitle.setFont((Font.font("Veranda", FontWeight.BOLD,20)));
	helpTitle.setFill( Color.BLACK);
	
	//tell the user their new balance
	Text info = new Text (300, 150, "hello welcome to the snake game!");
	
	//when the balance button is hit the seventh pane should show up
	mainBorderPane.setCenter(helpPane);
		
	//adding everything to pane. including some buttons created up in the beginning
	helpPane.getChildren().addAll(helpTitle,info);
	
			});  
	  }	
}






