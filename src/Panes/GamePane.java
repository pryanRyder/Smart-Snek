package Panes;

import java.util.Collection;

import Agent.SnakeBrain;
import PaneHelper.AddGridPaneContent;
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


	boolean[] typeOfAlgorithm = { false, false, false };

	boolean onlyOneDirection = true;
	//[row][col]
	private static Rectangle recs[][] = new Rectangle[15][25];

	public static int getRecsRow() {

		return recs.length;
	}

	public static int getRecsCol() {

		return recs[0].length;
	}


	Scene scene;

	public SnakeManager m_SnakeManager;
	Snake snek = new Snake(recs);
	SnakeBrain brain = new SnakeBrain(snek);


	Text stringScore = new Text(Integer.toString(snek.ateObjectiveItem(recs)));

	int iteration = 0;
	Text iterationString = new Text();
	Text highScoreString = new Text();
	int highscore = 0;


	public static GridPane gridpane = new GridPane();

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
		// this will add the gridpane
		AddGridPaneContent.addGridPaneContent(this, gridpane, width, height, recs, stringScore, iterationString);

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


		if(snek.Positions.size() == 1) {
			recs[snek.objectiveItem[1]][snek.objectiveItem[0]].setFill(Color.RED);
		}


		KeyFrame keyframe = new KeyFrame(Duration.millis(20), action ->
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


		    snek.move(recs);


		    	//If the snake head hits a wall...
		    	if((snek.Positions.get(0)[0] > recs[0].length-1) 	||
		    		(snek.Positions.get(0)[0] < 0) 				||
		    		(snek.Positions.get(0)[1] > recs.length-1) ||
		    		(snek.Positions.get(0)[1] < 0))
		    	{
		    		snek = new Snake(recs);
		    		brain = new SnakeBrain(snek);

					int row=0;
					for(row=0; row < recs.length; row++) {

						int col=0;
						for(col=0; col < recs[row].length; col++) {

							recs[row][col].setFill(Color.DARKCYAN);

						}
					}

		    		iteration = iteration + 1;
		    	}




		    //Resets the entire grid to the default color.
		    //To much calculation

		    /*
			int row=0;
			for(row=0; row < recs.length; row++) {

				int col=0;
				for(col=0; col < recs[row].length; col++) {

					recs[row][col].setFill(Color.WHITE);

				}
			}
		    */


			//Color the objective
			//recs[snek.objectiveItem[1]][snek.objectiveItem[0]].setFill(Color.RED);




			/*
		    for(int i = 0; i < snek.Positions.size(); i++) //moves the display of the snake
		    {
		    	try
		    	{
		    		if(typeOfAlgorithm[0])
		    			recs[snek.Positions.get(i)[1]][snek.Positions.get(i)[0]].setFill(Color.DARKRED);
		    		else if(typeOfAlgorithm[1])
		    			recs[snek.Positions.get(i)[1]][snek.Positions.get(i)[0]].setFill(Color.GREEN);
		    		else
		    			recs[snek.Positions.get(i)[1]][snek.Positions.get(i)[0]].setFill(Color.PURPLE);
		    	}
		    	catch(ArrayIndexOutOfBoundsException e)
		    	{
		    		//:P
		    	}
		    }
		    */

		    if( snek.checkIfDead())
		    {
		    	snek = new Snake(recs);
		    	brain = new SnakeBrain(snek);
		    	iteration = iteration + 1;
		    	System.out.print(iteration);

				int row=0;
				for(row=0; row < recs.length; row++) {

					int col=0;
					for(col=0; col < recs[row].length; col++) {

						recs[row][col].setFill(Color.DARKCYAN);

					}
				}
		    }

		    snek.ateObjectiveItem(recs);

		    stringScore.setText(Integer.toString(snek.score));

		    if(Integer.parseInt(stringScore.getText())>highscore)
		    {
		    	highScoreString.setText(stringScore.getText());
		    	highscore = Integer.parseInt(stringScore.getText());
		    }

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


		int row=0;
		for(row=0; row < recs.length; row++) {

			int col=0;
			for(col=0; col < recs[row].length; col++) {

				recs[row][col].setFill(Color.WHITE);

			}
		}

	}

	public void setTypeOfAlgorithm(boolean[] typeOfAlgorithm)
	{
		this.typeOfAlgorithm = typeOfAlgorithm;
	}

}//end GamePane
