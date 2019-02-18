package Package1;

import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{
	public MasterPane(double width, double height)
	{
		Pane controlPane = new ControlPane(width, height);
		Pane gamePane = new GamePane(width, height);
		//Pane helpTabPane = new HelpTabPane(width, height);
		Pane displayPane = new DisplayPane(width, height);
		
		
		getChildren().add(controlPane);
		getChildren().add(gamePane);
		//getChildren().add(helpTabPane);
		getChildren().add(displayPane);
	}

}
