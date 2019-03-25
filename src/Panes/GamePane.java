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
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Danny, Paul, Yara
 * @version 1.0
 */
public class GamePane extends Pane {


	boolean onlyOneDirection = true;
	Rectangle recs[][] = new Rectangle[25][15];
	Scene scene;
	
	public SnakeManager m_SnakeManager;
	Snake snek = new Snake();
	SnakeBrain brain = new SnakeBrain(snek);

	
	Text stringScore = new Text(Integer.toString(snek.ateObjectiveItem()));
	
	int iteration = 0;
	Text iterationString = new Text();

    Timeline timeline = new Timeline();
	
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	/**
	 * @param width double
	 * @param height double 
	 * creates a gridpane that will have the game running within it, also calls other functions
	 * from other classes that will run the game
	 */
	public GamePane(double width, double height)
	{
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setLayoutY(0);
		setStyle("-fx-background-color: '#6d6d6d';");
		
		
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
		    
		    

			
			Pane scorePane = new Pane();
			scorePane.setPrefSize(120, 115);
		    scorePane.setLayoutX(getPrefWidth()*0.05);
			scorePane.setLayoutY(getPrefHeight()*1.1);	
			
		    stringScore.setLayoutX(scorePane.getPrefWidth()*0.25);
		    stringScore.setLayoutY(scorePane.getPrefHeight()*0.6);
		    stringScore.setFont(Font.font(35));
			
			Text Score = new Text("Score");
			Score.setLayoutX(scorePane.getPrefWidth()*0.02);
			Score.setLayoutY(scorePane.getPrefHeight()*0.15);
			scorePane.setStyle("-fx-font-size: 18 ;");
			
			scorePane.getChildren().addAll(Score, stringScore);
			
			
			Pane iterationPane = new Pane();
			iterationPane.setPrefSize(120, 115);
			iterationPane.setLayoutX(getPrefWidth()*0.13);
			iterationPane.setLayoutY(getPrefHeight()*1.1);
			
			iterationString.setLayoutX(iterationPane.getPrefWidth()*0.25);
			iterationString.setLayoutY(iterationPane.getPrefHeight()*0.6);
			iterationString.setFont(Font.font(35));
			
			Text Iteration = new Text("Iterations");
			Iteration.setLayoutX(iterationPane.getPrefWidth()*0.02);
			Iteration.setLayoutY(iterationPane.getPrefHeight()*0.15);
			iterationPane.setStyle("-fx-font-size: 18 ;");
			
			iterationPane.getChildren().addAll(Iteration, iterationString);
			
			
		getChildren().addAll(gridpane, scorePane, iterationPane);

	}
	
	
	/**
	 * this code creates buttons that'll make the user be able to play, pause, and stop the game
	 *  keyboard inputs can be done by the W, A,S, and D keyboard inputs
	 * makes sure that when snake grows it'ss update the snake length in the Snake class
	 * display score and number of iterations
	 */
	public void StartTraining()
	{
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		iterationString.setText(0+"");
		stringScore.setText(0+"");
		iteration = 0;
		
		
		
		KeyFrame keyframe = new KeyFrame(Duration.millis(50), action -> 
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

		    for( int i = 0; i < snek.Positions.size(); i++) 
		    {
		    	if((snek.Positions.get(0)[0] > recs.length-1) 	||
		    		(snek.Positions.get(0)[0] < 0) 				||
		    		(snek.Positions.get(0)[1] > recs[0].length-1) ||
		    		(snek.Positions.get(0)[1] < 0))
		    	{
		    		snek = new Snake();
		    		brain = new SnakeBrain(snek);
		    		
		    		iteration = iteration + 1;
		    	}
		    }
			
			for(int i = 0; i < recs.length; i++)
			{
				for(int j = 0; j < recs[i].length; j++)
				{
					recs[i][j].setFill(Color.DARKCYAN);
				}
			}
			
		    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);

			
		    for(int i = 0; i < snek.Positions.size(); i++) //moves the display of the snake
		    {
		    	try
		    	{
		    		recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(Color.WHITE);
		    	}
		    	catch(ArrayIndexOutOfBoundsException e)
		    	{
		    		//:P
		    	}
		    }
		    
		    
		    if( snek.checkIfDead())
		    {
		    	snek = new Snake();
		    	brain = new SnakeBrain(snek);
		    	iteration = iteration + 1;
		    	System.out.print(iteration);
		    }
		    
		    snek.ateObjectiveItem();

		    stringScore.setText(Integer.toString(snek.score));
		    
		    iterationString.setText(Integer.toString(iteration));
		    
		    brain.updateSnake(snek);
			brain.MakeDecision();
			snek.setDirection(brain.getDecidedDecidedDirection());
			
		    
		});

	
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
	}
	
	
	public void Pause()
	{
		timeline.stop();
	}
	
	public void Play()
	{
		timeline.play();
	}
	
	
	public void Stop()
	{
		timeline.stop();
		
		for(int i = 0; i < recs.length; i++)
		{
			for(int j = 0; j < recs[i].length; j++)
			{
				recs[i][j].setFill(Color.DARKCYAN);
			}
		}
		
	}
}//end GamePane