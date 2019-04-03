package GamePaneHelper;

import Panes.GamePane;
import javafx.scene.text.Text;

public class UpdateSnakeStrings {

	public static void updateStrings() {
		
		int localHS = GamePaneSetsGets.getHighScore();
		Text localSS = GamePaneSetsGets.getStringScore();
		GamePaneSetsGets.setStringScore(GamePaneSetsGets.getSnake().score);
		
		if (Integer.parseInt(localSS.getText()) > localHS) {
			
			GamePaneSetsGets.setHighScoreString(GamePaneSetsGets.getStringScore().getText());
			GamePaneSetsGets.setHighScore(GamePaneSetsGets.getStringScore().getText());
		}

		GamePaneSetsGets.setIterString(Integer.toString(GamePaneSetsGets.getIter()));
	}
}
