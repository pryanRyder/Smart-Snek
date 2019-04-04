package Snake;

import java.util.ArrayList;

import CompareData.*;
import GamePaneHelper.GamePaneSetsGets;
import Panes.GamePane;
import PrintData.PrintSnake;

public class SnakeRandCalc {

	private static ArrayList<int[]> validSquares = new ArrayList<int[]>();
	
	public static void randCalc(int[] tail, int[] head, boolean justAte, Snake snake, boolean startOfGame) {
		
		if(startOfGame == true) {
			
			//Make the entire grid except for [0,0] valid
			int row=0;
			for(row=0; row<GamePaneSetsGets.getRecsRow(); row++) {
				
				int col=0;
				for(col=0; col<GamePaneSetsGets.getRecsCol(); col++) {
					
					int[] square = {row, col};
					validSquares.add(square);
				}
			}
			
			int i=0;
			for(i=0; i<validSquares.size(); i++) {
				
				int[] start = {0, 0};
				if(CompareIntArray.compareIntArray(validSquares.get(i), start)) {
					
					validSquares.remove(i);
				}
			}
		}
		else if(startOfGame == false) {
			
			//Update the head/tail
			if(justAte == true) {
				
				//int i=0;
				//for(i=0; i<validSquares.size(); )
			}
			else if(justAte == false) {
				
				
			}
		}
	}
	
	
	
}
