package PaneHelper;

import Panes.GamePane;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GridPaneSetUp {

	
	public static void gridPaneSetUp(GamePane gamepane, GridPane gridpane, Rectangle[][] recs) {
		
		//The scale of the gridpane size to the gamepane size.
		double scale = 0.9;
		
		//The scaler for the borders.
		double borderScale = 0.2;
		
		//The scaler for the gaps.
		double gapScale = 0.05;
		
		CalculateGridPane.CalculateTheGridPane(scale, borderScale, gapScale, gamepane, gridpane, recs);
	}
	
}