package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ScoreText {

	public static void AddScoreText(Text Score, Pane scorePane) {
		
		Score.setLayoutX(scorePane.getPrefWidth()*0.02);
		Score.setLayoutY(scorePane.getPrefHeight()*0.15);
		scorePane.setStyle("-fx-font-size: 18 ;");
	}
	
}
