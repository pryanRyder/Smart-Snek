package Agent;

import java.util.Arrays;
import DQN.NeuralNetwork;
import Snake.Snake;

public class Agent
{
	public static void main(String[] args)
	{
		final int[] topology = {4, 30, 4};
		final Snake dqn = new Snake(topology, 0.001, 0.995, 10, 10);
		dqn.setEpsilonMin(0.001);
		
		NeuralNetwork loadedNet = NeuralNetwork.loadNetwork("snake.nn");
		if(loadedNet != null)
		{
			System.out.println("Loaded network!");
			dqn.setNetwork(loadedNet);
			
			for(int round = 0; round < 100; round++)
			{
				double averageScore = 0;
				int maxScore = 0;
				for(int gameIndex = 0; gameIndex < 5000; gameIndex++)
				{
					dqn.reset();
					
					while(!dqn.isDone())
					{
						dqn.step();
					}
					
					averageScore += dqn.getScore();
					
					if(dqn.getScore() > maxScore)
					{
						maxScore = dqn.getScore();
					}
				}
				
				averageScore /= 1000.0;
				System.out.println(round + "," + averageScore + "," + maxScore);
			}
			
			
			NeuralNetwork.saveNetwork(dqn.getNetwork(), "snake.nn");
			
			dqn.setNetwork(loadedNet);
			dqn.getScore();
			dqn.reset();
			
			while(!dqn.isDead())
			{
				dqn.step();
				System.out.println(dqn.toString()+"\n");
			}
		}
		else
		{
		
		System.out.println("round,avgScore,maxScore");
		for(int round = 0; round < 100; round++)
		{
			double averageScore = 0;
			int maxScore = 0;
			for(int gameIndex = 0; gameIndex < 5000; gameIndex++)
			{
				dqn.reset();
				
				while(!dqn.isDone())
				{
					dqn.step();
				}
				
				averageScore += dqn.getScore();
				
				if(dqn.getScore() > maxScore)
				{
					maxScore = dqn.getScore();
				}
			}
			
			averageScore /= 1000.0;
			System.out.println(round + "," + averageScore + "," + maxScore);
		}
		}
		
		NeuralNetwork.saveNetwork(dqn.getNetwork(), "snake.nn");
	}
}

// The game is simply: u are a pixel and u must go to another pixel (fruit)
// if u go out of bounds, u die
// if u reach the fruit, u are awarded
// the fruit will respawn in another spot (thats how u get score)
// the state is simply 4 values, the snake & fruits position
