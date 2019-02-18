package Package1;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:58 PM
 */
public class DisplayPane extends Pane {



	public void finalize() throws Throwable {
		super.finalize();
	}
	public DisplayPane()
	{
		Text Title = new Text("I am the Display Pane");
		getChildren().add(Title);
		setPrefSize(500, 100);
		setLayoutX(210);
		setLayoutY(370);
		setStyle("-fx-background-color: 'lightgrey';");

	}
}//end DisplayPane