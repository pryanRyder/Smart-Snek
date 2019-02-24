package Snake;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public class Snake {
	
	
	
	private CurrentDirection Direction;
	public int[] objectiveItem = new int[2];
	public ArrayList<int[]> Positions;
	public int score;
	public CurrentDirection m_CurrentDirection;

	public void Snake() {
		int[] x = {2,2};
		Positions.add(x);	
	}

	public void finalize() throws Throwable {

	}
	public void ateObjectiveItem(){

	}

	public void changeDirection(CurrentDirection direction){

	}

	public boolean checkIfDead(){
		return false;
	}

	public void didEatObjectiveItem(){

	}

	public void move(){

	}

	public void randomObjectiveItem(){
			Random spot = new Random();
			
			int row = spot.nextInt(25);
			int col = spot.nextInt(15);
			
			objectiveItem[0] = row;
			objectiveItem[1] = col;
	}

	public void updatePosition(int x, int y){

	}
}//end Snake