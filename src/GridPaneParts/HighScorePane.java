package GridPaneParts;
	
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
	
public class HighScorePane {
	
	public static void AddHighScorePane(Pane HighScorePane, Pane gamePane, Text HighScoreString) {
			
			HighScorePane.setPrefSize(120, 115);
			HighScorePane.setLayoutX(gamePane.getPrefWidth()*0.25);
			HighScorePane.setLayoutY(gamePane.getPrefHeight()*1.1);
			
			HighScoreString.setLayoutX(HighScorePane.getPrefWidth()*0.25);
			HighScoreString.setLayoutY(HighScorePane.getPrefHeight()*0.6);
			HighScoreString.setFont(Font.font(35));
	}	
}