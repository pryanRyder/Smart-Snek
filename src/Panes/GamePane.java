package Panes;

import java.util.Collection;

import Snake.Snake;
import Snake.SnakeManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Danny, Paul, Yara
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GamePane extends Pane {

	int p = 0;
	int q = 0;
	
	
	public SnakeManager m_SnakeManager;
	Snake snek = new Snake();

	
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	public GamePane(double width, double height)
	{
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setLayoutY(0);
		setStyle("-fx-background-color: '#6d6d6d';");
		
		
		Rectangle recs[][] = new Rectangle[25][15];
		GridPane gridpane = new GridPane();
		
				gridpane.setPadding(new Insets(5,5,5,5));

				
			for(int x = 0; x < recs.length; x++) {
				for(int y = 0; y < recs[x].length; y++) {
		
					Rectangle rec = new Rectangle();
					rec.setHeight(28);
					rec.setWidth(28);
					rec.setFill(Color.DARKCYAN);
					recs[x][y] = rec;
					
					gridpane.add(recs[x][y], x, y);
				}
			}
			
			
			
		    gridpane.setHgap(2);
		    gridpane.setVgap(2);
		    gridpane.relocate(80.0, 60.0);
		    gridpane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
		   
		    
		    snek.randomObjectiveItem();
		    snek.Sneek();
		    
		    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);
		    recs[snek.x][snek.y].setFill(Color.DARKMAGENTA);
		    
		    
		    Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
	
			KeyFrame keyframe = new KeyFrame(Duration.millis(500), action -> {
				
				
				recs[5][p++ + 3].setFill(Color.DARKMAGENTA);
				
			
				recs[5][q++].setFill(Color.DARKCYAN);
				
				
			});
	
			timeline.getKeyFrames().add(keyframe);
			timeline.play();
			
		getChildren().addAll(gridpane);

	}
}//end GamePane