package GamePaneHelper;

import Agent.SnakeBrain;
import Snake.Snake;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HitSelf {

	public static void hit(Snake snek, Rectangle[][] recs) {
		
		if(snek.checkIfDead()) {
			
			//Reset snake.
			GamePaneSetsGets.setSnake(new Snake(recs));
			GamePaneSetsGets.setBrain(new SnakeBrain(GamePaneSetsGets.getSnake()));
			
			//Add an iteration.
			GamePaneSetsGets.setIter(GamePaneSetsGets.getIter()+1);
			
			//Reset color of grid.
			int row=0;
			for(row=0; row<recs.length; row++) {
				
				int col=0;
				for(col=0; col<recs[row].length; col++) {
					
					recs[row][col].setFill(Color.DARKCYAN);
				}
			}
		}
	}
}
