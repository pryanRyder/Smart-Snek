package Agent;

public class SnakeDQN extends DQN
{

	private boolean dead;
	private int steps;
	private int score;
	private int fruitX, fruitY;
	private int snakeX, snakeY;
	private int width, height;
	public char[][] Grid;
	
	double hitWall = -1;
	double ateApple = 1;
	double idle = 0;
	
	public SnakeDQN(int[] topology, double learningRate, double discountFactor, int width, int height)
	{
		
		super(topology, learningRate, discountFactor);
		this.width = width;
		this.height = height;
		Grid = new char[height][width];
		reset();
		
	}
	
	public SnakeDQN(int[] topology, double learningRate, double discountFactor, int width, int height, double hitWall, double ateApple, double idle)
	{
		super(topology, learningRate, discountFactor);
		
		this.idle = idle;
		this.ateApple = ateApple;
		this.hitWall = hitWall;
		
		this.width = width;
		this.height = height;
		Grid = new char[height][width];
		reset();
		
	}

	public void UpdateGrid()
	{
		for(int i = 0; i < Grid.length; i++)
		{
			for( int j = 0; j < Grid[0].length; j++)
			{
				if(i == snakeY && j == snakeX)
					Grid[i][j] = 'O';
				else if(i == fruitY && j == fruitX)
					Grid[i][j] = 'f';
				else
					Grid[i][j] = ' ';
			}
		}
	}
	
	public void reset()
	{
		snakeX = (int) (Math.random() * width);
		snakeY = (int) (Math.random() * height);
		
		do
		{
			fruitX = (int) (Math.random() * width);
			fruitY = (int) (Math.random() * height);
		}
		while(fruitX != snakeX && fruitY != snakeY);
		
		score = 0;
		steps = 0;
		dead = false;
		
		UpdateGrid();
	}
	
	@Override
	protected double[] getState()
	{
		return new double[] {Math.signum(fruitX - snakeX), Math.signum(fruitY - snakeY)};
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
		
		
		
		// dead if out of bounds
		if(snakeX < 0 || snakeY < 0 || snakeX >= width || snakeY >= height)
		{
			dead = true;
			return hitWall;
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
			
			return ateApple;
		}
		
		return idle;
		
		// punish otherwise
//		return -0.1;
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

}