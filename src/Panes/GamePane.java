package Panes;

import Snake.SnakeManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GamePane extends Pane {

	public SnakeManager m_SnakeManager;



	public void finalize() throws Throwable {
		super.finalize();
	}
	public GamePane(double width, double height)
	{
		//this is the GamePane
		
		Text Title = new Text("I am the Game Pane");
		this.getChildren().add(Title);
		this.setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		this.setLayoutX(width * 0.25);
		this.setLayoutY(0);
		this.setStyle("-fx-background-color: '#6d6d6d';");
		
		Pane content = new Pane();
		content.setPrefSize(this.getPrefWidth()*0.90, this.getPrefHeight()*0.90);
		content.setLayoutX(this.getPrefWidth()*0.05);
		content.setLayoutY(this.getPrefHeight()*0.05);
		content.setStyle("-fx-background-color: 'black'");
		this.getChildren().add(content);
	}
}//end GamePane