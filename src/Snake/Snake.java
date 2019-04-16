package Snake;

import java.util.Arrays;

import Agent.DQN;


public class Snake extends DQN
{

	private boolean dead;
	private int steps;
	private int score;
	private int fruitX, fruitY;
	private int snakeX, snakeY;
	private int width, height;
	public char[][] Grid;
	
	private double idle = -0.1;
	private double hitwall = -1;
	private double hitSelf = -1;
	private double ateApple = 5;
	
	private double distanceFromFruit;
	
	public Snake(int[] topology, double learningRate, double discountFactor, int width, int height, double hitwall, double ateApple, double idle)
	{
		super(topology, learningRate, discountFactor);
		this.width = width;
		this.height = height;
		this.Grid = new char[width][height];
		this.ateApple = ateApple;
		this.hitwall = hitwall;
		this.idle = idle;
		reset();
		
	}
	
	public Snake(int[] topology, double learningRate, double discountFactor, int width, int height)
	{
		super(topology, learningRate, discountFactor);
		this.width = width;
		this.height = height;
		this.Grid = new char[width][height];
		reset();
	}
	
	public String toString()
	{
		String x = "";
		for(int i = 0; i < Grid.length; i++)
		{
			x += Arrays.toString(Grid[i]) + "\n";
		}
		
		return x;
	}
	
	public void updateDistanceFromFruit()
	{
		distanceFromFruit = Math.sqrt((snakeX-fruitX)*(snakeX-fruitX) + (snakeY -fruitY)*(snakeY -fruitY));
	}
	
	public void updateGrid()
	{
		char[][] x = new char[width][height];
		
		for(int i = 0; i < x.length; i++)
		{
			for(int j = 0; j < x[0].length; j++)
			{
				x[i][j] = ' ';
			}
		}
		
		try {
		x[fruitY][fruitX] = 'f';
		x[snakeY][snakeX] = 'O';
		}
		catch(Exception e)
		{
			
		}
		
		Grid = x;
	}

	public void reset()
	{
		snakeX = (int) (Math.random() * width);
		snakeY = (int) (Math.random() * height);
		
		updateDistanceFromFruit();
		
		do
		{
			fruitX = (int) (Math.random() * width);
			fruitY = (int) (Math.random() * height);
		}
		while(fruitX != snakeX && fruitY != snakeY);
		
		score = 0;
		steps = 0;
		dead = false;
	}
	
	@Override
	protected double[] getState()
	{
		return new double[] {snakeX, snakeY, fruitX, fruitY, distanceFromFruit};
	}

	@Override
	public boolean isDone()
	{
		return steps >= 500 || dead;
	}

	@Override
	protected double executeActionAndGetReward(int actionIndex)
	{
		if(actionIndex == 0) // go up
		{
			snakeY++;
		}
		else if(actionIndex == 1) // go down
		{
			snakeY--;
		}
		else if(actionIndex == 2) // go left
		{
			snakeX--;
		}
		else if(actionIndex == 3) // go right
		{
			snakeX++;
		}
		
		steps++;
		
		updateDistanceFromFruit();
		
		
		
		// dead if out of bounds
		if(snakeX < 0 || snakeY < 0 || snakeX >= width || snakeY >= height)
		{
			dead = true;
			return getHitwall();
		}
		
		// award if on fruit
		if(snakeX == fruitX && snakeY == fruitY)
		{
			score++;
			
			do
			{
				fruitX = (int) (Math.random() * width);
				fruitY = (int) (Math.random() * height);
			}
			while(fruitX != snakeX && fruitY != snakeY);
			
			return getAteApple();
		} 
		
		// punish otherwise
		return -1*distanceFromFruit;
	}
	
	public boolean isDead()
	{
		return dead;
	}

	public int getSteps()
	{
		return steps;
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

	public int getSnakeX()
	{
		return snakeX;
	}

	public int getSnakeY()
	{
		return snakeY;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public double getHitwall() {
		return hitwall;
	}

	public void setHitwall(double hitwall) {
		this.hitwall = hitwall;
	}

	public double getIdle() {
		return idle;
	}

	public void setIdle(double idle) {
		this.idle = idle;
	}

	public double getHitSelf() {
		return hitSelf;
	}

	public void setHitSelf(double hitSelf) {
		this.hitSelf = hitSelf;
	}

	public double getAteApple() {
		return ateApple;
	}

	public void setAteApple(double ateApple) {
		this.ateApple = ateApple;
	}


}