package Panes;

import Snake.CurrentDirection;
import Snake.Snake;
import javafx.animation.KeyFrame;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ChooseDirection {

	public static void CalculateDirection(GamePane gamePane, Rectangle recs[][], Text stringScore,
			Text iterationString) {

		KeyFrame keyframe = new KeyFrame(Duration.millis(75), action -> {
			GamePane.onlyOneDirection = true;

			gamePane.getScene().setOnKeyPressed(e -> {
				if (GamePane.onlyOneDirection) {

					if (e.getCode() == KeyCode.A && GamePane.snek.m_CurrentDirection != CurrentDirection.RIGHT) {
						GamePane.snek.changeDirection(CurrentDirection.LEFT);
						System.out.println("LEFT");
						GamePane.onlyOneDirection = false;
					} else if (e.getCode() == KeyCode.D && GamePane.snek.m_CurrentDirection != CurrentDirection.LEFT) {
						GamePane.snek.changeDirection(CurrentDirection.RIGHT);
						System.out.println("RIGHT");
						GamePane.onlyOneDirection = false;

					} else if (e.getCode() == KeyCode.S && GamePane.snek.m_CurrentDirection != CurrentDirection.UP) {
						GamePane.snek.changeDirection(CurrentDirection.DOWN);
						System.out.println("DOWN");
						GamePane.onlyOneDirection = false;

					} else if (e.getCode() == KeyCode.W && GamePane.snek.m_CurrentDirection != CurrentDirection.DOWN) {
						GamePane.snek.changeDirection(CurrentDirection.UP);
						System.out.println("UP");
						GamePane.onlyOneDirection = false;

					}

					else if (e.getCode() == KeyCode.LEFT
							&& GamePane.snek.m_CurrentDirection != CurrentDirection.RIGHT) {
						GamePane.snek.changeDirection(CurrentDirection.LEFT);
						System.out.println("LEFT");
						GamePane.onlyOneDirection = false;

					} else if (e.getCode() == KeyCode.RIGHT
							&& GamePane.snek.m_CurrentDirection != CurrentDirection.LEFT) {
						GamePane.snek.changeDirection(CurrentDirection.RIGHT);
						System.out.println("RIGHT");
						GamePane.onlyOneDirection = false;

					} else if (e.getCode() == KeyCode.DOWN && GamePane.snek.m_CurrentDirection != CurrentDirection.UP) {
						GamePane.snek.changeDirection(CurrentDirection.DOWN);
						System.out.println("DOWN");
						GamePane.onlyOneDirection = false;

					} else if (e.getCode() == KeyCode.UP && GamePane.snek.m_CurrentDirection != CurrentDirection.DOWN) {
						GamePane.snek.changeDirection(CurrentDirection.UP);
						System.out.println("UP");
						GamePane.onlyOneDirection = false;

					}
				}
			});

			GamePane.snek.move();

			for (int i = 0; i < GamePane.snek.Positions.size(); i++) {
				if ((GamePane.snek.Positions.get(0)[0] > recs.length - 1) || (GamePane.snek.Positions.get(0)[0] < 0)
						|| (GamePane.snek.Positions.get(0)[1] > recs[0].length - 1)
						|| (GamePane.snek.Positions.get(0)[1] < 0)) {
					GamePane.snek = new Snake();

					GamePane.iteration = GamePane.iteration + 1;
				}
			}

			for (int i = 0; i < recs.length; i++) {
				for (int j = 0; j < recs[i].length; j++) {
					recs[i][j].setFill(Color.DARKCYAN);
				}
			}

			recs[GamePane.snek.objectiveItem[0]][GamePane.snek.objectiveItem[1]].setFill(Color.RED);

			for (int i = 0; i < GamePane.snek.Positions.size(); i++) // moves the display of the snake
			{
				try {
					recs[GamePane.snek.Positions.get(i)[0]][GamePane.snek.Positions.get(i)[1]].setFill(Color.WHITE);
				} catch (ArrayIndexOutOfBoundsException e) {
					// :P
				}
			}

			if (GamePane.snek.checkIfDead()) {
				GamePane.snek = new Snake();

				GamePane.iteration = GamePane.iteration + 1;
				System.out.print(GamePane.iteration);
			}

			GamePane.snek.ateObjectiveItem();

			stringScore.setText(Integer.toString(GamePane.snek.score));

			iterationString.setText(Integer.toString(GamePane.iteration));

		});

		GamePane.timeline.getKeyFrames().add(keyframe);
		GamePane.timeline.play();

		
		//FIXME game crashes at this line when you hit start training after you hit stop.
		gamePane.getChildren().addAll(GamePane.gridpane);

		GamePane.timeline.getKeyFrames().add(keyframe);
		GamePane.timeline.play();
	}
}
