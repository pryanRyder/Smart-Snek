package GamePaneHelper;

import Panes.GamePane;
import Snake.CurrentDirection;
import Snake.Snake;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UserMoving {

	public static void userMoving(KeyEvent e) {
		
		boolean localDir = GamePaneSetsGets.getDir();
		Snake localSnek = GamePaneSetsGets.getSnake();
		
		if (localDir) {
			if (e.getCode() == KeyCode.A && localSnek.m_CurrentDirection != CurrentDirection.RIGHT) {
				localSnek.changeDirection(CurrentDirection.LEFT);
				System.out.println("LEFT");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;
			} else if (e.getCode() == KeyCode.D && localSnek.m_CurrentDirection != CurrentDirection.LEFT) {
				localSnek.changeDirection(CurrentDirection.RIGHT);
				System.out.println("RIGHT");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			} else if (e.getCode() == KeyCode.S && localSnek.m_CurrentDirection != CurrentDirection.UP) {
				localSnek.changeDirection(CurrentDirection.DOWN);
				System.out.println("DOWN");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			} else if (e.getCode() == KeyCode.W && localSnek.m_CurrentDirection != CurrentDirection.DOWN) {
				localSnek.changeDirection(CurrentDirection.UP);
				System.out.println("UP");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			}

			else if (e.getCode() == KeyCode.LEFT && localSnek.m_CurrentDirection != CurrentDirection.RIGHT) {
				localSnek.changeDirection(CurrentDirection.LEFT);
				System.out.println("LEFT");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			} else if (e.getCode() == KeyCode.RIGHT && localSnek.m_CurrentDirection != CurrentDirection.LEFT) {
				localSnek.changeDirection(CurrentDirection.RIGHT);
				System.out.println("RIGHT");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			} else if (e.getCode() == KeyCode.DOWN && localSnek.m_CurrentDirection != CurrentDirection.UP) {
				localSnek.changeDirection(CurrentDirection.DOWN);
				System.out.println("DOWN");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			} else if (e.getCode() == KeyCode.UP && localSnek.m_CurrentDirection != CurrentDirection.DOWN) {
				localSnek.changeDirection(CurrentDirection.UP);
				System.out.println("UP");
				GamePaneSetsGets.setDir(false);//onlyOneDirection = false;

			}
		}
	}
}
