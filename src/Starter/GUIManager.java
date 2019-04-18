package Starter;


import Panes.MasterPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GUIManager extends Application
{
	Scene scene;
	Stage stage;
	
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
		double width, height;
		//Get the dimensions of user's screen.
	    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		stage = primaryStage;

	    //Test to see what the dimensions of the screen are.
	    System.out.println(screenBounds);
	    
	    //Make the height 90% of the screen to avoid off-screen defects.
	    width = screenBounds.getWidth() * 1;
	    height = screenBounds.getHeight() * 0.9;
		scene = new Scene(new MasterPane(width, height), width, height);
		stage.setTitle("Smart-Snek");
		stage.setScene(scene);
		stage.show();
	}
	
	public Stage getStage()
	{
		return stage;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}//end GUIManager