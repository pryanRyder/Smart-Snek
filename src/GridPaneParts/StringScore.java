package GridPaneParts;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StringScore {

	public static void AddStringScore(Text stringScore, Pane gamePane, Pane scorePane) {
		
		scorePane.setPrefSize(120, 115);
	    scorePane.setLayoutX(gamePane.getPrefWidth()*0.05);
		scorePane.setLayoutY(gamePane.getPrefHeight()*1.1);	
		
	    stringScore.setLayoutX(scorePane.getPrefWidth()*0.25);
	    stringScore.setLayoutY(scorePane.getPrefHeight()*0.6);
	    stringScore.setFont(Font.font(35));
	}
	
	
}
