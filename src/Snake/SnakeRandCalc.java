package Snake;

import java.util.ArrayList;

import CompareData.*;
import GamePaneHelper.GamePaneSetsGets;
import Panes.GamePane;
import PrintData.PrintSnake;

public class SnakeRandCalc {

	private static ArrayList<int[]> validSquares = new ArrayList<int[]>();

	public static void randCalc(int[] tail, int[] head, boolean justAte, Snake snake, boolean startOfGame) {

		// If the game started
		if (startOfGame == true) {

			// Add all squares.
			int i = 0;
			for (i = 0; i < GamePaneSetsGets.getRecsRow(); i++) {

				int j = 0;
				for (j = 0; j < GamePaneSetsGets.getRecsCol(); j++) {

					int[] validSquare = new int[2];
					validSquare[0] = i;
					validSquare[1] = j;
					validSquares.add(validSquare);
				}
			}
			System.out.println("Num of valud squares: " + validSquares.size());

			System.out.println("NEW GAME");

			// PrintSnake.printSnake(snake);
			// Remove [0, 0]
			int[] startingSquare = { 0, 0 };
			for (i = 0; i < validSquares.size(); i++) {

				if (CompareIntArray.compareIntArray(snake.Positions.get(0), startingSquare)) {

					validSquares.remove(i);
					System.out.println("Removed!");
				}

			}
			System.out.println("Num of valud squares: " + validSquares.size());
		} else if (startOfGame == false) {

			System.out.println("CURRENT GAME");
		}

		if (justAte == true) {

			// update valid squares

		} else if (justAte == false) {

			// update valid squares
		}

	}

}
