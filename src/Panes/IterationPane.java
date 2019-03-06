package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class IterationPane {

	public static void AddIterationPane(Pane iterationPane, Pane gamePane, Text iterationString) {
		
		iterationPane.setPrefSize(120, 115);
		iterationPane.setLayoutX(gamePane.getPrefWidth()*0.13);
		iterationPane.setLayoutY(gamePane.getPrefHeight()*1.1);
		
		iterationString.setLayoutX(iterationPane.getPrefWidth()*0.25);
		iterationString.setLayoutY(iterationPane.getPrefHeight()*0.6);
		iterationString.setFont(Font.font(35));
	}
	
}
