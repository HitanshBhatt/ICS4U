import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class PiggyBank{		// start of class

	private double total;									// Variable to store the total value of the coins in the PiggyBank <type double>
	Nickel NickelObject = new Nickel();						//
	Dime DimeObject = new Dime();							//
	Quarters QuarterObject = new Quarters();				// Objects of specific coin classes
	Loonie LoonieObject = new Loonie();						//
	Toonie ToonieObject = new Toonie();						//
	private ArrayList<Coin> coins = new ArrayList<>();		// ArrayList to store coin objects <type Coin>

	/**constructor:
	 * This is the constructor for the PiggyBank class
	 *
	 * @param none
	 * @return none
	 */
	public PiggyBank()
	{

	}

	/**addNickel method:
	 * This is a modifier method that adds Nickels to an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to enter <type Coin>
	 * 		  newNumNickels - A variable that stores the number of nickels the user wants to add <type int>
	 * @return none
	 */
	public void addNickel(Coin coin, int newNumNickels)
	{
		for (int i = 0; i< newNumNickels; i++)
			coins.add(coin);
	}

	/**addDime method:
	 * This is a modifier method that adds Dimes to an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to enter <type Coin>
	 * 		  newNumDimes - A variable that stores the number of dimes the user wants to add <type int>
	 * @return none
	 */
	public void addDime(Coin coin, int newNumDimes)
	{
		for (int i = 0; i< newNumDimes; i++)
			coins.add(coin);
	}


	/**addQuarter method:
	 * This is a modifier method that adds quarters to an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to enter <type Coin>
	 * 		  newNumQuarters - A variable that stores the number of quarters the user wants to add <type int>
	 * @return none
	 */
	public void addQuarter(Coin coin, int newNumQuarters)
	{
		for (int i = 0; i< newNumQuarters; i++)
			coins.add(coin);
	}

	/**addLoonie method:
	 * This is a modifier method that adds Loonies to an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to enter <type Coin>
	 * 		  newNumLoonies - A variable that stores the number of loonies the user wants to add <type int>
	 * @return none
	 */
	public void addLoonie(Coin coin, int newNumLoonies)
	{
		for (int i = 0; i< newNumLoonies; i++)
			coins.add(coin);
	}

	/**addToonie method:
	 * This is a modifier method that adds toonies to an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to enter <type Coin>
	 * 		  newNumToonies - A variable that stores the number of dimes the user wants to add <type int>
	 * @return none
	 */
	public void addToonie(Coin coin, int newNumToonies)
	{
		for (int i = 0; i< newNumToonies; i++)
			coins.add(coin);
	}

	/**getSavings method:
	 * This is a accessor method that calculates the total value in the ArrayList of coins 
	 *
	 * @param none
	 * @return the total value of the coins <type BigDecimal>
	 */
	public BigDecimal getSavings()
	{
		total = 0;
		for(int i=0;i<coins.size();i++)
		{
			total += coins.get(i).getValue();
		}
		
		BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);		//restricts the total value of the coins to 2 decimal places "00.00" 
		return bd;
	}

	/**removeAllCoins method:
	 * This is a modifier method that removes all coins from an ArrayList of coins 
	 *
	 * @param none
	 * @return none
	 */
	public void removeAllCoins()
	{
		coins.clear();
	}

	/**removeSpecificValue method:
	 * This is a modifier method that removes a specific value entered by the user from an ArrayList of coins 
	 *
	 * @param removeValue - A variable that reads and stores the exact value that the user wants to remove from the PiggyBank <type double>
	 * @return none
	 */
	public void removeSpecificValue(double removeValue)
	{
		if (removeValue <= total)
		{
			for (int i = 0; i < coins.size() - 1; i++) 
			{
				for (int j = 0; j < coins.size() - 1 -i; j++) 
				{
					if (coins.get(j).getValue() > coins.get(j+1).getValue()) 		//BubbleSort to sort the arraylist in ascending order
					{
						Coin temp = coins.get(j);
						coins.set(j,  coins.get(j+1));
						coins.set(j+1, temp);
					}
				}
			}

			/*for (int i = 0; i< coins.size(); i++)
				System.out.println(coins.get(i).getValue());		//for checking if list is sorted correctly
			 */

			for(int i=coins.size()-1;i>=0;i--){
				if(removeValue>= coins.get(i).getValue())
				{
					//System.out.println("Hello World");
					removeValue -= coins.get(i).getValue();			// for loop that begins checking from the highest value and removes values until removeValue becomes 0
					coins.remove(i);
				}
			}
		} 
		else if (removeValue < 0 || removeValue > total)			// To check if the value the user wants to remove is available in the PiggyBank or not
		{
			System.out.println("Sorry you don't have $"+removeValue+ " in your acocunt");  // User friendly prompt 
		}
	}

	/**removeNickelDenominations method:
	 * This is a modifier method that removes a specific number of nickels from an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to remove <type Coin> 
	 * 		  removeNickel - A variable that reads and stores the exact number of nickels that the user wants to remove from the PiggyBank <type int>
	 * @return none
	 */
	public void removeNickelDenominations(Coin coin, int removeNickel)
	{
		for (int i = 0; i< removeNickel; i++)
		{
			if (coins.contains(coin))		//checks if the PiggyBank contains the required amount of nickels
				coins.remove(coin);			// removes the object of the coin if condition is met
			else 
			{
				System.out.println("Sorry you cannot remove "+removeNickel+" nickels");		//User friendly prompt if the desired number of nickels are not available in the PiggyBank
				break;
			}
		}
	}


	/**removeDimeDenominations method:
	 * This is a modifier method that removes a specific number of dimes from an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to remove <type Coin> 
	 * 		  removeDime - A variable that reads and stores the exact number of dimes that the user wants to remove from the PiggyBank <type int>
	 * @return none
	 */
	public void removeDimeDenominations(Coin coin, int removeDime)
	{
		for (int i = 0; i< removeDime; i++)
		{
			if (coins.contains(coin))		//checks if the PiggyBank contains the required amount of dimes
				coins.remove(coin);			// removes the object of the coin if condition is met
			else 
			{
				System.out.println("Sorry you cannot remove "+removeDime+" dimes");		//User friendly prompt if the desired number of dimes are not available in the PiggyBank
				break;
			}
		}
	}

	/**removeQuarterDenominations method:
	 * This is a modifier method that removes a specific number of quarters from an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to remove <type Coin> 
	 * 		  removeQuarter - A variable that reads and stores the exact number of quarters that the user wants to remove from the PiggyBank <type int>
	 * @return none
	 */
	public void removeQuarterDenominations(Coin coin, int removeQuarter)
	{
		for (int i = 0; i< removeQuarter; i++)
		{
			if (coins.contains(coin))		//checks if the PiggyBank contains the required amount of quarters
				coins.remove(coin);			// removes the object of the coin if condition is met
			else 
			{
				System.out.println("Sorry you cannot remove "+removeQuarter+" quarters");		//User friendly prompt if the desired number of quarters are not available in the PiggyBank
				break;
			}
		}
	}

	/**removeLoonieDenominations method:
	 * This is a modifier method that removes a specific number of loonies from an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to remove <type Coin> 
	 * 		  removeLoonie - A variable that reads and stores the exact number of loonies that the user wants to remove from the PiggyBank <type int>
	 * @return none
	 */
	public void removeLoonieDenominations(Coin coin, int removeLoonie)
	{
		for (int i = 0; i< removeLoonie; i++)
		{
			if (coins.contains(coin))		//checks if the PiggyBank contains the required amount of loonies
				coins.remove(coin);			// removes the object of the coin if condition is met
			else
			{
				System.out.println("Sorry you cannot remove "+removeLoonie+" loonies");		//User friendly prompt if the desired number of loonies are not available in the PiggyBank
				break;
			}
		}
	}

	/**removeToonieDenominations method:
	 * This is a modifier method that removes a specific number of toonies from an ArrayList of coins 
	 *
	 * @param coin - A variable that reads the type of coin the user wants to remove <type Coin> 
	 * 		  removeToonie - A variable that reads and stores the exact number of toonies that the user wants to remove from the PiggyBank <type int>
	 * @return none
	 */
	public void removeToonieDenominations(Coin coin, int removeToonie)
	{
		for (int i = 0; i< removeToonie; i++)
		{
			if (coins.contains(coin))		//checks if the PiggyBank contains the required amount of toonies
				coins.remove(coin);			// removes the object of the coin if condition is met
			else
			{
				System.out.println("Sorry you cannot remove "+removeToonie+" toonies");		//User friendly prompt if the desired number of toonies are not available in the PiggyBank
				break;
			}
		}
	} // end of PiggyBank class
}