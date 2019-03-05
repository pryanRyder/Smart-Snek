package GA;

import java.util.Random;

import Agent.Agent;

/**
 * @author Danny
 * @version 1.0
 * @created 17-Feb-2019 5:39:59 PM
 */
public abstract class GenericGeneticAlgorithm {

	private int generation;
	private double mutationRate;
	private String[] population;
	private int populationSize;
	private Random rand;

	/**
	 * creates a new instance of GenericGeneticAlgorithm 
	 */
	public GenericGeneticAlgorithm(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param populationSize
	 * @param MutationRate
	 */
	public void GenericGeneticAlgorithm(int populationSize, double MutationRate){

	}

	/**
	 * 
	 * @param parent1
	 * @param parent2
	 */
	public String Crossover(String parent1, String parent2){
		return "";
	}

	/**
	 * 
	 */
	public void Evolve(){

	}

	/**
	 * 
	 */
	public void generatePopulation(){

	}

	/**
	 * 
	 * @param chromosome
	 */
	/**
	 * @param chromosome
	 * @return
	 */
	public Agent getFitness(String chromosome){
		return null;
	}

	/**
	 * @return
	 */
	public int getGeneration(){
		return 0;
	}

	public double getMutationRate(){
		return 0;
	}

	public int getPopulationSize(){
		return 0;
	}

	public String[] getPopulation(){
		return null;
	}

	/**
	 * 
	 * @param chromosome
	 */
	public void Mutate(String chromosome){

	}

	public String Selection(){
		return "";
	}

	/**
	 * 
	 * @param mutationRate
	 */
	public void setMutationRate(double mutationRate){

	}

	/**
	 * 
	 * @param population
	 */
	public void setPopulation(String[] population){

	}

	public String toString(){
		return "";
	}
}//end GenericGeneticAlgorithm