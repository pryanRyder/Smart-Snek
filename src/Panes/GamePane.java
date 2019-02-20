package Panes;

import Snake.SnakeManager;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GamePane extends Pane {

	public SnakeManager m_SnakeManager;

	
	public void finalize() throws Throwable {
		super.finalize();
	}
	public GamePane(double width, double height)
	{
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.75);
		
		//The top left corner of this pane is at (width * 0.25, 0)
		setLayoutX(width * 0.25);
		setLayoutY(0);
		setStyle("-fx-background-color: '#6d6d6d';");
		
	
		TilePane tilepane = new TilePane();
		
				tilepane.setPrefColumns(20);
				tilepane.setPadding(new Insets(5,5,5,5));

				
			for(int x = 0; x<240; x++) {
				Rectangle rec = new Rectangle();
				rec.setHeight(28);
				rec.setWidth(28);
				rec.setFill(Color.DARKCYAN);
				tilepane.getChildren().add(rec);
			}
			
			
			
		    tilepane.setHgap(2);
		    tilepane.setVgap(2);
		    tilepane.relocate(80.0, 60.0);
		    tilepane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
		   
		 
		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.90, getPrefHeight()*0.90);
		content.setLayoutX(getPrefWidth()*0.05);
		content.setLayoutY(getPrefHeight()*0.05);
		content.setStyle("-fx-background-color: 'black'");
		
		getChildren().addAll(content,tilepane);

	}
}//end GamePane