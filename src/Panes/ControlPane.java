package Panes;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

/**
 * @author Danny
 * @version 1.0
 */
public class ControlPane extends Pane {
	
	boolean GAChecked = false;


	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * @param width double 
	 * @param height double
	 * creates a pane called Control pane
	 */
	public ControlPane(double width, double height)
	{


		//this is the ControlPane
		
		this.setPrefSize(width * 0.25, height);
		


		Pane gamePane = new GamePane(width, height);
		getChildren().add(gamePane);
		

		setPrefSize(width * 0.25, height);


		//The top left corner of this pane is at (0, 0)
		this.setLayoutX(0);
		this.setLayoutY(0);
		this.setStyle("-fx-background-color: '#4f4f4f';");
		
		//Pane inside of ControlPane
		Pane content = new Pane();
		content.setPrefSize(this.getPrefWidth()*0.95, this.getPrefHeight()*0.975);
		content.setLayoutX(this.getPrefWidth()*0.02);
		content.setLayoutY(this.getPrefHeight()*0.01);
		content.setStyle("-fx-background-color: '#a5a5a5'");

		this.getChildren().add(content);
		
		//Title.setLayoutX(value);
		//Title.setLayoutY();


	}
}//end ControlPane