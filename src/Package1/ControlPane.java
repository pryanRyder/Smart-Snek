package Package1;

import javafx.scene.layout.Pane;

import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class ControlPane extends Pane {



	public void finalize() throws Throwable {
		super.finalize();
	}
	public ControlPane()
		Text Title = new Text("I am the Control Pane");
		getChildren().add(Title);
		setPrefSize(190, 460);
		setLayoutX(10);
		setLayoutY(10);
		setStyle("-fx-background-color: 'lightgrey';");

	}
}//end ControlPane