package Panes;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;



/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class HelpTabPane extends Pane {
	
	public void finalize() throws Throwable 
	{
		super.finalize();
	}
	
	Scene scene;

			
	
	private BorderPane borderPane;
	
	// Menu stuff
	private MenuBar menuBar;							// MenuBar
	private MenuItem miClose;							// Close MenuItem
	private MenuItem miAbout;
	private Menu  menuFile, menuHelp;		// Menus
	
	
	/** Default constructor */
	public HelpTabPane(double width,  double height){
		//Pane helpTabPane = new HelpTabPane(width, height);
		
		// Create the BorderPane
		borderPane = new BorderPane();
		menuHelp = new Menu();

		/* MENU CREATION */
		// Create MenuItems
		miClose = new MenuItem("Close");
		miAbout = new MenuItem("About..");
	
		// Create Menus
		menuFile = new Menu("File");
		menuHelp = new Menu("Help");

		// Add menu items to respective menus
		menuHelp.getItems().add(miAbout);
		// Add menus to menuBar
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menuFile, menuHelp);


		
		/** Shows information about the program in it's own window */
		//private void showAbout()

			final String aboutText = "Hello this is the snek game, to move your snek use your arrow keys. ";

			Alert popup = new Alert(Alert.AlertType.INFORMATION, aboutText, ButtonType.OK);
			
			popup.setHeaderText("About This Game");
			popup.setTitle("About");
			popup.showAndWait();
			
		}
	


	/**
	 * 
	 * @param primaryStage
	 */
	

	

} // End of HelpTabPane