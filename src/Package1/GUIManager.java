package Package1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GUIManager extends Application
{

	private ControlPane myControl;
	private DisplayPane myDisplay;
	private GamePane myGame;
	private HelpTabPane myHelp;

	public GUIManager()
	{

	}

	public void finalize() throws Throwable 
	{

	}
	/**
	 * 
	 * @param primaryStage
	 */
	public void start(Stage primaryStage)
	{		
		Scene scene = new Scene(new MasterPane(), 720, 480);
		
		primaryStage.setTitle("Smart-Snek");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}//end GUIManager