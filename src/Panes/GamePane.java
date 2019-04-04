package Panes;

import java.util.Collection;

import Agent.SnakeBrain;
import Snake.CurrentDirection;
import Snake.Snake;
import Snake.SnakeManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
	
	boolean onlyOneDirection = true;
	Rectangle recs[][] = new Rectangle[25][15];
	Scene scene;

	
	public SnakeManager m_SnakeManager;
	Snake snek = new Snake();
    SnakeBrain snakeBrain = new SnakeBrain(snek);


	
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	public GamePane(double width, double height)
	{
		this.scene = scene;
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setLayoutY(0);
		setStyle("-fx-background-color: '#6d6d6d';");
		
		Pane displayPane = new DisplayPane(width, height);
		getChildren().add(displayPane);		
		
		
		GridPane gridpane = new GridPane();
		
		gridpane.setPadding(new Insets(5,5,5,5));

			
			for(int x = 0; x < recs.length; x++) {
				for(int y = 0; y < recs[x].length; y++) {
		
					Rectangle rec = new Rectangle();
					rec.setHeight(28);
					rec.setWidth(28);
					rec.setFill(Color.BLACK);
					recs[x][y] = rec;
					
					gridpane.add(recs[x][y], x, y);
				}
			}
			
			
			
		    gridpane.setHgap(2);
		    gridpane.setVgap(2);
		    gridpane.relocate(80.0, 60.0);
		    gridpane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		   
		    
		    
		    snek.randomObjectiveItem();
		   // snek.Sneek();
		    
		    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);
		    //recs[snek.x][snek.y].setFill(Color.DARKMAGENTA);
		    
		    for(int i = 0; i < snek.Positions.size(); i++)
		    {
		    	recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(Color.WHITE);
		    }
		    
		    
		    Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
	
			KeyFrame keyframe = new KeyFrame(Duration.millis(75), action -> 
			{
				onlyOneDirection = true;
				
				getScene().setOnKeyPressed(e ->
				{	if(onlyOneDirection)
					{
						if(e.getCode() == KeyCode.A && snek.m_CurrentDirection != CurrentDirection.RIGHT)
						{
							snek.changeDirection(CurrentDirection.LEFT);
							System.out.println("LEFT");
							onlyOneDirection = false;
						}
						else if(e.getCode() == KeyCode.D && snek.m_CurrentDirection != CurrentDirection.LEFT)
						{
							snek.changeDirection(CurrentDirection.RIGHT);
							System.out.println("RIGHT");
							onlyOneDirection = false;

						}
						else if(e.getCode() == KeyCode.S && snek.m_CurrentDirection != CurrentDirection.UP)
						{
							snek.changeDirection(CurrentDirection.DOWN);
							System.out.println("DOWN");
							onlyOneDirection = false;
			
						}
						else if(e.getCode() == KeyCode.W && snek.m_CurrentDirection != CurrentDirection.DOWN)
						{
							snek.changeDirection(CurrentDirection.UP);
							System.out.println("UP");
							onlyOneDirection = false;
			
						}
						
						else if(e.getCode() == KeyCode.LEFT && snek.m_CurrentDirection != CurrentDirection.RIGHT)
						{
							snek.changeDirection(CurrentDirection.LEFT);
							System.out.println("LEFT");
							onlyOneDirection = false;
			
			
						}
						else if(e.getCode() == KeyCode.RIGHT && snek.m_CurrentDirection != CurrentDirection.LEFT)
						{
							snek.changeDirection(CurrentDirection.RIGHT);
							System.out.println("RIGHT");
							onlyOneDirection = false;
			
						}
						else if(e.getCode() == KeyCode.DOWN && snek.m_CurrentDirection != CurrentDirection.UP)
						{
							snek.changeDirection(CurrentDirection.DOWN);
							System.out.println("DOWN");
							onlyOneDirection = false;
			
						}
						else if(e.getCode() == KeyCode.UP && snek.m_CurrentDirection != CurrentDirection.DOWN)
						{
							snek.changeDirection(CurrentDirection.UP);
							System.out.println("UP");
							onlyOneDirection = false;
			
						}
					}
				});
				
			    snek.move();

			    
			    CheckIfSnakeHitWall();
			    

				ClearGrid();

				
				//display Objective Item
			    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);

				
			    for(int i = 0; i < snek.Positions.size(); i++) //moves the display of the snake
			    {
			    	try
			    	{
			    		recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(Color.BLACK);
			    	}
			    	catch(ArrayIndexOutOfBoundsException e)
			    	{
			    		//:P
			    	}
			    }
			    
			    
			    if( snek.checkIfDead())
			    {
			    	snek = new Snake();
			    }
			    
			    snek.ateObjectiveItem();
			    
			    
			    snakeBrain.updateSnake(snek);
			    snakeBrain.MakeDecision();
			    snek.changeDirection(snakeBrain.getDecidedDecidedDirection());
				
			});
	
			timeline.getKeyFrames().add(keyframe);
			timeline.play();
			
		getChildren().addAll(gridpane);

	}
	
	
	public void CheckIfSnakeHitWall()
	{
	    for( int i = 0; i < snek.Positions.size(); i++) 
	    {
	    	if((snek.Positions.get(0)[0] > recs.length-1) 	||
	    		(snek.Positions.get(0)[0] < 0) 				||
	    		(snek.Positions.get(0)[1] > recs[0].length-1) ||
	    		(snek.Positions.get(0)[1] < 0))
	    	{
	    		snek = new Snake();
	    		snakeBrain = new SnakeBrain(snek);
	    	}
	    }
	}
	
	public void ClearGrid()
	{
		for(int i = 0; i < recs.length; i++)
		{
			for(int j = 0; j < recs[i].length; j++)
			{
				recs[i][j].setFill(Color.WHITE);
			}
		}
	}
}//end GamePane