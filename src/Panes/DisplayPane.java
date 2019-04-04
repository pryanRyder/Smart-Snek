package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class DisplayPane extends Pane {
//<<<<<<< HEAD

//=======
//>>>>>>> Danny



	public void finalize() throws Throwable {
		super.finalize();
	}
	public DisplayPane(double width, double height)
	{
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
		getChildren().add(content);
		
		Text Title = new Text("Display Panel");
		Title.setStyle("-fx-font-size: 20;");// NEEDS TO BE CHANGED BASED ON SIZE
		Title.setLayoutX(content.getPrefWidth()*0.01);
		Title.setLayoutY(content.getPrefHeight()*0.15);
		content.getChildren().add(Title);

		
		

	}
}//end DisplayPane