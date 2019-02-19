package Panes;

import Snake.SnakeManager;
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
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setLayoutY(0);
		setStyle("-fx-background-color: '#6d6d6d';");
		
		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.90, getPrefHeight()*0.90);
		content.setLayoutX(getPrefWidth()*0.05);
		content.setLayoutY(getPrefHeight()*0.05);
		content.setStyle("-fx-background-color: 'black'");
		getChildren().add(content);

	}
}//end GamePane