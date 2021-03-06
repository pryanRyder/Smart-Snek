package Starter;


import java.io.File;

import Panes.MasterPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Danny
 * @version 1.0
 * this class is the class that launches the program
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
	 * @param primaryStage
	 * this method creates the main stage and scene
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
		scene = new Scene(new MasterPane(width, height), width, height);
		primaryStage.setTitle("Smart-Snek");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * @param args
	 * launches the program
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

}//end GUIManager