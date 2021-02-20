/**Toonie class:
	 * This is an abstract class that extends the Coin class and inherits all its state and behaviors
	 */
public class Toonie extends Coin{		// extends the Coin class since an abstract class cannot be instantiated

	@Override
	public double getValue() {			//inherited method/behavior from the abstract Coin class
		return 2.0;						// returns the value of a toonie
		
	}
	// end getValue method

}// end Toonie class
