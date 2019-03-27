package PaneHelper;

import ErrorMessages.DimensionError;
import Panes.GamePane;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CalculateGridPane {
	
	public static void CalculateTheGridPane(double scale, double borderScale, double gapScale,
			GamePane gamepane, GridPane gridpane, Rectangle[][] recs) {
		
		//The size of the gaps.
		double gapSize;
		
		//The thickness of the borders.
		double topBorder, rightBorder, bottomBorder, leftBorder;
		
		//The side length of the boxes.
		double boxSide;
		
		//The height and width of the gridpane
		double gHeight, gWidth;
		
		//Figure out what the side length of the squares are.
		// gamepane.getPrefHeight()*scale = 2*(borderScale*boxSide)+(# of rows)*boxSide +
		//(# of rows -1)*(gapScale*boxSide)
		
		//The scale will change the height, and in return, will also change the width.
		double numerator = gamepane.getPrefHeight() * scale;
		double denominator = 2*borderScale + recs.length + (recs.length-1)*gapScale;
		boxSide = numerator / denominator;
		
		topBorder = rightBorder = bottomBorder = leftBorder = boxSide*borderScale;
		gapSize = boxSide*gapScale;
		
		//Set the borders.
		gridpane.setPadding(new Insets(topBorder, rightBorder, bottomBorder, leftBorder));
		
		int row=0;
		for(row=0; row < recs.length; row++) {
			
			int col=0;
			for(col=0; col < recs[row].length; col++) {
				
				Rectangle rec = new Rectangle();
				rec.setHeight(boxSide);
				rec.setWidth(boxSide);
				rec.setFill(Color.DARKCYAN);
				
				recs[row][col] = rec;
				
				gridpane.add(recs[row][col], col, row);
			}
		}
		
	    gridpane.setHgap(gapSize);
	    gridpane.setVgap(gapSize);
	    
	    //Test to see if gridpane is out of proportions.
	    gWidth = 2*(borderScale*boxSide) + recs[0].length*boxSide + 
	    		(recs[0].length - 1)*gapScale*boxSide;
	    
	    gHeight = 2*(borderScale*boxSide) + recs.length*boxSide + 
	    		(recs.length - 1)*gapScale*boxSide;
	   
	    double xPos = (gamepane.getPrefWidth()-gWidth)/2;
	    double yPos = (gamepane.getPrefHeight()-gHeight)/2;
	    
	    gridpane.relocate(xPos, yPos);
	    
	    //Test to see if gridpane is out of proportions. 
	    if(gWidth+xPos > gamepane.getPrefWidth() || gHeight+yPos > gamepane.getPrefHeight()) {
	    	DimensionError.ShowError();
	    }
	    
	}
}