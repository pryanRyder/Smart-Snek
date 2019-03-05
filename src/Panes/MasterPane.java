package Panes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{	
	public MasterPane(double width, double height)
	{
		
		ControlPane controlPane = new ControlPane(width, height);
		GamePane gamePane = new GamePane(width, height);
		//Pane helpTabPane = new HelpTabPane(width, height);
		DisplayPane displayPane = new DisplayPane(width, height);
		
		getChildren().add(controlPane);
		//getChildren().add(helpTabPane);
		getChildren().add(displayPane);

	}

}
