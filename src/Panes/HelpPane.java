package Panes;
 
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
 
import javafx.stage.Stage;

public class HelpPane extends Pane {
	
	public void finalize() throws Throwable{
		super.finalize();
	}
	Scene scene;
	
	public HelpPane (double width, double height)
	{
		Pane gamePane = new GamePane(width, height);
		getChildren().add(gamePane);

		setPrefSize(width * 0.10, height);
		
		//The top left corner of this pane is at (0, 0)
				setLayoutX(0);
				setLayoutY(0);
				setStyle("-fx-background-color: '#4f4f4f';");

			}
}