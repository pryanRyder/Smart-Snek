package Agent;

import java.util.Random;

import GamePaneHelper.GamePaneSetsGets;
import Panes.GamePane;
import Snake.CurrentDirection;
import Snake.Snake;

/*
 * 
 * 
 * Danny, I noticed that the snake goes off screen when it is going directly away from the objective.
 * 
 * And I found that the objective can spawn in the snake.
 * 
 * I put a letter every time you assign a direction to help you find out which assignment is wrong.
 * 
 * 
 * 
 * EX:
 * -----------------------------|
 * |							|
 * |			----|			|			<- This will crash.
 * |				|			|
 * |	[]			|---------> |
 * |							|
 * |							|
 * |----------------------------|
 * 
 * 
 * Watch the snake a few times and you will see what I mean.
 * 
 * 
 */



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
					System.out.println("A");
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
					System.out.println("B");
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
				System.out.println("C");
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
					direction = CurrentDirection.RIGHT; //Original: RIGHT
				System.out.println("D");
				}
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
		
		else if(snake.Positions.get(0)[0] == GamePaneSetsGets.getRecsCol()-1 && snake.getDirection() == CurrentDirection.RIGHT)
		{
			if(snake.Positions.get(0)[1] == 0)
			{
				direction = CurrentDirection.DOWN;
				System.out.println("E");
			}
			else if(snake.Positions.get(0)[1] == GamePaneSetsGets.getRecsRow()-1)
			{
				direction = CurrentDirection.UP;
				System.out.println("F");
			}
			else
			{
			
				if(snake.objectiveItem[1] > snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.DOWN;
					System.out.println("G");
				}
				else if(snake.objectiveItem[1] < snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.UP;
					System.out.println("H");
				}
				
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.UP;
						System.out.println("I");
							break;
						case 2: direction = CurrentDirection.DOWN;
						System.out.println("J");
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
				System.out.println("K");
			}
			else if(snake.Positions.get(0)[1] == GamePaneSetsGets.getRecsRow()-1)
			{
				direction = CurrentDirection.UP;
				System.out.println("L");
			}
			else
			{
				if(snake.objectiveItem[1] > snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.DOWN;
					System.out.println("M");
				}
				else if(snake.objectiveItem[1] < snake.Positions.get(0)[1])
				{
					direction = CurrentDirection.UP;
					System.out.println("N");
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.UP;
						System.out.println("O");
							break;
						case 2: direction = CurrentDirection.DOWN;
						System.out.println("P");
							break;
					}
				}	
			}
		}
		else if(snake.Positions.get(0)[1] == GamePaneSetsGets.getRecsRow()-1 && snake.getDirection() == CurrentDirection.DOWN)
		{
			if(snake.Positions.get(0)[0] == GamePaneSetsGets.getRecsCol()-1)
			{
				direction = CurrentDirection.LEFT;
				System.out.println("Q");
			}
			else if(snake.Positions.get(0)[0] == 0)
			{
				direction = CurrentDirection.RIGHT;
				System.out.println("R");
			}
			else
			{
				if(snake.objectiveItem[0] > snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.RIGHT;
					System.out.println("S");
				}
				else if(snake.objectiveItem[0] < snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.LEFT;
					System.out.println("T");
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.LEFT;
						System.out.println("U");
							break;
						case 2: direction = CurrentDirection.RIGHT;
						System.out.println("V");
							break;
					}
				}					
		}
			}
		else if(snake.Positions.get(0)[1] == 0 && snake.getDirection() == CurrentDirection.UP)
		{
			if(snake.Positions.get(0)[0] == GamePaneSetsGets.getRecsCol()-1)
			{
				direction = CurrentDirection.LEFT;
				System.out.println("W");
			}
			else if(snake.Positions.get(0)[0] == 0)
			{
				direction = CurrentDirection.RIGHT;
				System.out.println("X");
			}
			else
			{
				if(snake.objectiveItem[0] > snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.RIGHT;
					System.out.println("Y");
				}
				else if(snake.objectiveItem[0] < snake.Positions.get(0)[0])
				{
					direction = CurrentDirection.LEFT;
					System.out.println("Z");
				}
				else
				{
					int maybe = (Math.random() <= 0.5) ? 1 : 2;
					switch(maybe)
					{
						case 1: direction = CurrentDirection.LEFT;
						System.out.println("AA");
							break;
						case 2: direction = CurrentDirection.RIGHT;
						System.out.println("AB");
							break;
					}
				}	
			}
		}
		/*
		for(int i = 0; i < snake.Positions.size(); i++)
		{
			if(snake.Positions.get(0)[1] == snake.Positions.get(i)[1] && snake.Positions.get(0)[0] == snake.Positions.get(i)[0]+1 && direction == CurrentDirection.RIGHT)
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
			else if(snake.Positions.get(0)[1] == snake.Positions.get(i)[1] && snake.Positions.get(0)[0] == snake.Positions.get(i)[0]-1 && direction == CurrentDirection.LEFT)
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
			else if(snake.Positions.get(0)[1] == snake.Positions.get(i)[1]+1 && snake.Positions.get(0)[0] == snake.Positions.get(i)[0] && direction == CurrentDirection.UP)
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
			else if(snake.Positions.get(0)[1] == snake.Positions.get(i)[1]-1 && snake.Positions.get(0)[0] == snake.Positions.get(i)[0] && direction == CurrentDirection.DOWN)
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

		}*/
			
			if(DecidedDirection == CurrentDirection.UP && direction == CurrentDirection.DOWN)
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.LEFT;
					System.out.println("AC");
						break;
					case 2: direction = CurrentDirection.RIGHT;
					System.out.println("AD");
						break;
				}
			}
			else if(DecidedDirection == CurrentDirection.DOWN && direction == CurrentDirection.UP)
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.LEFT;
					System.out.println("AE");
						break;
					case 2: direction = CurrentDirection.RIGHT;
					System.out.println("AF");
						break;
				}
			}
			else if(DecidedDirection == CurrentDirection.LEFT && direction == CurrentDirection.RIGHT)
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.DOWN;
					System.out.println("AG");
						break;
					case 2: direction = CurrentDirection.UP;
					System.out.println("AH");
						break;
				}
			}
			else if(DecidedDirection == CurrentDirection.RIGHT && direction == CurrentDirection.LEFT)
			{
				int maybe = (Math.random() <= 0.5) ? 1 : 2;
				switch(maybe)
				{
					case 1: direction = CurrentDirection.DOWN;
					System.out.println("AI");
						break;
					case 2: direction = CurrentDirection.UP;
					System.out.println("AJ");
						break;
				}
			}
			DecidedDirection = direction;
	}
	
	public CurrentDirection getDecidedDecidedDirection()
	{
		return DecidedDirection;
	}
	
}
