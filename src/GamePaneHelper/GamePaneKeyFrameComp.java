package GamePaneHelper;

import Panes.GamePane;
import PrintData.PrintSnake;
import javafx.animation.KeyFrame;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.util.Duration;

public class GamePaneKeyFrameComp {

	public static void keyFrameComp(GamePane gamepane) {
		
		System.out.println("Top of keyframe");

		//onlyOneDirection = true;
		GamePaneSetsGets.setDir(true);
		
		//User is controlling snake.
		gamepane.getScene().setOnKeyPressed(e -> {
			UserMoving.userMoving(e);
		});

		System.out.println("Before move");
		GamePaneSetsGets.getSnake().move(GamePaneSetsGets.getRecs());
		PrintSnake.printSnake(GamePaneSetsGets.getSnake());
		System.out.println("After move");
		
		GamePaneSetsGets.getSnake().ateObjectiveItem(GamePaneSetsGets.getRecs());

		//Check to see if a new game has started.
		if (GamePaneSetsGets.getStart() == true) {
			GamePaneSetsGets.setStart(false);
		}

		
		UpdateSnakeStrings.updateStrings();
		GamePaneSetsGets.getSnakeBrain().updateSnake(GamePaneSetsGets.getSnake());
		GamePaneSetsGets.getSnakeBrain().MakeDecision();
		GamePaneSetsGets.getSnake().setDirection(GamePaneSetsGets.getSnakeBrain().getDecidedDecidedDirection());

		
		System.out.println("Bottom of keyframe");
	}
}
