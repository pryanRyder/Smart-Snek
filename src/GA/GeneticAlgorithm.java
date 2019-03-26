package GA;

import Agent.Agent;

/**
 * @author Danny
 * @version 1.0
 */
public class GeneticAlgorithm extends GenericGeneticAlgorithm {

	private int G;

	public GeneticAlgorithm(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param populationSize integer
	 * @param mutationRate   double
	 */
	public void GeneticAlgorithm(int populationSize, double mutationRate){

	}

	
	public Agent ChromosomeToAgent(String chromosome){
		return null;
	}

	
	public String Crossover(String parent1, String parent2){
		return "";
	}

	public void generatePopulation(){

	}

	public String getBestChromosome(){
		return "";
	}

	
	public Agent getFitness(String chromosome){
		return null;
	}

	
	public void Mutate(String chromosome){

	}

	public String toString(){
		return "";
	}
}//end GeneticAlgorithm