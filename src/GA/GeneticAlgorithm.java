package GA;

import Agent.Agent;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
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
	 * @param populationSize
	 * @param mutationRate
	 */
	public void GeneticAlgorithm(int populationSize, double mutationRate){

	}

	/**
	 * 
	 * @param chromosome
	 */
	public Agent ChromosomeToAgent(String chromosome){
		return null;
	}

	/**
	 * 
	 * @param parent1
	 * @param parent2
	 */
	public String Crossover(String parent1, String parent2){
		return "";
	}

	public void generatePopulation(){

	}

	public String getBestChromosome(){
		return "";
	}

	/**
	 * 
	 * @param chromosome
	 */
	public Agent getFitness(String chromosome){
		return null;
	}

	/**
	 * 
	 * @param chromosome
	 */
	public void Mutate(String chromosome){

	}

	public String toString(){
		return "";
	}
}//end GeneticAlgorithm