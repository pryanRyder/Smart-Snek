package GamePaneHelper;

import Agent.SnakeBrain;
import Panes.GamePane;
import Snake.Snake;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DidSnakeHitWall {

	public static void didSnakeHitWall() {

		Snake localSnek = GamePaneSetsGets.getSnake();
		Rectangle[][] localRecs = GamePaneSetsGets.getRecs();

		System.out.println(localSnek.Positions.get(0)[0] +">"+(localRecs[0].length - 1));
		
		System.out.println(localSnek.Positions.get(0)[0] + "<" + 0);
		
		System.out.println(localSnek.Positions.get(0)[1]+">"+(localRecs.length - 1));
		
		System.out.println(localSnek.Positions.get(0)[1]+"<"+ 0 );
		
		if ((localSnek.Positions.get(0)[0] > localRecs[0].length - 1) || (localSnek.Positions.get(0)[0] < 0)
				|| (localSnek.Positions.get(0)[1] > localRecs.length - 1) || (localSnek.Positions.get(0)[1] < 0)) {

			
			System.out.println("NEW SNAKE NEEDED");
			Snake newSnek = new Snake(GamePaneSetsGets.getRecs());
			GamePaneSetsGets.setSnake(newSnek);

			SnakeBrain newBrain = new SnakeBrain(GamePaneSetsGets.getSnake());
			GamePaneSetsGets.setBrain(newBrain);

			GamePaneSetsGets.setStart(true);

			int row = 0;
			for (row = 0; row < localRecs.length; row++) {

				int col = 0;
				for (col = 0; col < localRecs[row].length; col++) {

					GamePaneSetsGets.setRecsColor(row, col, Color.DARKCYAN);
				}
			}

			GamePaneSetsGets.setIter(GamePaneSetsGets.getIter() + 1);
		}
	}
}
