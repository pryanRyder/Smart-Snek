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
	public DisplayPane(double width, double height)
	{
		Text Title = new Text("I am the Display Pane");
		getChildren().add(Title);
		setPrefSize(width * 0.75, height * 0.25);
		
		//The top left corner of this pane is at (width * 0.25, height * 0.75)
		setLayoutX(width * 0.25);
		setLayoutY(height * 0.75);
		setStyle("-fx-background-color: 'red';");

	}
}//end DisplayPane