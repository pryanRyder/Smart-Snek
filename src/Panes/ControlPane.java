package Panes;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
		Text txtLearningRate = new Text("Learning Rate");
		TextField tfLearningRate = new TextField();
		Text txtDiscountFactor = new Text("Discount Factor");
		TextField tfDiscountFactor = new TextField();
		Text txtMaximumReward = new Text("Maximum Reward");
		TextField tfMaximumReward = new TextField();
		
		Pane geneticAlgorithmPane = new Pane();
		

		
		geneticAlgorithmPane.setStyle("-fx-background-color: '#e0e0e0'");
		geneticAlgorithmPane.setLayoutX(getPrefWidth()*0.02);
		geneticAlgorithmPane.setLayoutY(getPrefHeight()*0.6);
		geneticAlgorithmPane.setPrefHeight(content.getPrefHeight()*.195);
		geneticAlgorithmPane.setPrefWidth(content.getPrefWidth()*.95);
		content.getChildren().add(geneticAlgorithmPane);
		
		Rectangle gaCheckBox = new Rectangle(25,25);
		gaCheckBox.setFill(Color.WHITE);
		gaCheckBox.setStroke(Color.BLACK);
		gaCheckBox.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.6);
		gaCheckBox.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.05);
		geneticAlgorithmPane.getChildren().add(gaCheckBox);
		
		
		Text txtGeneticAlgorithm = new Text("Genetic Algorithm");
		txtGeneticAlgorithm.setStyle("-fx-font-size: 18");
		txtGeneticAlgorithm.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.02);
		txtGeneticAlgorithm.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.15);
		txtGeneticAlgorithm.setDisable(true);
		geneticAlgorithmPane.getChildren().add(txtGeneticAlgorithm);
		txtGeneticAlgorithm.setFill(Color.DARKGREY);

		
		
		Text txtPopulationSize = new Text("Population Size");
		txtPopulationSize.setStyle("-fx-font-size: 15");
		txtPopulationSize.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.02);
		txtPopulationSize.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.35);
		txtPopulationSize.setFill(Color.DARKGREY);

		geneticAlgorithmPane.getChildren().add(txtPopulationSize);
		
		TextField tfPopulationSize = new TextField();
		tfPopulationSize.setStyle("-fx-font-size: 15");
		tfPopulationSize.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.02);
		tfPopulationSize.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.40);
		tfPopulationSize.setPrefWidth(geneticAlgorithmPane.getPrefWidth()*0.2);
		tfPopulationSize.setDisable(true);

		geneticAlgorithmPane.getChildren().add(tfPopulationSize);
		
		Text txtMutationRate = new Text("Mutation Rate");
		txtMutationRate.setStyle("-fx-font-size: 15");
		txtMutationRate.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.02);
		txtMutationRate.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.70);
		txtMutationRate.setFill(Color.DARKGREY);


		geneticAlgorithmPane.getChildren().add(txtMutationRate);
		
		TextField tfMutationRate = new TextField();
		tfMutationRate.setStyle("-fx-font-size: 15");
		tfMutationRate.setLayoutX(geneticAlgorithmPane.getPrefWidth()*0.02);
		tfMutationRate.setLayoutY(geneticAlgorithmPane.getPrefHeight()*0.75);
		tfMutationRate.setPrefWidth(geneticAlgorithmPane.getPrefWidth()*0.2);
		tfMutationRate.setDisable(true);

		
		gaCheckBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
				GAChecked = !GAChecked;

				if(GAChecked)
				{
					gaCheckBox.setFill(Color.BLACK);
					gaCheckBox.setStroke(Color.WHITE);
					txtMutationRate.setFill(Color.BLACK);
					tfMutationRate.setDisable(false);
					txtPopulationSize.setFill(Color.BLACK);
					tfPopulationSize.setDisable(false);
					txtGeneticAlgorithm.setFill(Color.BLACK);
				}
				else
				{
					gaCheckBox.setFill(Color.WHITE);
					gaCheckBox.setStroke(Color.BLACK);
					txtMutationRate.setFill(Color.DARKGREY);
					tfMutationRate.setDisable(true);
					txtPopulationSize.setFill(Color.DARKGREY);
					tfPopulationSize.setDisable(true);
					txtGeneticAlgorithm.setFill(Color.DARKGREY);
				}
			}
			
		});
		geneticAlgorithmPane.getChildren().add(tfMutationRate);
		
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
		
		btStartTraining.setLayoutX(trainingPane.getPrefWidth()*.02);
		btStartTraining.setLayoutY(trainingPane.getPrefHeight()*.6);
		trainingPane.getChildren().add(btStartTraining);
		
		btPlay.setLayoutX(trainingPane.getPrefWidth()*.02);
		btPlay.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btPlay);
		
		btPause.setLayoutX(trainingPane.getPrefWidth()*.2);
		btPause.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btPause);
		
		btRestart.setLayoutX(trainingPane.getPrefWidth()*.4);
		btRestart.setLayoutY(trainingPane.getPrefHeight()*.3);
		trainingPane.getChildren().add(btRestart);

		
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
		
		Button btDeepReinforcement = new Button("Deep Reinforcement");
		btDeepReinforcement.setLayoutX(AgentPane.getPrefWidth()*.02);
		btDeepReinforcement.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeepReinforcement);
		
		Button btDeep2 = new Button("Deep2");
		btDeep2.setLayoutX(AgentPane.getPrefWidth()*.50);
		btDeep2.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeep2);
		
		Button btDeep3 = new Button("Deep3");
		btDeep3.setLayoutX(AgentPane.getPrefWidth()*.75);
		btDeep3.setLayoutY(AgentPane.getPrefHeight()*.1);
		AgentPane.getChildren().add(btDeep3);
		
		txtAgentPane = new Text("Agent Controller");
		txtAgentPane.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtAgentPane.setLayoutY(AgentPane.getPrefHeight()*.05);
		txtAgentPane.setStyle("-fx-font-size: 18");
		AgentPane.getChildren().add(txtAgentPane);
		
		txtLearningRate.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtLearningRate.setLayoutY(AgentPane.getPrefHeight()*.30);
		AgentPane.getChildren().add(txtLearningRate);
		txtLearningRate.setStyle("-fx-font-size: 15;");


		tfLearningRate.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfLearningRate.setLayoutY(AgentPane.getPrefHeight()* .33);
		AgentPane.getChildren().add(tfLearningRate);
		
		txtDiscountFactor.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtDiscountFactor.setLayoutY(AgentPane.getPrefHeight()*.46);
		txtDiscountFactor.setStyle("-fx-font-size: 15;");

		AgentPane.getChildren().add(txtDiscountFactor);
		
		tfDiscountFactor.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfDiscountFactor.setLayoutY(AgentPane.getPrefHeight()*.49);
		AgentPane.getChildren().add(tfDiscountFactor);
		
		txtMaximumReward.setLayoutX(AgentPane.getPrefWidth()*.02);
		txtMaximumReward.setLayoutY(AgentPane.getPrefHeight()*.61);
		txtMaximumReward.setStyle("-fx-font-size: 15;");

		AgentPane.getChildren().add(txtMaximumReward);		
		
		tfMaximumReward.setLayoutX(AgentPane.getPrefWidth()*.02);
		tfMaximumReward.setLayoutY(AgentPane.getPrefHeight()*.64);
		AgentPane.getChildren().add(tfMaximumReward);
		
		btCreateNew.setLayoutX(AgentPane.getPrefWidth()*.02);
		btCreateNew.setLayoutY(AgentPane.getPrefHeight()*.80);
		AgentPane.getChildren().add(btCreateNew);

		
		getChildren().add(content);
		Text Title = new Text("Control Panel");
		
		/*
		AgentPane.setStyle("-fx-background-color: '#e0e0e0'");
		AgentPane.setLayoutX(getPrefWidth()*0.02);
		AgentPane.setLayoutY(getPrefHeight()*0.10);
		AgentPane.setPrefHeight(content.getPrefHeight()*.50);
		AgentPane.setPrefWidth(content.getPrefWidth()*.95);
		content.getChildren().add(AgentPane);
		*/
		
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