package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 */

public class DisplayPane extends Pane {

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * @param width double 
	 * @param height double
	 * creates a pane called display pane
	 */
	public DisplayPane(double width, double height)
	{

		//this is the DisplayPane
		
		this.setPrefSize(width * 0.75, height * 0.25);
		
		//The top left corner of this pane is at (width * 0.25, height * 0.75)
		this.setLayoutX(width * 0.25);
		this.setLayoutY(height * 0.75);
		this.setStyle("-fx-background-color: '#4f4f4f';");

		setPrefSize(width * 0.75, height * 0.25);

		//The top left corner of this pane is at (width * 0.25, height * 0.75)
		setLayoutX(width * 0.25);
		setLayoutY(height * 0.75);
		setStyle("-fx-background-color: '#4f4f4f';");

		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.98, getPrefHeight()*0.90);
		content.setLayoutX(getPrefWidth()*0.001);
		content.setLayoutY(getPrefHeight()*0.05);
		content.setStyle("-fx-background-color: '#a5a5a5'");

		this.getChildren().add(content);

	}

}//end DisplayPane
