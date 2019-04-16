package DQN;

public class XOR_Program
{
	public static void main(String[] args)
	{
		// Comment this after running it.
		xor_main_save();
		
		// Uncomment this after running it
//		xor_main_load();
	}
	
	public static void xor_main_load()
	{
		// Load Network
		NeuralNetwork network = NeuralNetwork.loadNetwork("network.txt");
		
		// Training Data
		double[][] inputs =
		{
			{0, 0},
			{0, 1},
			{1, 0},
			{1, 1}
		};
		
		// Predict
		for(int i = 0; i < 4; i++)
		{
			System.out.println("Prediction: " + (i+1));
			network.predict(inputs[i%4], true);
			System.out.println();
		}
	}
	
	public static void xor_main_save()
	{
		// Construct network
		int[] topology = {2, 3, 3, 1};
		NeuralNetwork network = new NeuralNetwork(topology, 0.2, 0.2);
		
		// Training Data
		double[][] inputs =
		{
			{0, 0},
			{0, 1},
			{1, 0},
			{1, 1}
		};
		
		double[][] outputs =
		{
			{0},
			{1},
			{1},
			{1}
		};
		
		// Train
		for(int i = 0; i < 100000; i++)
		{
			network.train(inputs[i%4], outputs[i%4], false);
		}
		
		// Predict
		for(int i = 0; i < 4; i++)
		{
			System.out.println("Prediction: " + (i+1));
			network.predict(inputs[i%4], true);
			System.out.println();
		}
		
		// Save network
		NeuralNetwork.saveNetwork(network, "network.txt");
	}
}
