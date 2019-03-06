package Panes;

import javafx.scene.paint.Color;

public class TimelineMethods {

	
	public static void Pause() {
		GamePane.timeline.stop();
	}

	public static void Play() {
		GamePane.timeline.play();
	}

	public static void Stop() {
		GamePane.timeline.stop();

		for (int i = 0; i < GamePane.recs.length; i++) {
			for (int j = 0; j < GamePane.recs[i].length; j++) {
				GamePane.recs[i][j].setFill(Color.DARKCYAN);
			}
		}

	}
}
