package Package1;

import Panes.MasterPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Danny
 * @author Raymond Kwasneski
 * @version 1.0
 */
public class GUIManager extends Application
{

	Scene scene;
	
	/**
	 * creates a new GUIManger instance 
	 */

	public GUIManager()
	{

	}

	public void finalize() throws Throwable 
	{

	}
	
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * the class you run to run the project and it creates a stage and scene that
	 *  considers the device it's running from in terms of its size
	 */
	public void start(Stage primaryStage)

	{
			
			double width, height;
			//Get the dimensions of user's screen.
		    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		    
		    //Test to see what the dimensions of the screen are.
		    System.out.println(screenBounds);
		    
		    //Make the height 90% of the screen to avoid off-screen defects.
		    width = screenBounds.getWidth() * 1;
		    height = screenBounds.getHeight() * 0.9;
			Scene scene = new Scene(new MasterPane(width, height), width, height);
			primaryStage.setTitle("Smart-Snek");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	
	public static void main(String[] args)
	{
		launch(args);
	}

}//end GUIManager