package Panes;

import Snake.Snake;
import Snake.SnakeManager;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Danny, Paul, Yara
 * @version 1.0
 */
public class GamePane extends Pane {

	public static boolean onlyOneDirection = true;
	public static Rectangle recs[][] = new Rectangle[25][15];
	
	Scene scene;

	public SnakeManager m_SnakeManager;
	public static Snake snek = new Snake();

	Text stringScore = new Text(Integer.toString(snek.ateObjectiveItem()));

	public static int iteration = 0;
	Text iterationString = new Text();

	public static GridPane gridpane = new GridPane();

	public static Timeline timeline = new Timeline();

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * @param width  double
	 * @param height double creates a gridpane that will have the game running
	 *               within it, also calls other functions from other classes that
	 *               will run the game
	 */
	public GamePane(double width, double height) {

		// this is the GamePane
		GameContent.AddGameContent(this, gridpane, width, height, recs, stringScore, iterationString);
	}

	/**
	 * this code creates buttons that'll make the user be able to play, pause, and
	 * stop the game keyboard inputs can be done by the W, A,S, and D keyboard
	 * inputs makes sure that when snake grows it'ss update the snake length in the
	 * Snake class display score and number of iterations
	 */
	public void StartTraining() {
		
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		iterationString.setText(0 + "");
		stringScore.setText(0 + "");
		iteration = 0;

		snek = new Snake();

		ChooseDirection.CalculateDirection(this, recs, stringScore, iterationString);

	}

}// end GamePane