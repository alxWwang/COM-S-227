package project3;

public class Basketball
{
	
	
	private boolean isInflated;
	private double diameter;
	
	
	  
  public Basketball(double givenDiameter)
  {
	isInflated = false;
	diameter = givenDiameter;
  }

  public boolean isDribbleable()
  {
    return isInflated;
  }

  public double getDiameter()
  {
    return diameter;
  }

  public double getCircumference()
  {
    return Math.PI*diameter;
  }

  public void inflate()
  {
	  isInflated = true;
  }
  
  
}