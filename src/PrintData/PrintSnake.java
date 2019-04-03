package PrintData;

import Snake.Snake;

public class PrintSnake {

	public static void printSnake(Snake snake) {

		int i = 0;
		for (i = 0; i < snake.Positions.size(); i++) {

			System.out.print("[" + snake.Positions.get(i)[1] + "," + snake.Positions.get(i)[0] + "]");
		}
		System.out.println("");
	}
}
