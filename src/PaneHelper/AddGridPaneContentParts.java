package PaneHelper;

import GridPaneParts.*;
import Panes.GamePane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AddGridPaneContentParts {

	public static void addGridPaneContentParts(Text stringScore, GamePane gamePane, Text iterationString, GridPane gridpane, Text hig) {
		
	    Pane scorePane = new Pane();
	    StringScore.AddStringScore(stringScore, gamePane, scorePane);		    
	    
		Text Score = new Text("Score");
		ScoreText.AddScoreText(Score, scorePane);
		
//	 Paul Stuff
		Pane highScorePane = new Pane();
		HighScorePane.AddHighScorePane(highScorePane, gamePane, hig);
		
		
		Text HighScoreString = new Text("HighScore");
		HighScoreText.AddHighScoreText(HighScoreString, highScorePane);
		
		highScorePane.getChildren().addAll(hig, HighScoreString);
//
		
		
		scorePane.getChildren().addAll(Score, stringScore);
		
		Pane iterationPane = new Pane();
		IterationPane.AddIterationPane(iterationPane, gamePane, iterationString);

		
		Text Iteration = new Text("Iterations");
		IterationText.AddIterationText(Iteration, iterationPane);
		iterationPane.getChildren().addAll(Iteration, iterationString);
		
		gamePane.getChildren().addAll(gridpane, scorePane, iterationPane, highScorePane);
	}
	
}