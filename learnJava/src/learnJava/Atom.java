package learnJava;


/**
 * Class that models an atom containing protons, neutrons, and electrons.
 */
public class Atom
{
  // instance variables
  private int prot;
  private int neut;
  private int elec;
  
  public Atom( int givenProtons, int givenNeutrons, int givenElectrons) {
	  
        prot = givenProtons;
        neut = givenNeutrons;
        elec = givenElectrons;
  }
  
      public int getAtomicMass() {
  
         return prot + neut;
         
      }
      public int getAtomicCharge() {
  
         return prot - elec;
      }
      public void decay() {
	
  
         prot = prot - 2;
         neut = neut -2;
      }

     // constructor
     
     // methods
}
