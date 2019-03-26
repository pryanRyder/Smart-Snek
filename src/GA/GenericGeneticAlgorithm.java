package GA;

import java.util.Random;

import Agent.Agent;

/**
 * @author Danny
 * @version 1.0
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
	 * @param populationSize integer
	 * @param MutationRate   double
	 */
	public void GenericGeneticAlgorithm(int populationSize, double MutationRate){

	}

	
	public String Crossover(String parent1, String parent2){
		return "";
	}


	public void Evolve(){

	}


	public void generatePopulation(){

	}

	
	public Agent getFitness(String chromosome){
		return null;
	}

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

	
	public void Mutate(String chromosome){

	}

	public String Selection(){
		return "";
	}

	
	public void setMutationRate(double mutationRate){

	}

	
	public void setPopulation(String[] population){

	}

	public String toString(){
		return "";
	}
}//end GenericGeneticAlgorithm