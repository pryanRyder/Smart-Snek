package Agent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Snake.CurrentDirection;

public class SnakeBrain
{
	CurrentDirection DecidedDirection;
	
	SnakeDQN snek = new SnakeDQN(0, 0, 0, 0);
	
	private int score, fruitX, fruitY;
	public double[][] Grid;
	public ArrayList<int[]> Positions = new ArrayList<int[]>();
	public double[] headNeighbors = {0, 0, 0, 0};
	boolean dead;

	// Will move the snake based off hard inputs such as objective item location, snake head location, & snake body location. 
	public SnakeBrain()
	{
		Grid = new double[10][10];
		reset();
	}
	
	public void UpdateGrid()
	{
		double[] tmp = {0, 0, 0, 0};
		headNeighbors = tmp;
	
		for(int i = 0; i < Grid.length; i++)
		{
			for( int j = 0; j < Grid[0].length; j++)
			{
				if(i == Positions.get(0)[0] && j == Positions.get(0)[1])
					Grid[i][j] = 1;
				else if(i == fruitY && j == fruitX)
					Grid[i][j] = .5;
				else
					Grid[i][j] = 0;
			}
		}
	}
	
	
	public void MakeDecision()
	{
		for(int i = Positions.size()-1; i > 0; i--)
		{
			int[] temp = new int[2];
			temp[0] = Positions.get(i-1)[0];
			temp[1] = Positions.get(i-1)[1];

			Positions.set(i, temp);
		}
		
		for(int i = 0; i < Grid.length; i++)
		{ 
			Positions.get(0)[1]++;
			
			UpdateGrid();
		}
		
	}
	
	public void updateSnake()
	{
		
		
		
	}
	
	public void reset() 
	{
		{
			double[] tmp = {0, 0, 0, 0};
			headNeighbors = tmp;
			
			Positions = new ArrayList<int[]>();
			
			Positions.add(new int[2]);
			
			
			Positions.get(0)[0] = 0;
			Positions.get(0)[1] = 0;
			
			do
			{
				fruitX = (int) (Math.random() * 10);
				fruitY = (int) (Math.random() * 10);
			}
			while(fruitX != Positions.get(0)[0] && fruitY != Positions.get(0)[1]);
			
			score = 0;
			dead = false;
			
			UpdateGrid();
		}
		
	}

	public boolean isDead() {
		
		return dead;
	}

	public int getScore()
	{
		return score;
	}

	public int getFruitX()
	{
		return fruitX;
	}

	public int getFruitY()
	{
		return fruitY;
	}

	
	

}
