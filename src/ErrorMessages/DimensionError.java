package ErrorMessages;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DimensionError {

	
	public static void ShowError() {
		
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Dimension");
		errorAlert.setContentText("The gridpane in gamepane is cropping out of proportions.");
		errorAlert.showAndWait();
		
	}
}