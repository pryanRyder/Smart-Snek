package Panes;

import Agent.SnakeBrain;
import Snake.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class ControlPane extends Pane {

	boolean GAChecked = false;


	public void finalize() throws Throwable {
		super.finalize();
	}
	public ControlPane(double width, double height)
	{

		Pane gamePane = new GamePane(width, height);
		getChildren().add(gamePane);
		

		setPrefSize(width * 0.25, height);

		//The top left corner of this pane is at (0, 0)
		setLayoutX(0);
		setLayoutY(0);
		setStyle("-fx-background-color: '#4f4f4f';");

		Pane content = new Pane();
		content.setPrefSize(getPrefWidth()*0.95, getPrefHeight()*0.975);
		content.setLayoutX(getPrefWidth()*0.02);
		content.setLayoutY(getPrefHeight()*0.01);
		content.setStyle("-fx-background-color: '#a5a5a5'");

		Text txtAgentPane = new Text("Agent");
		Pane AgentPane = new Pane();
		Pane gridSizePane = new Pane();

		gridSizePane.setStyle("-fx-background-color: '#e0e0e0'");
		gridSizePane.setLayoutX(getPrefWidth()*0.02);
		gridSizePane.setLayoutY(getPrefHeight()*0.6);
		gridSizePane.setPrefHeight(content.getPrefHeight()*.195);
		gridSizePane.setPrefWidth(content.getPrefWidth()*.95);
		content.getChildren().add(gridSizePane);

		Text txtgridSize = new Text("Grid Size");
		txtgridSize.setStyle("-fx-font-size: 18");
		txtgridSize.setLayoutX(gridSizePane.getPrefWidth()*0.02);
		txtgridSize.setLayoutY(gridSizePane.getPrefHeight()*0.15);
		txtgridSize.setDisable(true);
		gridSizePane.getChildren().add(txtgridSize);

		Text txtWidth = new Text("Width Size");
		txtWidth.setStyle("-fx-font-size: 15");
		txtWidth.setLayoutX(gridSizePane.getPrefWidth()*0.02);
		txtWidth.setLayoutY(gridSizePane.getPrefHeight()*0.35);

		gridSizePane.getChildren().add(txtWidth);

		TextField tfWidth = new TextField();
		tfWidth.setStyle("-fx-font-size: 15");
		tfWidth.setLayoutX(gridSizePane.getPrefWidth()*0.02);
		tfWidth.setLayoutY(gridSizePane.getPrefHeight()*0.40);
		tfWidth.setPrefWidth(gridSizePane.getPrefWidth()*0.2);

		gridSizePane.getChildren().add(tfWidth);

		Text txtHeight = new Text("Mutation Rate");
		txtHeight.setStyle("-fx-font-size: 15");
		txtHeight.setLayoutX(gridSizePane.getPrefWidth()*0.02);
		txtHeight.setLayoutY(gridSizePane.getPrefHeight()*0.70);
		gridSizePane.getChildren().add(txtHeight);

		TextField tfHeight = new TextField();
		tfHeight.setStyle("-fx-font-size: 15");
		tfHeight.setLayoutX(gridSizePane.getPrefWidth()*0.02);
		tfHeight.setLayoutY(gridSizePane.getPrefHeight()*0.75);
		tfHeight.setPrefWidth(gridSizePane.getPrefWidth()*0.2);
		gridSizePane.getChildren().add(tfHeight);

		Button btChange = new Button("Change");
		btChange.setStyle("-fx-font-size: 15");
		btChange.setLayoutX(gridSizePane.getPrefWidth()*0.7);
		btChange.setLayoutY(gridSizePane.getPrefHeight()*0.80);
		gridSizePane.getChildren().add(btChange);

		btChange.setOnAction(e ->
		{
			((GamePane) gamePane).ChangeGridSize(Integer.parseInt(tfWidth.getText()), Integer.parseInt(tfHeight.getText()));
		});


		Button btCreateNew = new Button("Create New");
		Button btUpload = new Button("Upload");

		Pane trainingPane = new Pane();

		trainingPane.setStyle("-fx-background-color: '#e0e0e0'");
		trainingPane.setLayoutX(getPrefWidth()*0.02);
		trainingPane.setLayoutY(getPrefHeight()*0.80);
		trainingPane.setPrefHeight(content.getPrefHeight()*.15);
		trainingPane.setPrefWidth(content.getPrefWidth()*.95);
		content.getChildren().add(trainingPane);

		Button btStop = new Button("STOP");
		Button btStartTraining = new Button("Start Training");
		Button btPlay = new Button("Play");
		Button btPause = new Button("Pause");
		Button btRestart = new Button("Restart");

		Text txtTrainingController = new Text("Training Controller");
		txtTrainingController.setStyle("-fx-font-size: 18");
		txtTrainingController.setLayoutX(trainingPane.getPrefWidth()*0.02);
		txtTrainingController.setLayoutY(trainingPane.getPrefHeight()*0.2);
		trainingPane.getChildren().add(txtTrainingController);

		btStop.setLayoutX(trainingPane.getPrefWidth()*.4);
		btStop.setLayoutY(trainingPane.getPrefHeight()*.6);
		trainingPane.getChildren().add(btStop);
		btStop.setDisable(true);

		btStop.setOnAction(e->
		{
			((GamePane) gamePane).Stop();
			btPlay.setDisable(true);
			btPause.setDisable(true);
			btRestart.setDisable(true);
			btStop.setDisable(true);
			btStartTraining.setDisable(false);

		});

		btStartTraining.setLayoutX(trainingPane.getPrefWidth()*.02);
		btStartTraining.setLayoutY(trainingPane.getPrefHeight()*.6);
		trainingPane.getChildren().add(btStartTraining);

		btStartTraining.setOnAction(e->
		{
			((GamePane) gamePane).resetSnake();
			((GamePane) gamePane).Play();

			btStartTraining.setDisable(true);
			btPause.setDisable(false);
			btRestart.setDisable(false);
			btStop.setDisable(false);

		});

		btPlay.setLayoutX(trainingPane.getPrefWidth()*.02);
		btPlay.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btPlay);
		btPlay.setDisable(true);

		btPlay.setOnAction(e->
		{
			((GamePane) gamePane).Play();
			btPlay.setDisable(true);
			btPause.setDisable(false);
		});

		btPause.setLayoutX(trainingPane.getPrefWidth()*.2);
		btPause.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btPause);
		btPause.setDisable(true);

		btPause.setOnAction(e->
		{
			((GamePane) gamePane).Stop();
			btPause.setDisable(true);
			btPlay.setDisable(false);
		});

		btRestart.setLayoutX(trainingPane.getPrefWidth()*.4);
		btRestart.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btRestart);
		btRestart.setDisable(true);

		btRestart.setOnAction(e->
		{
			btPlay.setDisable(true);
			btPause.setDisable(false);
			((GamePane) gamePane).resetSnake();
			((GamePane) gamePane).Play();
		});


		/*
		txtAgentPane.setLayoutX(content.getPrefWidth()*.04);
		txtAgentPane.setLayoutY(content.getPrefHeight()*.12);
		txtAgentPane.setStyle("-fx-font-size: 18;");
		content.getChildren().add(txtAgentPane);
*/


		btUpload.setLayoutX(content.getPrefWidth()*.02);
		btUpload.setLayoutY(content.getPrefHeight()*.15);
		content.getChildren().add(btUpload);

		AgentPane.setStyle("-fx-background-color: '#e0e0e0'");
		AgentPane.setLayoutX(getPrefWidth()*0.02);
		AgentPane.setLayoutY(getPrefHeight()*0.10);
		AgentPane.setPrefHeight(content.getPrefHeight()*.50);
		AgentPane.setPrefWidth(content.getPrefWidth()*.95);
		content.getChildren().add(AgentPane);

		Text txtLearningRate = new Text("Learning Rate");
		TextField tfLearningRate = new TextField();
		Text txtDiscountFactor = new Text("Discount Factor");
		TextField tfDiscountFactor = new TextField();
		Text txtMaximumReward = new Text("Maximum Reward");
		TextField tfMaximumReward = new TextField();
		txtLearningRate.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtLearningRate.setLayoutY(AgentPane.getPrefHeight()*.30);
		txtLearningRate.setStyle("-fx-font-size: 15;");
		tfLearningRate.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfLearningRate.setLayoutY(AgentPane.getPrefHeight()* .33);
		txtDiscountFactor.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtDiscountFactor.setLayoutY(AgentPane.getPrefHeight()*.46);
		txtDiscountFactor.setStyle("-fx-font-size: 15;");
		tfDiscountFactor.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfDiscountFactor.setLayoutY(AgentPane.getPrefHeight()*.49);
		txtMaximumReward.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtMaximumReward.setLayoutY(AgentPane.getPrefHeight()*.61);
		txtMaximumReward.setStyle("-fx-font-size: 15;");
		tfMaximumReward.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfMaximumReward.setLayoutY(AgentPane.getPrefHeight()*.64);
		
		Button btDeep2 = new Button("Deep2");
		Button btDeepReinforcement = new Button("Deep Reinforcement");
		btDeepReinforcement.setLayoutX(AgentPane.getPrefWidth()*.02);
		btDeepReinforcement.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeepReinforcement);
		btDeepReinforcement.setOnAction(ex->{
			((GamePane) gamePane).setColor(Color.PURPLE);
			AgentPane.getChildren().add(txtLearningRate);
			AgentPane.getChildren().add(tfLearningRate);
			AgentPane.getChildren().add(txtDiscountFactor);
			AgentPane.getChildren().add(tfDiscountFactor);
			AgentPane.getChildren().add(txtMaximumReward);
			AgentPane.getChildren().add(tfMaximumReward);
			btDeepReinforcement.setTextFill(Color.PURPLE);

		});

		//Button btDeep2 = new Button("Deep2");
		btDeep2.setLayoutX(AgentPane.getPrefWidth()*.50);
		btDeep2.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeep2);
		btDeep2.setOnAction(ex->{
			((GamePane) gamePane).setColor(Color.ORANGE);
			AgentPane.getChildren().remove(tfMaximumReward);
			AgentPane.getChildren().remove(tfDiscountFactor);
			AgentPane.getChildren().remove(txtMaximumReward);
			AgentPane.getChildren().remove(txtDiscountFactor);
			AgentPane.getChildren().remove(txtLearningRate);
			AgentPane.getChildren().remove(tfLearningRate);
			btDeep2.setTextFill(Color.ORANGE);

		});

		Button btDeep3 = new Button("Deep3");
		btDeep3.setLayoutX(AgentPane.getPrefWidth()*.75);
		btDeep3.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeep3);
		btDeep3.setOnAction(ex->{
			((GamePane) gamePane).setColor(Color.GREEN);
			AgentPane.getChildren().remove(tfMaximumReward);
			AgentPane.getChildren().remove(tfDiscountFactor);
			AgentPane.getChildren().remove(txtMaximumReward);
			AgentPane.getChildren().remove(txtDiscountFactor);
			AgentPane.getChildren().remove(txtLearningRate);
			AgentPane.getChildren().remove(tfLearningRate);
			btDeep3.setTextFill(Color.GREEN);
			

		});
	//This faster button makes the snake move faster
		Button snekSpeed= new Button ("Faster");
		snekSpeed.setLayoutX(AgentPane.getPrefWidth()*.75);
		snekSpeed.setLayoutY(AgentPane.getPrefHeight()*.85);
		AgentPane.getChildren().add(snekSpeed);
		
		snekSpeed.setOnAction(ex2->{
			KeyFrame keyframe1 = new KeyFrame(Duration.millis(35), action ->
			{
				// Boolean Value that Determines whether you can go back on top of yourself
				((GamePane) gamePane).onlyOneDirection = true;

			    //---------------------------- GAME IMPLEMENTATION ------------------------------- //


				//moves the snake based off of key presses
				((GamePane) gamePane).keyPressHandler();

				//moves the snakes position
				((GamePane) gamePane). snek.move();

			    //Checks if snake hits wall and resets the snake if dead
			    ((GamePane) gamePane).  CheckIfSnakeHitWall();

			    //Clears the Grid
			    ((GamePane) gamePane).ClearGrid();

				//Displays Objective Item
				((GamePane) gamePane).recs[((GamePane) gamePane).snek.objectiveItem[0]][((GamePane) gamePane).snek.objectiveItem[1]].setFill(Color.RED);

			    //Moves the Snakes Position in GridPane
			    ((GamePane) gamePane).moveSnakeDisplay();

				//Checks if the Snake ran into itself and resets if true
				((GamePane) gamePane).CheckIfSnakeHitSelf();

				//adds to score if snake eats objective item
				((GamePane) gamePane). snek.ateObjectiveItem();
			    ((DisplayPane) ((GamePane) gamePane).displayPane).setScore(((GamePane) gamePane).snek.score+"");

			    //---------------------------- AI Integration ------------------------------- //

			    //updates brain with the environment
			    ((GamePane) gamePane). snakeBrain.updateSnake(((GamePane) gamePane).snek);
			    //brain makes decision based off of the environment
			    ((GamePane) gamePane).snakeBrain.MakeDecision();
			    //brain decides on a direction and changes the path of the snake
			    ((GamePane) gamePane).snek.changeDirection(((GamePane) gamePane).snakeBrain.getDecidedDecidedDirection());

			});
			
			((GamePane) gamePane).timeline.getKeyFrames().add(keyframe1);
		});
		
		
		txtAgentPane = new Text("Agent Controller");
		txtAgentPane.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtAgentPane.setLayoutY(AgentPane.getPrefHeight()*.05);
		txtAgentPane.setStyle("-fx-font-size: 18");
		AgentPane.getChildren().add(txtAgentPane);



		btCreateNew.setLayoutX(AgentPane.getPrefWidth()*.02);
		btCreateNew.setLayoutY(AgentPane.getPrefHeight()*.80);
		AgentPane.getChildren().add(btCreateNew);


		getChildren().add(content);
		Text Title = new Text("Control Panel");

		Pane TitlePane = new Pane();
		TitlePane.setStyle("-fx-background-color: '#e0e0e0'");
		TitlePane.setLayoutX(getPrefWidth()*0.02);
		TitlePane.setLayoutY(getPrefHeight()*0.02);
		TitlePane.setPrefHeight(content.getPrefHeight()*.073);
		TitlePane.setPrefWidth(content.getPrefWidth()*.95);
		TitlePane.getChildren().add(Title);
		content.getChildren().add(TitlePane);


		Title.setStyle("-fx-font-size: 20;"); // NEEDS TO BE CHANGED BASED ON SIZE
		Title.setLayoutX(content.getPrefWidth()*0.04);
		Title.setLayoutY(content.getPrefHeight()*0.04);
		//Title.setLayoutX(value);
		//Title.setLayoutY();
		


	}
}//end ControlPane
