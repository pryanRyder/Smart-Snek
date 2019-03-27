package ErrorMessages;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OutOfBounds {

	public static void ShowError() {
		
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Out of bounds");
		errorAlert.setContentText("The X and/or Y coordinats of the tail are outside the gridpane.");
		errorAlert.show();
		System.exit(-1);
	}
}
