package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel1
{
  // TODO - add instance variables as needed
  private int population;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel1()
  {
    // TODO
	  population=0;
	  
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
	  
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
    // TODO
	  population += 1;
	  population = population%5;
	  

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  population = 0;
  }
}