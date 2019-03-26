package GridPaneParts;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class IterationText {

	public static void AddIterationText(Text Iteration, Pane iterationPane) {
		
		Iteration.setLayoutX(iterationPane.getPrefWidth()*0.02);
		Iteration.setLayoutY(iterationPane.getPrefHeight()*0.15);
		iterationPane.setStyle("-fx-font-size: 18 ;");
	}
}
