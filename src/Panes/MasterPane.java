package Panes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{
	public MasterPane(double width, double height)
	{
		//this is the MasterPane
		
		Pane controlPane = new ControlPane(width, height);
		Pane gamePane = new GamePane(width, height);
		//Pane helpTabPane = new HelpTabPane(width, height);
		Pane displayPane = new DisplayPane(width, height);
		
		this.getChildren().add(controlPane);
		this.getChildren().add(gamePane);
		//this.getChildren().add(helpTabPane);
		this.getChildren().add(displayPane);
	}
}
