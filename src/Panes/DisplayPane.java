package Panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class DisplayPane extends Pane {

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

	/*
		Pane scorePane = new Pane();
		Text Score = new Text("Score");
		scorePane.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		scorePane.setPrefSize(120, 115);
		scorePane.setLayoutX(10);
		scorePane.setLayoutY(30);

		int x = snekScore.ateObjectiveItem();

	    Text aString = new Text(Integer.toString(x));
	    aString.setLayoutX(scorePane.getPrefWidth()*0.4);
	    aString.setLayoutY(scorePane.getPrefWidth()*0.5);
	    aString.setFont(Font.font(35));


		Score.setLayoutX(scorePane.getPrefWidth()*0.02);
		Score.setLayoutY(scorePane.getPrefHeight()*0.15);
		scorePane.setStyle("-fx-font-size: 18 ;");
		scorePane.getChildren().addAll(Score, aString);
		content.getChildren().add(scorePane);
	 */



	}

}//end DisplayPane
