package Agent;

import java.util.ArrayList;
import java.util.List;

import DQN.NeuralNetwork;

public abstract class DQN
{
	public DQN(int[] topology, double learningRate, double discountFactor)
	{
		network = new NeuralNetwork(topology, learningRate, 0);
		this.learningRate = learningRate;
		this.discountFactor = discountFactor;
		epsilon = 1.0;
		epsilonMin = 0.05;
		epsilonDecay = 0.99999;
		memory = new ArrayList<>();
	}
	
	public double getLearningRate()
	{
		return learningRate;
	}

	public void setLearningRate(double learningRate)
	{
		this.learningRate = clamp(learningRate, 0, 1);
	}

	public double getDiscountFactor()
	{
		return discountFactor;
	}

	public void setDiscountFactor(double discountFactor)
	{
		this.discountFactor = clamp(discountFactor, 0, 1);
	}

	public double getEpsilon()
	{
		return epsilon;
	}

	public void setEpsilon(double epsilon)
	{
		this.epsilon = clamp(epsilon, 0, 1);
	}

	public double getEpsilonMin()
	{
		return epsilonMin;
	}

	public void setEpsilonMin(double epsilonMin)
	{
		this.epsilonMin = clamp(epsilonMin, 0, 1);
	}

	public double getEpsilonDecay()
	{
		return epsilonDecay;
	}

	public void setEpsilonDecay(double epsilonDecay)
	{
		this.epsilonDecay = clamp(epsilonDecay, 0, 1);
	}

	public NeuralNetwork getNetwork()
	{
		return network;
	}

	public void setNetwork(NeuralNetwork network)
	{
		if(network != null)
		{
			this.network = network;
		}
	}

	public List<Experience> getMemory()
	{
		return memory;
	}
	
	protected abstract double[] getState();
	
	protected abstract boolean isDone();
	
	protected abstract double executeActionAndGetReward(int actionIndex); // returns reward too
	
	public void step()
	{
		double[] state = getState();
		double[] qValues = network.predict(state);
		int actionIndex = getMaxIndex(qValues);
		
		if(Math.random() < epsilon)
		{
			actionIndex = (int) (Math.random() * network.getOutputSize());
		}
		
		double reward = executeActionAndGetReward(actionIndex);
		double[] statePrime = getState();
		
		Experience exp = new Experience(state, statePrime, actionIndex, reward, isDone());
		memory.add(exp);
		learn(exp);
		
		if(epsilon > epsilonMin)
		{
			epsilon *= epsilonDecay;
		}
		
		replay();
	}
	
	private void replay()
	{
		if(memory.size() >= 10000)
		{
			for(int i = 0; i < 50; i++)
			{
				Experience exp = memory.remove((int)(Math.random() * memory.size()));
				learn(exp);
			}
		}
	}
	
	private void learn(Experience exp)
	{
		double qTarget = exp.getReward();
		if(!exp.isDone())
		{
			double[] nextStateQValues = network.predict(exp.getNextState());
			double maxQValue = nextStateQValues[getMaxIndex(nextStateQValues)];
			qTarget += discountFactor * maxQValue;
		}
		double[] qValues = network.predict(exp.getState());
		qValues[exp.getActionIndex()] = (1 - learningRate) * qValues[exp.getActionIndex()] + learningRate * qTarget;
		network.train(exp.getState(), qValues, false);
	}
	
	private int getMaxIndex(double[] outputs)
	{
		double highestQvalue = Double.MIN_VALUE;
		int actionIndex = 0;
		for(int i = 0; i < outputs.length; i++)
		{
			if(outputs[i] > highestQvalue)
			{
				highestQvalue = outputs[i];
				actionIndex = i;
			}
		}
		
		return actionIndex;
	}
	
	private double clamp(double value, double min, double max)
	{
		if(value >= max)
			return max;
		if(value <= min)
			return min;
		return value;
	}
	
	private double learningRate;
	private double discountFactor;
	private double epsilon;
	private double epsilonMin;
	private double epsilonDecay;
	private NeuralNetwork network;
	private final List<Experience> memory;
	
	class Experience
	{
		private final double[] state;
		private final double[] nextState;
		private final int actionIndex;
		private final double reward;
		private final boolean done;
		
		public Experience(double[] state, double[] nextState, int actionIndex, double reward, boolean done)
		{
			this.state = state;
			this.nextState = nextState;
			this.actionIndex = actionIndex;
			this.reward = reward;
			this.done = done;
		}
		
		public double[] getState()
		{
			return state;
		}
		
		public double[] getNextState()
		{
			return nextState;
		}
		
		public int getActionIndex()
		{
			return actionIndex;
		}
		
		public double getReward()
		{
			return reward;
		}
		
		public boolean isDone()
		{
			return done;
		}


	}
}