package Package1;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class GamePane extends Pane {

	public SnakeManager m_SnakeManager;



	public void finalize() throws Throwable {
		super.finalize();
	}
	public GamePane()
	{
		Text Title = new Text("I am the Game Pane");
		getChildren().add(Title);
		setPrefSize(500, 350);
		setLayoutX(210);
		setLayoutY(10);
		setStyle("-fx-background-color: 'lightgrey';");

	}
}//end GamePane