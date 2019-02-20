package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class ControlPane extends Pane {



	public void finalize() throws Throwable {
		super.finalize();
	}
	public ControlPane(double width, double height)
	{
		setPrefSize(width * 0.25, height);
		
		//The top left corner of this pane is at (0, 0)
		setLayoutX(0);
		setLayoutY(0);
		setStyle("-fx-background-color: '#4f4f4f';");
		
		//Pane inside of ControlPane
		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.95, getPrefHeight()*0.975);
		content.setLayoutX(getPrefWidth()*0.02);
		content.setLayoutY(getPrefHeight()*0.01);
		content.setStyle("-fx-background-color: '#a5a5a5'");
		getChildren().add(content);
		
		Text Title = new Text("Control Panel");
		Title.setStyle("-fx-font-size: 20;"); // NEEDS TO BE CHANGED BASED ON SIZE
		Title.setLayoutX(content.getPrefWidth()*0.04);
		Title.setLayoutY(content.getPrefHeight()*0.04);
		//Title.setLayoutX(value);
		//Title.setLayoutY();
		content.getChildren().add(Title);
		



	}
}//end ControlPane