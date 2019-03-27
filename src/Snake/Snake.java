package Snake;

import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import ErrorMessages.*;
import Panes.GamePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Danny
 * @version 1.0
 * 
 */


public class Snake {

	public int[] objectiveItem = new int[2];
	public ArrayList<int[]> Positions = new ArrayList<int[]>();
	public int score;
	public CurrentDirection m_CurrentDirection = CurrentDirection.RIGHT;
	private boolean justAte = false;

	/**
	 * Constructs a new Snake instance
	 */
	public Snake(Rectangle[][] recs)
	{
		int[] startingPos = {0,0};
		Positions.add(startingPos);
		randomObjectiveItem(GamePane.getRecsRow(), GamePane.getRecsCol(), recs);
	}

	public void finalize() throws Throwable
	{

	}
	
	/**
	 * @return interger score
	 *  adds to the score which counts how many objectives the snake has eaten
	 */
	public int ateObjectiveItem(Rectangle[][] recs){
		
		
		if(Positions.get(0)[0] == objectiveItem[0] && Positions.get(0)[1] == objectiveItem[1])
		{
			score++;

			recs[this.Positions.get(0)[1]][this.Positions.get(0)[0]].setFill(Color.WHITE);
			
			justAte = true;
			
			randomObjectiveItem(GamePane.getRecsRow(), GamePane.getRecsCol(), recs);
		}
		return score;
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
	 * the snake starts out going right and depending on what the keyboard input is it will change its direction
	 * its either right, left, up, or down
	 */
	public void move(Rectangle[][] recs){
		
		if(m_CurrentDirection == CurrentDirection.RIGHT) {
			updatePosition(1, 0, recs);//add 1 to x direction
		}
		else if(m_CurrentDirection == CurrentDirection.LEFT) {
			updatePosition(-1, 0, recs);//subtract 1 to x direction
		}
		else if(m_CurrentDirection == CurrentDirection.UP) {
			updatePosition(0, -1, recs);//add 1 to y direction
		}
		else if(m_CurrentDirection == CurrentDirection.DOWN) {
			updatePosition(0, 1, recs);//subtract 1 to y direction
		}
		
		justAte = false;
		
		
		//For testing...
		/*
		int i=0;
		for(i=0; i < this.Positions.size(); i++) {
			System.out.print("[" + this.Positions.get(i)[1] +"," +this.Positions.get(i)[0] + "]");
		}
		System.out.println("");
		*/
		
	}

	/**
	 * generates a random objective item that is not within the snakes unit length
	 */
	public void randomObjectiveItem(int rowSize, int colSize, Rectangle[][] recs){
			Random spot = new Random();

			int col = spot.nextInt(colSize);
			int row = spot.nextInt(rowSize);

			for(int i = 0; i < Positions.size(); i++)
			{
				if(Positions.get(i)[1] == row && Positions.get(i)[0] == col)
				{
					col = spot.nextInt(colSize);
					row = spot.nextInt(rowSize);
				}
			}

			objectiveItem[1] = row;
			objectiveItem[0] = col;
			
			
			if(justAte == true) {
				recs[objectiveItem[1]][objectiveItem[0]].setFill(Color.RED);
			}
			
	}

	/**
	 * @param x rows
	 * @param y columns
	 * updates the positions of the snake (how long it is)
	 */
	public void updatePosition(int x, int y, Rectangle[][] recs)
	{
		
		if(justAte == true) {
			int[] block = new int[2];
			block[0] = this.Positions.get(0)[0] + x;
			block[1] = this.Positions.get(0)[1] + y;
			
			if(block[0] < 0 || block[0] >= GamePane.getRecsCol() || block[1] < 0 || block[1] >= GamePane.getRecsRow()) {
				System.out.println("Out of bounds error!");
				System.exit(-1);
			}
			
			this.Positions.add(0, block);
			recs[this.Positions.get(0)[1]][this.Positions.get(0)[0]].setFill(Color.WHITE);
		}
		else if(justAte == false) {
			
			
			recs[this.Positions.get(this.Positions.size()-1)[1]][this.Positions.get(this.Positions.size()-1)[0]].setFill(Color.DARKCYAN);
			
			
			int[] block = new int[2];
			block[0] = this.Positions.get(0)[0] + x;
			block[1] = this.Positions.get(0)[1] + y;
			
			if(block[0] < 0 || block[0] >= GamePane.getRecsCol() || block[1] < 0 || block[1] >= GamePane.getRecsRow()) {
				System.out.println("Out of bounds error!");
				System.exit(-1);
			}
			
			this.Positions.add(0, block);
			this.Positions.remove(this.Positions.size()-1);
			
			
			
			
			recs[this.Positions.get(0)[1]][this.Positions.get(0)[0]].setFill(Color.WHITE);
			
		}
		
		//Positions.get(0)[0] += x;
		//Positions.get(0)[1] += y;
	}

	public CurrentDirection getDirection() {
		return m_CurrentDirection;
	}
	
	public void setDirection(CurrentDirection x) {
		m_CurrentDirection = x;
	}

}//end Snake
