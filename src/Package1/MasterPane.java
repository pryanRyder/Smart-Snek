package Package1;

import javafx.scene.layout.Pane;

public class MasterPane extends Pane
{
	public MasterPane()
	{
		Pane controlPane = new ControlPane();
		Pane gamePane = new GamePane();
		Pane helpTabPane = new HelpTabPane();
		Pane displayPane = new DisplayPane();
		
		
		getChildren().add(controlPane);
		getChildren().add(gamePane);
		getChildren().add(helpTabPane);
		getChildren().add(displayPane);
	}

}
