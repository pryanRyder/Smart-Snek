package Snake;

import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */


public class Snake {
	
	
	private CurrentDirection Direction;
	public int[] objectiveItem = new int[2];
	public ArrayList<int[]> Positions = new ArrayList<int[]>();
	public int score;
	public CurrentDirection m_CurrentDirection;

	
	/**
	 * Constructs a new Snake instance
	 */
	public Snake()
	{
		int[] x = {2,2};
		Positions.add(x);
		m_CurrentDirection = CurrentDirection.RIGHT;
		randomObjectiveItem();
	}

	public void finalize() throws Throwable 
	{

	}
	/**
	 * adds to the score which counts how many objectives the snake has eaten 
	 */
	public void ateObjectiveItem(){
		if(Positions.get(0)[0] == objectiveItem[0] && Positions.get(0)[1] == objectiveItem[1])
		{
			score++;
			randomObjectiveItem();
			
			int[] tempPosition = new int[2];

				tempPosition[0] = Positions.get(0)[0];
				tempPosition[1] = Positions.get(0)[1];

			Positions.add(tempPosition);
		}
	}

	
	/**
	 * @param direction 
	 * changes the current direction of the snake depending on the input by the keyboard
	 */
	public void changeDirection(CurrentDirection direction){
		m_CurrentDirection = direction;
	}

	/**
	 * @return isDead
	 * checks if the snake ran into a wall or over itself and returning the status of if its dead 
	 */
	public boolean checkIfDead(){
		boolean isDead = false;
		for(int i = 1; i < Positions.size(); i++)
		{
				if((Positions.get(0)[0] == Positions.get(i)[0] && Positions.get(0)[1] == Positions.get(i)[1]) && 0 != i)
				{
					isDead = true;
					System.out.println("head " + Positions.get(0)[0] + " , " + Positions.get(0)[1]);
					System.out.println(i + " "  + Positions.get(i)[0] + " , " + Positions.get(i)[1]);
				}
				
		}
		return isDead;	}

	/**
	 * @return boolean
	 * checks if snake ate an objective item and if the answer is yes then add a unit length to the snake, if not then do nothing
	 */
	public boolean didEatObjectiveItem(){
		if(Positions.get(0)[0] == objectiveItem[0] && Positions.get(0)[1] == objectiveItem[1])
		{
			return true;
		}
		return false;
	}

	/**
	 * the snake starts out going right and depending on what the keyboard input is it will chnage its direction
	 * its either right, left, up, or down
	 */
	public void move(){
		//System.out.println("X: " + Positions.get(0)[0] + " Y: " + Positions.get(1)[1]);
		
		for(int i = Positions.size()-1; i > 0; i--)
		{
			int[] temp = new int[2];
			temp[0] = Positions.get(i-1)[0];
			temp[1] = Positions.get(i-1)[1];
			
			Positions.set(i, temp);
			
		
		}
		
		if(m_CurrentDirection == CurrentDirection.RIGHT)
			updatePosition(1, 0);//add 1 to x direction
		else if(m_CurrentDirection == CurrentDirection.LEFT)
			updatePosition(-1, 0);//subtract 1 to x direction
		else if(m_CurrentDirection == CurrentDirection.UP)
			updatePosition(0, -1);//add 1 to y direction
		else if(m_CurrentDirection == CurrentDirection.DOWN)
			updatePosition(0, 1);//subtract 1 to y direction
	}

	/**
	 * generates a random objective item that is not within the snakes unit length 
	 */
	public void randomObjectiveItem(){
			Random spot = new Random();
			
			int row = spot.nextInt(25);
			int col = spot.nextInt(15);
			
			for(int i = 0; i < Positions.size(); i++)
			{
				if(Positions.get(i)[0] == row && Positions.get(i)[1] == col)
				{
					row = spot.nextInt(25);
					col = spot.nextInt(15);
				}
			}
			
			objectiveItem[0] = row;
			objectiveItem[1] = col;
	}

	/**
	 * @param x rows
	 * @param y columns
	 * updates the positions of the snake (how long it is) 
	 */
	public void updatePosition(int x, int y)
	{
		Positions.get(0)[0] += x;
		Positions.get(0)[1] += y;
	}
}//end Snake