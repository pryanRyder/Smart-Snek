package GamePaneHelper;

import Agent.SnakeBrain;
import Panes.GamePane;
import Snake.Snake;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GamePaneSetsGets extends GamePane{

	public GamePaneSetsGets(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static boolean getDir() {

		return onlyOneDirection;
	}

	public static void setDir(boolean tf) {

		onlyOneDirection = tf;
	}


	public static int getRecsRow() {

		return recs.length;
	}

	public static int getRecsCol() {

		return recs[0].length;
	}

	public static Rectangle[][] getRecs() {

		return recs;
	}

	public static void setRecsColor(int row, int col, Color color) {

		recs[row][col].setFill(color);
	}

	public static SnakeBrain getSnakeBrain() {
		
		return brain;
	}
	
	public static void setBrain(SnakeBrain sb) {

		brain = sb;
	}

	public static Snake getSnake() {

		return snek;
	}

	public static void setSnake(Snake s) {

		snek = s;
	}

	public static void setStringScore(int score) {
		
		stringScore.setText(Integer.toString(score));
	}
	
	public static Text getStringScore() {
		
		return stringScore;
	}
	
	
	public static boolean getStart() {

		return startOfGame;
	}

	public static void setStart(boolean tf) {

		startOfGame = tf;
	}

	public static int getIter() {

		return iteration;
	}

	public static void setIter(int i) {

		iteration = i;
	}
	
	public static void setIterString(String s) {
		
		iterationString.setText(s);
	}

	public static int getHighScore() {
		
		return highscore;
	}
	
	public static void setHighScore(String s) {
		
		highscore = Integer.parseInt(s);
	}
	
	
	public static void setHighScoreString(String s) {
		
		highScoreString.setText(s);
	}
	
}
