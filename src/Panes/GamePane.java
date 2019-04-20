package Panes;

import java.util.Arrays;

import Agent.SnakeDQN;
import NeuralNetwork.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	 Rectangle recs[][] = new Rectangle[10][10];
	Scene scene;

    Pane displayPane;
    private int iteration = 0;
    
	SnakeDQN dqn = new SnakeDQN(0.001, 0.995, 10, 10);

    
	//The scale of the gridpane size to the gamepane size.
	double scale = 0.9;

	//The scaler for the borders.
	double borderScale = 0.2;

	//The scaler for the gaps.
	double gapScale = 0.05;
    

	//Color of the Snake
	 Color colorOfSnake = Color.BLACK;
	 Timeline timeline = new Timeline();
	 KeyFrame keyframe = new KeyFrame(Duration.millis(70));
	public void finalize() throws Throwable {
		super.finalize();
	}

	public void setSnek(double newLearningRate, double newDiscountFactor, double epsilonDecay, double hitWall, double ateApple, double idle, double hitSelf)
	{
		//	public SnakeDQN(int[] topology, double learningRate, double discountFactor, int width, int height, double hitWall, double ateApple, double idle)

		dqn = new SnakeDQN(newLearningRate, newDiscountFactor, recs.length, recs[0].length, idle, ateApple, hitWall, hitSelf);
		
		System.out.println(idle + " " + ateApple + " " + hitWall);
		
		dqn.setEpsilonDecay(epsilonDecay);
		
	}
	
	public void appendConsoleDisplay(String s)
	{
		((DisplayPane) displayPane).appendConsole(s);
	}
	
	public void setConsole(String s)
	{
		((DisplayPane) displayPane).Console.setText(s);
	}
	
	public void trainSnek(int episodes)
	{
		((DisplayPane) displayPane).appendConsole("\nround\tavgScore\tmaxScore\n");
		for(int round = 0; round < episodes; round++)
		{
			double averageScore = 0;
			int maxScore = 0;
			double averageEpsilon = 0;
			int totalSteps = 0;
			for(int gameIndex = 0; gameIndex < 1000; gameIndex++)
			{
				dqn.reset();
				
				while(!dqn.isDone())
				{
					totalSteps++;
					averageEpsilon += dqn.getEpsilon();
					dqn.step();
				}
				
				averageScore += dqn.getScore();
				
				if(dqn.getScore() > maxScore)
				{
					maxScore = dqn.getScore();
				}
			}
			
			averageScore /= 1000.0;
			averageEpsilon /= (double)totalSteps;
			System.out.println(round + "," + averageScore + "," + maxScore + "," + averageEpsilon);
		
			((DisplayPane) displayPane).appendConsole(round + "\t\t" + averageScore + "\t\t" + maxScore);
			
		}
		NeuralNetwork.saveNetwork(dqn.getNetwork(), "snake.nn");
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
		timeline.getKeyFrames().add(KeyFrameContent(new Duration (70)));
	    //---------------------------- GAME LOOP ------------------------------- //


		timeline.setCycleCount(Timeline.INDEFINITE);
		
		

		
		//timeline.play();

	getChildren().addAll(gridpane);

	}
	public KeyFrame KeyFrameContent (Duration x)
	{
		 KeyFrame keyframe = new KeyFrame(x, action ->
		{
			// Boolean Value that Determines whether you can go back on top of yourself
			onlyOneDirection = true;

		    //---------------------------- GAME IMPLEMENTATION ------------------------------- //

			ClearGrid();
			
			dqn.step();
			dqn.UpdateGrid();
			
			UpdateGrid();
			
			//System.out.println(Arrays.toString(dqn.headNeighbors));
			
			if(dqn.isDead())
			{
				iteration++;
				dqn.reset();
			}

			//adds to score if snake eats objective item
		    ((DisplayPane) displayPane).setScore(dqn.getScore()+"");
		    
		    //adds to highscore if the int score is greater than int highscore. 
		    ((DisplayPane) displayPane).setHighScore(dqn.getScore());
		    
		    ((DisplayPane) displayPane).setIteration(iteration+"");


		    //---------------------------- AI Integration ------------------------------- //

		    
		});
		return keyframe; 
	}
		public void slower()
	{
			Duration time = keyframe.getTime();
			Duration slower = new Duration (5); 
			timeline.getKeyFrames().remove(keyframe);
			KeyFrame keyframe2= KeyFrameContent(time.add(slower)); 
			timeline.getKeyFrames().add(keyframe2);
	}
	public void faster()
	{
		Duration time = keyframe.getTime();
		Duration fasterS = new Duration (5); 
		timeline.getKeyFrames().remove(keyframe);
		KeyFrame keyframe2= KeyFrameContent(time.subtract(fasterS)); 
		timeline.getKeyFrames().add(keyframe2);
	}

	
	public void UpdateGrid()
	{
		for(int i = 0; i < recs.length; i++)
		{
			for( int j = 0; j < recs[0].length; j++)
			{
				if(dqn.Grid[i][j] == .5)
					recs[i][j].setFill(Color.RED);
				if(dqn.Grid[i][j] == 1)
					recs[i][j].setFill(Color.BLACK);
			}
		}
	}
	
	
	

	public void setUpGridPane()
	{
		//The size of the gaps.
				double gapSize;
				
				// The scale of the gridpane size to the gamepane size.
				double scale = 0.9;
				
				//The scaler for the borders.
				double borderScale = 0.2;
				
				//the scaler for the gaps.
				double gapScale = 0.05;

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


	
	public void ChangeGridSize(int width, int height)
	{
		recs = new Rectangle[40][40];
		setUpGridPane();
	}
	public void setColor(Color colorOfSnake) {
		this.colorOfSnake=colorOfSnake;
	}
	public Color getColor(Color colorOfSnake) {

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
	
	public void reset()
	{
		dqn.reset();
	}

}//end GamePane
