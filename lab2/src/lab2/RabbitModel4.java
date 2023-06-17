package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
  private int population;
  private int lastYear;
  private int yearBefore;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    // TODO
	  population=1;
	  
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
	  yearBefore = lastYear;
	  lastYear = population;
	  
	  
			  
	  population = lastYear + yearBefore;
	  
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  population = 1;
  }
}