package GridPaneParts;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HighScoreText {

	public static void AddHighScoreText(Text highscore, Pane HighScorePane) {
		
		highscore.setLayoutX(HighScorePane.getPrefWidth()*0.02);
		highscore.setLayoutY(HighScorePane.getPrefHeight()*0.15);
		HighScorePane.setStyle("-fx-font-size: 18 ;");
	}
}
