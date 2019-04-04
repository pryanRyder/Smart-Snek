package Panes;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import Snake.Snake;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class DisplayPane extends Pane {
	
	static Text Iteration = new Text();
	static Text Score = new Text();
	static Text HighScore = new Text();

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public static void getIteration(String Iter) 
	{
		Iteration.setText(Iter);
	}
	
	public static void getScore(String score) 
	{
		Score.setText(score);
	}
	
	public static void getHighScore(String highscore) 
	{
		HighScore.setText(highscore);
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
		
//   << Score Pane Build >>	
		Pane scorePane = new Pane();
		scorePane.setPrefSize(getPrefWidth()*0.15, getPrefHeight()*0.6);
		scorePane.setLayoutX(getPrefWidth()*0.1);
		scorePane.setLayoutY(getPrefHeight()*0.2);
		scorePane.setStyle("-fx-background-color: '#a5a5a5'");
			
		Text scoreTitle = new Text("Score");			
		scoreTitle.setStyle("-fx-font-size: 20;");    
		scoreTitle.setLayoutX(scorePane.getPrefWidth()*0.01);
		scoreTitle.setLayoutY(scorePane.getPrefHeight()*0.15);
		
		Score.setLayoutX(scorePane.getPrefWidth()*0.25);
		Score.setLayoutY(scorePane.getPrefHeight()*0.6);
		Score.setFont(Font.font(35));
			
		scorePane.getChildren().addAll(scoreTitle, Score);
//   << End Score Pane   >>
		
//   << HighScore Pane Build >>	
		Pane highscorePane = new Pane();
		highscorePane.setPrefSize(getPrefWidth()*0.15, getPrefHeight()*0.6);
		highscorePane.setLayoutX(getPrefWidth()*0.19);
		highscorePane.setLayoutY(getPrefHeight()*0.2);
		highscorePane.setStyle("-fx-background-color: '#a5a5a5'");
				
		Text highscoreTitle = new Text("High-Score");			
		highscoreTitle.setStyle("-fx-font-size: 20;");    
		highscoreTitle.setLayoutX(highscorePane.getPrefWidth()*0.01);			
		highscoreTitle.setLayoutY(highscorePane.getPrefHeight()*0.15);
			
		HighScore.setLayoutX(highscorePane.getPrefWidth()*0.25);
		HighScore.setLayoutY(highscorePane.getPrefHeight()*0.6);
		HighScore.setFont(Font.font(35));
				
		highscorePane.getChildren().addAll(highscoreTitle, HighScore);
//   << End HighScore Pane   >>
		
		content.getChildren().addAll(Title, iterationPane, scorePane, highscorePane);
		
		

		
		

	}
}//end DisplayPane