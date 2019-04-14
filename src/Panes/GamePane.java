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

	public String iterationString = new String();
	public int iterationNum = 0;

	public String scoreString = new String();
	public int score = 0;


	GridPane gridpane = new GridPane();
	boolean onlyOneDirection = true;
	 Rectangle recs[][] = new Rectangle[40][40];
	Scene scene;

	public SnakeManager m_SnakeManager;
	Snake snek = new Snake(recs);
    SnakeBrain snakeBrain = new SnakeBrain(snek);
    Pane displayPane;
    private int iteration = 0;


	//Color of the Snake
	 Color colorOfSnake = Color.BLACK;
	 Timeline timeline = new Timeline();

	public void finalize() throws Throwable {
		super.finalize();
	}


	public GamePane( double width, double height)
	{

	    //---------------------------- Set Up ------------------------------- //

		//Create Display Pane
		displayPane = new DisplayPane(width, height);
		getChildren().add(displayPane);


		//dealing with sizing
		setPrefSize(width * 0.75, height * 0.75);

		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setStyle("-fx-background-color: '#6d6d6d';");

		//Sets up Grid Pane
		setUpGridPane();

	    // generate random Objective Item
	    snek.randomObjectiveItem();

	    // Display random Objective Item
	    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);

	    // Set Each Tile In Grid Pane to White
	    for(int i = 0; i < snek.Positions.size(); i++)
	    {
	    	recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(Color.WHITE);
	    }


	    //---------------------------- GAME LOOP ------------------------------- //


		timeline.setCycleCount(Timeline.INDEFINITE);

		KeyFrame keyframe = new KeyFrame(Duration.millis(45), action ->
		{
			// Boolean Value that Determines whether you can go back on top of yourself
			onlyOneDirection = true;

		    //---------------------------- GAME IMPLEMENTATION ------------------------------- //


			//moves the snake based off of key presses
			keyPressHandler();

			//moves the snakes position
		    snek.move();

		    //Checks if snake hits wall and resets the snake if dead
		    CheckIfSnakeHitWall();

		    //Clears the Grid
			ClearGrid();

			//Displays Objective Item
		    recs[snek.objectiveItem[0]][snek.objectiveItem[1]].setFill(Color.RED);

		    //Moves the Snakes Position in GridPane
			moveSnakeDisplay();

			//Checks if the Snake ran into itself and resets if true
			CheckIfSnakeHitSelf();

			//adds to score if snake eats objective item
		    snek.ateObjectiveItem();
		    ((DisplayPane) displayPane).setScore(snek.score+"");

		    //---------------------------- AI Integration ------------------------------- //

		    //updates brain with the environment
		    snakeBrain.updateSnake(snek);
		    //brain makes decision based off of the environment
		    snakeBrain.MakeDecision();
		    //brain decides on a direction and changes the path of the snake
		    snek.changeDirection(snakeBrain.getDecidedDecidedDirection());

		});

		timeline.getKeyFrames().add(keyframe);
		//timeline.play();

	getChildren().addAll(gridpane);

	}

	public void setUpGridPane()
	{
		//The size of the gaps.
				double gapSize;

				//The thickness of the borders.
				double topBorder, rightBorder, bottomBorder, leftBorder;

				//The side length of the boxes.
				double boxSide;

				//The height and width of the gridpane
				double gHeight, gWidth;

				//The scale will change the height, and in return, will also change the width.
				double numerator = getPrefHeight() * scale;
				double denominator = 2*borderScale + recs.length + (recs.length-1)*gapScale;
				boxSide = numerator / denominator;

				topBorder = rightBorder = bottomBorder = leftBorder = boxSide*borderScale;
				gapSize = boxSide*gapScale;

				//Set the borders.
				gridpane.setPadding(new Insets(topBorder, rightBorder, bottomBorder, leftBorder));

				int row=0;
				for(row=0; row < recs.length; row++) {

					int col=0;
					for(col=0; col < recs[row].length; col++) {

						Rectangle rec = new Rectangle();
						rec.setHeight(boxSide);
						rec.setWidth(boxSide);
						rec.setFill(Color.WHITE);

						recs[row][col] = rec;

						gridpane.add(recs[row][col], col, row);
					}
				}

			    gridpane.setHgap(gapSize);
			    gridpane.setVgap(gapSize);

			    //Test to see if gridpane is out of proportions.
			    gWidth = 2*(borderScale*boxSide) + recs[0].length*boxSide +
			    		(recs[0].length - 1)*gapScale*boxSide;

			    gHeight = 2*(borderScale*boxSide) + recs.length*boxSide +
			    		(recs.length - 1)*gapScale*boxSide;

			    double xPos = (getPrefWidth()-gWidth)/2;
			    double yPos = (getPrefHeight()-gHeight)/2;

			    gridpane.relocate(xPos, yPos);
	}

	public void CheckIfSnakeHitSelf()
	{

	    if( snek.checkIfDead())
	    {
	    	iteration++;
	    	resetSnake();

	    }
	}

	public void resetSnake()
	{
		snek = new Snake(recs);
    	snakeBrain = new SnakeBrain(snek);
    	((DisplayPane) displayPane).setIteration(iteration+"");
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
	        	iteration++;
		    	resetSnake();
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

	public void moveSnakeDisplay()
	{
	    for(int i = 0; i < snek.Positions.size(); i++) //moves the display of the snake
	    {
	    	try
	    	{
	    		recs[snek.Positions.get(i)[0]][snek.Positions.get(i)[1]].setFill(colorOfSnake);
	    	}
	    	catch(ArrayIndexOutOfBoundsException e)
	    	{
	    		//:P
	    	}
	    }
	}

	public void keyPressHandler()
	{
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
	}
	public void ChangeGridSize(int width, int height)
	{
		recs = new Rectangle[40][40];
		setUpGridPane();
	}
	public void setColor(Color colorOfSnake) {
		this.colorOfSnake=colorOfSnake;
	}
	public Color getColor (Color colorOfSnake) {

		return colorOfSnake;
	}

	public void Play()
	{
		timeline.play();
	}

	public void Stop()
	{
		timeline.stop();
	}

}//end GamePane
