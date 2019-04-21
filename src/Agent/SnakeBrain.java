package Agent;

import java.util.Random;

import Snake.CurrentDirection;

public class SnakeBrain
{
	CurrentDirection DecidedDirection;
	
	SnakeDQN snek = new SnakeDQN(0, 0, 0, 0);
	
	
	
	// Will move the snake based off hard inputs such as objective item location, snake head location, & snake body location. 
	public SnakeBrain()
	{
		snek.reset();
		
		
		
	}
	
	// If snake dies or gets objective item, update body size. (Either +1 or reset to 1)
	public void updateSnake()
	{
		
		
		
	
	}
	
	// Series of if statements that decide the direction the head of the snake will move in. 
	public void MakeDecision()
	{
		
		
	}
	
/*	Shit I'll probably need. 
	
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

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
	
	
*/	
}
