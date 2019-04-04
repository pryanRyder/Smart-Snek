package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class DisplayPane extends Pane {
	
	static Text Iteration = new Text();

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public static void getIteration(String Iter) 
	{
		Iteration.setText(Iter);
	}
	
	public DisplayPane(double width, double height)
	{
		
		
		
		setPrefSize(width * 0.75, height * 0.25);
		
		//The top left corner of this pane is at (width * 0.25, height * 0.75)
		setLayoutX(width * 0.25);
		setLayoutY(height * 0.75);
		setStyle("-fx-background-color: '#4f4f4f';");
		
		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.98, getPrefHeight()*0.90);
		content.setLayoutX(getPrefWidth()*0.001);
		content.setLayoutY(getPrefHeight()*0.05);
		content.setStyle("-fx-background-color: '#a5a5a5'");
		getChildren().add(content);
		
		Text Title = new Text("Display Panel");
		Title.setStyle("-fx-font-size: 20;");    
		Title.setLayoutX(content.getPrefWidth()*0.01);
		Title.setLayoutY(content.getPrefHeight()*0.15);
		
//   << Iteration Pane Build >>	
		Pane iterationPane = new Pane();
		iterationPane.setPrefSize(getPrefWidth()*0.15, getPrefHeight()*0.6);
		iterationPane.setLayoutX(getPrefWidth()*0.01);
		iterationPane.setLayoutY(getPrefHeight()*0.2);
		iterationPane.setStyle("-fx-background-color: '#a5a5a5'");
		
		Text iterationTitle = new Text("Iteration");
		iterationTitle.setStyle("-fx-font-size: 20;");    
		iterationTitle.setLayoutX(iterationPane.getPrefWidth()*0.01);
		iterationTitle.setLayoutY(iterationPane.getPrefHeight()*0.15);
		
		Iteration.setLayoutX(iterationPane.getPrefWidth()*0.25);
		Iteration.setLayoutY(iterationPane.getPrefHeight()*0.6);
		Iteration.setFont(Font.font(35));
		
		iterationPane.getChildren().addAll(iterationTitle, Iteration);
//   << End Iteration Pane   >>
		
		content.getChildren().addAll(Title, iterationPane);
		
		

		
		

	}
}//end DisplayPane