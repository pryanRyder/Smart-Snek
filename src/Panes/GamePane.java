package Panes;

import java.util.Collection;

import Agent.SnakeBrain;
import GamePaneHelper.DidSnakeHitWall;
import GamePaneHelper.GamePaneKeyFrameComp;
import GamePaneHelper.UpdateSnakeStrings;
import GamePaneHelper.UserMoving;
import PaneHelper.AddGridPaneContent;
import PrintData.PrintSnake;
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
 * @author Danny, Paul, Yara, Sky
 * @version 1.0
 */
public class GamePane extends Pane {

	// protected variables are shared by GamePaneSetsGets
	protected static boolean onlyOneDirection = true;
	protected static Rectangle recs[][] = new Rectangle[15][25]; // [row][col] [15][25]
	protected static Scene scene;
	protected static SnakeManager m_SnakeManager;
	protected static Snake snek = new Snake(recs);
	protected static SnakeBrain brain = new SnakeBrain(snek);
	protected static boolean startOfGame = true;
	protected static Text stringScore = new Text(Integer.toString(snek.ateObjectiveItem(recs)));
	protected static int iteration = 0;
	protected static Text iterationString = new Text();
	protected static Text highScoreString = new Text();
	protected static int highscore = 0;
	protected static GridPane gridpane = new GridPane();
	protected static Timeline timeline = new Timeline();

	/**
	 * @param width  double
	 * @param height double creates a gridpane that will have the game running
	 *               within it, also calls other functions from other classes that
	 *               will run the game
	 */
	public GamePane(double width, double height) {

		// this will add the gridpane
		AddGridPaneContent.addGridPaneContent(this, gridpane, width, height, recs, stringScore, iterationString);

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

		if (snek.Positions.size() == 1) {
			recs[snek.objectiveItem[1]][snek.objectiveItem[0]].setFill(Color.RED);
		}

		KeyFrame keyframe = new KeyFrame(Duration.millis(20), action -> {
			GamePaneKeyFrameComp.keyFrameComp(this, snek, recs, brain);
		});

		timeline.getKeyFrames().add(keyframe);
		timeline.play();
	}

	public void Pause() {
		timeline.stop();
	}

	public void Play() {
		timeline.play();
	}

	public void Stop() {
		timeline.stop();

	}
}// end GamePane