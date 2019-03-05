package Panes;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class HelpTabPane extends Pane {



	public void finalize() throws Throwable {
		super.finalize();
	}
	public void HelpTabPane(){


		final String aboutText = "Hello this is the snek game, to move your snek use your arrow keys. ";

		Alert popup = new Alert(Alert.AlertType.INFORMATION, aboutText, ButtonType.OK);
		
		popup.setHeaderText("About This Game");
		popup.setTitle("About");
		popup.showAndWait();
		
	}
}//end HelpTabPane