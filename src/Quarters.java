	/**Quarters class:
	 * This is an abstract class that extends the Coin class and inherits all its state and behaviors
	 */
public class Quarters extends Coin{		// extends the Coin class since an abstract class cannot be instantiated


	@Override
	public double getValue() {			//inherited method/behavior from the abstract Coin class

		return 0.25;					// returns the value of a quarter
	}
	// end getValue method
	
}// end Quarters class
