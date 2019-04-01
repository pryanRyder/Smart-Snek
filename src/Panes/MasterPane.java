package Panes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{
	/**
	 * @param width double
	 * @param height double
	 * creates a pane that holds all other panes in it
	 */
	public MasterPane(double width, double height)
	{

		
		Pane displayPane = new DisplayPane(width, height);
		Pane controlPane = new ControlPane(width, height);

		getChildren().add(displayPane);

		getChildren().add(controlPane);


	}

}
