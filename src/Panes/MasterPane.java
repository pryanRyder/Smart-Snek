package Panes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{
	public MasterPane(double width, double height)
	{
		Pane controlPane = new ControlPane(width, height);
		//Pane helpTabPane = new HelpTabPane(width, height);


		getChildren().add(controlPane);
		//getChildren().add(helpTabPane);
	}

}
