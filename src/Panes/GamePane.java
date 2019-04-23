package Panes;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import Agent.SnakeBrain;
import Agent.SnakeDQN;
import NeuralNetwork.NeuralNetwork;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.concurrent.Task;

/**
 * @author Danny, Paul, Yara
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 * This class creates the timelines that the snake runs on.
 * Creates are the two algorithms and each one has its own timeline and keyframe.
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
    int iteration = 0;


	SnakeDQN dqn = new SnakeDQN(0.001, 0.995, 10, 10);

	SnakeBrain brainySnek = new SnakeBrain();
	Duration time;


	//The scale of the gridpane size to the gamepane size.
	double scale = 0.9;

	//The scaler for the borders.
	double borderScale = 0.2;

	//The scaler for the gaps.
	double gapScale = 0.05;

	//Color of the Snake
	 Color colorOfSnake = Color.PURPLE;

	// First Timeline for DQN
	 Timeline timeline = new Timeline();

	// Second Timeline for Static AI
	 Timeline timeline2 = new Timeline();

	 KeyFrame keyframe = new KeyFrame(Duration.millis(70));

	 int speed = 20;

	static ArrayList<String> dat = new ArrayList<String>();



	boolean dq = false;
	boolean stat = false;

	public void openExcelSpreadsheet()
	{
		try {
		    Desktop.getDesktop().open(new File("snakeData.csv"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * @param nnFile the saved file
	 * @throws Exception
	 * Takes in the saved file reads it then saves it as the current DQN game
	 */
	public void setNN(File nnFile) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nnFile));
		SnakeDQN nn = (SnakeDQN)ois.readObject();
		dqn = nn;
	}

	/**
	 * @param newLearningRate
	 * @param newDiscountFactor
	 * @param epsilonDecay
	 * @param hitWall
	 * @param ateApple
	 * @param idle
	 * @param hitSelf
	 * Sets the new inputs of all these parameters
	 */
	public void setSnek(double newLearningRate, double newDiscountFactor, double epsilonDecay, double hitWall, double ateApple, double idle, double hitSelf)
	{
		dqn = new SnakeDQN(newLearningRate, newDiscountFactor, recs.length, recs[0].length, idle, ateApple, hitWall, hitSelf);

		System.out.println(idle + " " + ateApple + " " + hitWall);

		dqn.setEpsilonDecay(epsilonDecay);
	}

	/**
	 * @param filePath
	 * Saves the DQN snake that the user trained
	 */
	public void saveDQN(String filePath)
	{
		SnakeDQN.saveSnakeDQN(dqn, filePath);
	}

	/**
	 * @param s
	 * calling the appendConsole method in the DisplayPane class and send it the parameter
	 */
	public void appendConsoleDisplay(String s)
	{
		((DisplayPane) displayPane).appendConsole(s);
	}

	/**
	 * @param s
	 * calling the setText method in the DisplayPane class and send it the parameter
	 */
	public void setConsole(String s)
	{
		((DisplayPane) displayPane).Console.setText(s);
	}

	/**
	 * @param episodes
	 * this method trains the snake depending on the number of episodes the user inputs for the DQN algorithm
	 */
	public void trainSnek(int episodes)
	{
		dat = new ArrayList<String>();
		File RP = new File("snakeData.csv");
 		BufferedWriter writer = new BufferedWriter(new FileWriter(RP));
		dat.add("Round,Average Score,Max Score");

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
			//System.out.println(round + "," + averageScore + "," + maxScore + "," + averageEpsilon);
			dat.add(round + "," + averageScore + "," + maxScore + "," + averageEpsilon+"\n");


			//for(int i =0; i < dat.size(); i++)
			//{
				try {
					//System.out.println("writing" + (dat.size()));
						writer = new BufferedWriter(new FileWriter(RP, true));
						writer.append(dat.get(dat.size()-1));
						writer.flush();
						writer.close();
					}
				catch(IOException f)
					{
						System.out.println("something didn't work");
					}
			//}

			((DisplayPane) displayPane).appendConsole(round + "\t\t" + averageScore + "\t\t" + maxScore);
		}
		NeuralNetwork.saveNetwork(dqn.getNetwork(), "tempSnake.nn");
	}

	/**
	 * @param width This is the width of the Game pane
	 * @param height This is the width of the Game pane
	 * this method creates the two timelines for the two algorithms
	 */
	public GamePane(double width, double height)
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



	    //---------------------------- GAME LOOPS ---------------------------------------------------------------------- //

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(KeyFrame1Content(Duration.millis(70)));


		//---------------------------- GAME IMPLEMENTATION 2 ------------------------------- //
		timeline2.setCycleCount(Timeline.INDEFINITE);
		timeline2.getKeyFrames().add(KeyFrame2Content(Duration.millis(70)));

		time = keyframe.getTime();

	getChildren().addAll(gridpane);

	}

	//Color of the Snake
	/**
	 * @param red
	 * @param green
	 * @param blue
	 * this method gets called to set the color of the snake based on the algorothm
	 */
	public void colorOfSnake(double red, double green, double blue)
	{
		colorOfSnake = Color.color(red, green, blue);
	}

	/**
	 * @param x
	 * @return  keyframe
	 * this method creates a keyframe that correlates to the SnakeAI algorithm
	 * and it'll get added to the correlating timeline
	 * This also calls the needed methods to get the snake starting
	 */
	public KeyFrame KeyFrame2Content(Duration x)
	{
		KeyFrame keyframe2 = new KeyFrame(x, action ->
		{
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Boolean Value that Determines whether you can go back on top of yourself
			onlyOneDirection = true;

			//clears the display grid
			ClearGrid();

			brainySnek.UpdateGrid();

			//makes decision
			brainySnek.MakeDecision();

			//executes action
			brainySnek.ExecuteAction();

			//makes a grid for brainySnake
			UpdateGrid2();

			if(brainySnek.isDead())
			{
				iteration++;
				brainySnek.reset();
			}

			//adds to score if snake eats objective item
		    ((DisplayPane) displayPane).setScore(brainySnek.getScore()+"");

		    //adds to highscore if the int score is greater than int highscore.
		    ((DisplayPane) displayPane).setHighScore(brainySnek.getScore());

		    ((DisplayPane) displayPane).setIteration(iteration+"");

		    //---------------------------- AI Integration ------------------------------- //


		});

		return keyframe2;
	}


	/**
	 * @param x
	 * @return keyframe
	 * * this method creates a keyframe that correlates to the Deep Q Learning algorithm
	 * and it'll get added to the correlating timeline
	 * This also calls the needed methods to get the snake starting
	 */
	public KeyFrame KeyFrame1Content(Duration x)
	{
		KeyFrame keyframe = new KeyFrame(x, action ->
		{

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Boolean Value that Determines whether you can go back on top of yourself
			onlyOneDirection = true;

		//---------------------------- GAME IMPLEMENTATION ------------------------------- //
			ClearGrid();

			dqn.step();
			dqn.UpdateGrid();

			UpdateGrid();

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


		});

		return keyframe;
	}


	/**
	 * this method gets called when a button is clicked to slow down the speed of the snake
	 */
	public void slower()
	{
		Duration slower = new Duration(10);

		time = time.add(slower);

		KeyFrame tempKeyFrame = KeyFrame1Content(time);
		//KeyFrame tempKeyFrame2 = KeyFrame2Content(time);

		timeline.getKeyFrames().add(tempKeyFrame);
		timeline.stop();
		timeline.getKeyFrames().remove(0);
		timeline.play();


		/*
		timeline2.getKeyFrames().add(tempKeyFrame2);
		timeline2.stop();
		timeline2.getKeyFrames().remove(0);
		timeline2.play();
		*/
	}

	/**
	 * this method gets called when a button is clicked to make the speed of the snake faster
	 */
	public void faster()
	{
		Duration faster = new Duration(5);

		time = time.subtract(faster);

		KeyFrame tempKeyFrame = KeyFrame1Content(time);
		//KeyFrame tempKeyFrame2 = KeyFrame2Content(time);

		timeline.getKeyFrames().add(tempKeyFrame);
		timeline.stop();
		timeline.getKeyFrames().remove(0);
		timeline.play();


		/*
		timeline2.getKeyFrames().add(tempKeyFrame2);
		timeline2.stop();
		timeline2.getKeyFrames().remove(0);
		timeline2.play();
		*/
	}


	/**
	 * the grid is updated when the DQN algorithm is chosen setting the objective and snake color
	 */
	public void UpdateGrid()
	{
		for(int i = 0; i < recs.length; i++)
		{
			for( int j = 0; j < recs[0].length; j++)
			{
				if(dqn.Grid[i][j] == .5)
					recs[i][j].setFill(Color.RED);
				if(dqn.Grid[i][j] == 1)
					recs[i][j].setFill(colorOfSnake);
			}
		}
	}

	/**
	 * the grid is updated when the Static algorithm is chosen setting the objective and snake color
	 */
	public void UpdateGrid2()
	{
		for(int i = 0; i < recs.length; i++)
		{
			for( int j = 0; j < recs[0].length; j++)
			{
				if(brainySnek.Grid[i][j] == .5)
					recs[i][j].setFill(Color.RED);
				if(brainySnek.Grid[i][j] == 1)
					recs[i][j].setFill(colorOfSnake);
			}
		}
	}
	/**
	 * this method creates the grid that the objective appears on and the snake runs on
	 */
	public void setUpGridPane()
	{
		//The size of the gaps.
				double gapSize;

				//The thickness of the borders.
				double topBorder, rightBorder, bottomBorder, leftBorder;

				//The scaler for the borders
				double borderScale = 0.2;

				//The sclae of the gridpane size to the gamepane size.
				double scale = 0.9;

				//The thickness of the borders.
				double gapScale = 0.05;

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


	/**
	 * this method gets called to clear everything off the grid
	 */
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

	/**
	 * @param width of the grid
	 * @param height of the grid
	 * this method gets called when the user inputs the width and the height of the grid
	 */
	public void ChangeGridSize(int width, int height)
	{
		recs = new Rectangle[40][40];
		setUpGridPane();
	}




	//---------------------------- Getters and Setters for timeline (DQN) ------------------------------- //

	/**
	 * @param colorOfSnake
	 * @return
	 * gets the color of the snake and returns it
	 */
	public Color getColor(Color colorOfSnake) {

		return colorOfSnake;
	}

	/**
	 * gets called to start the timeline for the DQN algorithm
	 */
	public void Play()
	{
		timeline.play();
	}

	/**
	 * gets called to stop the timeline for the DQN algorithm
	 */
	public void Stop()
	{
		timeline.stop();
	}

	/**
	 * gets called to reset the timeline for the DQN algorithm
	 */
	public void reset()
	{
		dqn.reset();
	}



	//---------------------------- Getters and Setters for timeline2 (Static AI) ------------------------------- //
	/**
	 * gets called to start the timeline for the StaticAI algorithm
	 */
	public void Play2() {
		timeline2.play();

	}

	/**
	 * gets called to stop the timeline for the StaticAI algorithm
	 */
	public void Stop2() {
		timeline2.stop();
	}

	/**
	 * gets called to reset the timeline for the StaticAI algorithm
	 */
	public void reset2() {
		brainySnek.reset();
	}


}//end GamePane
