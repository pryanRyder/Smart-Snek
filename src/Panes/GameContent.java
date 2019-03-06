package Panes;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameContent {

	public static void AddGameContent(GamePane gamePane, GridPane gridpane, double width, double height,
			Rectangle recs[][], Text stringScore, Text iterationString) {
		
		
		Text Title = new Text("I am the Game Pane");
		gamePane.getChildren().add(Title);
		gamePane.setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		gamePane.setLayoutX(width * 0.25);
		gamePane.setLayoutY(0);
		gamePane.setStyle("-fx-background-color: '#6d6d6d';");
		
		MakeGridPane.MakeTheGridPane(gamePane, gridpane, recs);
		    
		gridpane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
		   
		    /*
		    snek.randomObjectiveItem();
		   // snek.Sneek();
		    
		    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);
		    //recs[snek.x][snek.y].setFill(Color.DARKMAGENTA);
		    
		    for(int i = 0; i < snek.Positions.size(); i++)
		    {
		    	recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(Color.WHITE);
		    }
		    */
		    GameContentParts.AddGameContentParts(stringScore, gamePane, iterationString, gridpane);
	}
	
}