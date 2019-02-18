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
	public ControlPane(double width, double height)
	{
		Text Title = new Text("I am the Control Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.25, height);
		
		//The top left corner of this pane is at (0, 0)
		setLayoutX(0);
		setLayoutY(0);
		setStyle("-fx-background-color: 'green';");

	}
}//end ControlPane