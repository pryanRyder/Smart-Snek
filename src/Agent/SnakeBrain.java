package Agent;

import java.util.Random;

import Snake.CurrentDirection;
import Snake.Snake;

public class SnakeBrain
{
	Snake snake;
	CurrentDirection DecidedDirection;
	//constructor
	public SnakeBrain(Snake snake)
	{
		this.snake = snake;
		System.out.println("hello?");
		DecidedDirection = snake.getDirection();
	}
	
	public void updateSnake(Snake snake)
	{
		snake = this.snake;
	}
	
	public void MakeDecision()
	{
		CurrentDirection direction = DecidedDirection;
		
		//check if the snake is above or below the objective boi move towards it
		
		if(snake.objectiveItem[0] == snake.Positions.get(0)[0])
		{
			if(snake.objectiveItem[1] < snake.Positions.get(0)[1])
			{
				boolean snakeBodyIsCloser = false;
				for(int i = 1 ; i < snake.Positions.size(); i++)
				{
					if(snake.Positions.get(i)[0] == snake.Positions.get(0)[0] && snake.Positions.get(i)[1] > snake.objectiveItem[1])
						snakeBodyIsCloser = true;
				}
				
				if(!snakeBodyIsCloser)
				{
					direction = CurrentDirection.UP;
				}
			}
			else if(snake.objectiveItem[1] > snake.Positions.get(0)[1])
			{
				boolean snakeBodyIsCloser = false;
				for(int i = 1 ; i < snake.Positions.size(); i++)
				{
					if(snake.Positions.get(i)[0] == snake.Positions.get(0)[0] && snake.Positions.get(i)[1] < snake.objectiveItem[1])
						snakeBodyIsCloser = true;
				}
				
				if(!snakeBodyIsCloser)
				{
					direction = CurrentDirection.DOWN;
				}			
				
			}

		}
		
		else if(snake.objectiveItem[1] == snake.Positions.get(0)[1])
		{
			if(snake.objectiveItem[0] < snake.Positions.get(0)[0])
			{
				boolean snakeBodyIsCloser = false;
				for(int i = 1; i < snake.Positions.size(); i++)
				{
					if(snake.Positions.get(i)[1] == snake.Positions.get(0)[1] && snake.Positions.get(i)[0] > snake.objectiveItem[0])
						snakeBodyIsCloser = true;
				}
				if(!snakeBodyIsCloser)
					direction = CurrentDirection.LEFT;
			}
			else if(snake.objectiveItem[0] > snake.Positions.get(0)[0])
			{
				
				boolean snakeBodyIsCloser = false;
				for(int i = 1; i < snake.Positions.size(); i++)
				{
					if(snake.Positions.get(i)[1] == snake.Positions.get(0)[1] && snake.Positions.get(i)[0] < snake.objectiveItem[0])
						snakeBodyIsCloser = true;
				}
				if(!snakeBodyIsCloser)
					direction = CurrentDirection.RIGHT;			}
		}		

			
		/*
		for(int i = 3; i < snake.Positions.size(); i++)
		{
			if(snake.Positions.get(i)[0] > 0 && (snake.Positions.get(0)[0] == snake.Positions.get(i)[0]-1 && snake.getDirection() == CurrentDirection.RIGHT))
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.UP;
						break;
					case 2: direction = CurrentDirection.DOWN;
						break;
				}
			}
			
			else if(snake.Positions.get(i)[0] > 0 && (snake.Positions.get(0)[0] == snake.Positions.get(i)[0]+1 && snake.getDirection() == CurrentDirection.LEFT))
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.UP;
						break;
					case 2: direction = CurrentDirection.DOWN;
						break;
				}
			}
		}*/
		
		else if(snake.Positions.get(0)[0] == 24 && snake.getDirection() == CurrentDirection.RIGHT)
		{
			if(snake.Positions.get(0)[1] == 0)
			{
				direction = CurrentDirection.DOWN;
			}
			else if(snake.Positions.get(0)[1] == 14)
			{
				direction = CurrentDirection.UP;
			}
			else
			{
			
				if(snake.objectiveItem[1] > snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.DOWN;
				}
				else if(snake.objectiveItem[1] < snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.UP;
				}
				
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.UP;
							break;
						case 2: direction = CurrentDirection.DOWN;
							break;
					}
				}
				
			}
		}
		else if(snake.Positions.get(0)[0] == 0 && snake.getDirection() == CurrentDirection.LEFT)
		{
			if(snake.Positions.get(0)[1] == 0)
			{
				direction = CurrentDirection.DOWN;
			}
			else if(snake.Positions.get(0)[1] == 14)
			{
				direction = CurrentDirection.UP;
			}
			else
			{
				if(snake.objectiveItem[1] > snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.DOWN;
				}
				else if(snake.objectiveItem[1] < snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.UP;
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.UP;
							break;
						case 2: direction = CurrentDirection.DOWN;
							break;
					}
				}	
			}
		}
		else if(snake.Positions.get(0)[1] == 14 && snake.getDirection() == CurrentDirection.DOWN)
		{
			if(snake.Positions.get(0)[0] == 24)
			{
				direction = CurrentDirection.LEFT;
			}
			else if(snake.Positions.get(0)[0] == 0)
			{
				direction = CurrentDirection.RIGHT;
			}
			else
			{
				if(snake.objectiveItem[0] > snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.RIGHT;
				}
				else if(snake.objectiveItem[0] < snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.LEFT;
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.LEFT;
							break;
						case 2: direction = CurrentDirection.RIGHT;
							break;
					}
				}					
		}
			}
		else if(snake.Positions.get(0)[1] == 0 && snake.getDirection() == CurrentDirection.UP)
		{
			if(snake.Positions.get(0)[0] == 24)
			{
				direction = CurrentDirection.LEFT;
			}
			else if(snake.Positions.get(0)[0] == 0)
			{
				direction = CurrentDirection.RIGHT;
			}
			else
			{
				if(snake.objectiveItem[0] > snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.RIGHT;
				}
				else if(snake.objectiveItem[0] < snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.LEFT;
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.LEFT;
							break;
						case 2: direction = CurrentDirection.RIGHT;
							break;
					}
				}	
			}
		}
		
			
			DecidedDirection = direction;
	}
	
	public CurrentDirection getDecidedDecidedDirection()
	{
		return DecidedDirection;
	}
	
}
