/*============================================================================================================================================================================================
PiggyBank Assignment
Hitansh Bhatt
December 15, 2020
Java, Oxygen.3a (4.7.3a)
==============================================================================================================================================================================================
Problem Definition –  Use OOP and arrayList concepts to create a program that functions as a piggyBank/bank account. It should include features such as:
(i) Show total in bank		(ii) Add a nickel		(iii) Add a dime		(iv) Add a quarter		(v) Add a loonie		(vi) Add a toonie
(vii) Take money out of the bank:
		(a) Break and take out all
		(b) Ask for a specific amount to take out
		(c) Ask for specific coin denominations

(viii) 0 to quit the program
Input – Desired input from the users in accordance to the action required to be performed. Usually, most of the input is integers, except
		when the user wants to remove a specific amount (double input) and when the user wants to remove a specific denomination (String)
Output – (i) Total in the bank		(ii) User friendly prompts

Process – Implement java OOP and ArrayList concepts to meet the requiremnts of the assignment
==============================================================================================================================================================================================
 */

import java.io.*;
import java.util.Scanner;

public class MySavings extends PiggyBank{

	
	/**main method 
	 * This procedural method is called automatically and is used to organize the menu and calling of other methods defined in the class
	 * 
	 * List of local variables:
	 * (1) sc - scanner object used for reading numbers <type Scanner>
	 * (2) br - to read String input from users <type BufferedReader>
	 * (3) NickelObject - An object of the Nickel class <type Nickel>
	 * (4) DimeObject - An object of the Dime class <type Dime>
	 * (5) QuarterObject - An object of the Quarter class <type Quarter>
	 * (6) LoonieObject - An object of the Loonie class <type Loonie>
	 * (7) ToonieObject - An object of the Toonie class <type Toonie>
	 * (8) numNickel, numDime, numQuarters, numLoonies, numToonies - variables used to read and store the number of objects the user wants to add <type int>
	 * (9) removeNickel, removeDime, removeQuarter, removeLoonie, removeToonie - variables used to read and store the number of objects the user wants to remove <type int>
	 * (10) removeValue - a variable used to read and store the exact value the user wants to withdraw <type double>
	 * (11) coinType - a variable used to read and store the type of coin (nickel, dime, quarter, loonie, toonie) the user wants to withdraw <type String>
	 * (12) optionQ7 - a variable used to read and store the sub-options (a, b or c) for option 7 <type String> 
	 * (13) bank - a object for the PiggyBank class to access Piggybanks' methods <type PiggyBank>
	 * (14) choice - a variable used to read and store user input for the menu options <type int>
	 *
	 * @param args <type string>
	 * @throws IO Exception
	 * @return void
	 */
	public static void main(String[] args) throws IOException
	{
		/*
		 * Nickel - 5 cent
		 * dime - 10 cent
		 * quarter 25 cent
		 * loonie - 1 dollar
		 * toonie - 2 dollars
		 */
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		Nickel NickelObject = new Nickel();
		Dime DimeObject = new Dime();
		Quarters QuarterObject = new Quarters();					// Objects of specific coin classes
		Loonie LoonieObject = new Loonie();
		Toonie ToonieObject = new Toonie();
		int NumNickel;
		int NumDime;
		int NumQuarters;
		int NumLoonies;
		int NumToonies;
		int removeNickel;
		int removeDime;
		int removeQuarter;
		int removeLoonie;
		int removeToonie;
		double removeValue;
		String coinType;
		String optionQ7;
		PiggyBank bank = new PiggyBank();
		//menu options
		System.out.println("Hi, welcome to HB Piggy Bank service! \nHere are a list of services that you could choose from: \n");
		System.out.println("1. Show total in bank \n2. Add a nickel\n3. Add a dime\n4. Add a quarter \n5. Add a loonie\n6. Add a toonie");
		System.out.println("7. Take money out of the bank: \n \ta. Break and take out all \n \tb. Ask for a specific amount to take out \n \tc. Ask for specific coin denominations");
		System.out.print("\nEnter 0 to quit.\n \nPlease enter your choice #: \n");
		int choice  = sc.nextInt();
		do
		{
				if (choice == 1)		//option 1
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());

				else if (choice == 2)	//option 2
				{
					System.out.println("Enter the number of nickels: ");
					NumNickel = sc.nextInt();
					bank.addNickel(NickelObject, NumNickel);
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());
				}

				else if (choice == 3)	//option 3
				{
					System.out.print("Enter the number of dimes: ");
					NumDime = sc.nextInt();
					bank.addDime(DimeObject, NumDime);
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());
				}

				else if (choice == 4)	//option 4
				{
					System.out.print("Enter the number of quarters: ");
					NumQuarters = sc.nextInt();
					bank.addQuarter(QuarterObject, NumQuarters);
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());
				}

				else if (choice == 5)	//option 5
				{
					System.out.print("Enter the number of loonies: ");
					NumLoonies = sc.nextInt();
					bank.addLoonie(LoonieObject, NumLoonies);
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());
				}

				else if (choice == 6)	//option 6
				{
					System.out.print("Enter the number of toonies: ");
					NumToonies = sc.nextInt();
					bank.addToonie(ToonieObject, NumToonies);
					System.out.print("The total amount of money in the piggy bank is: $"+bank.getSavings());
				}

				else if (choice == 7)	//option 7
				{
					System.out.println("Enter your choice : A, B or C");
					optionQ7 = br.readLine();

					if (optionQ7.equalsIgnoreCase("A"))
					{
						bank.removeAllCoins();
						System.out.println("You have withdrawn all the money from your piggy bank!");
						System.out.println("Balance left: $"+bank.getSavings());
					}
					else if (optionQ7.equalsIgnoreCase("B"))
					{
						System.out.println("Enter the exact amount you want to withdraw");
						removeValue = sc.nextDouble();
						bank.removeSpecificValue(removeValue);
						System.out.print("The total amount of money left in your piggy bank after the withdrawal is: $"+bank.getSavings());
					}
					else if ((optionQ7.equalsIgnoreCase("C")))
					{
						System.out.println("What type of coin do you want to remove?");
						coinType = br.readLine();
						if (coinType.equalsIgnoreCase("dimes") || coinType.equalsIgnoreCase("dime"))
						{
							System.out.println("Enter the number of dimes you want to remove");
							removeDime = sc.nextInt();
							bank.removeDimeDenominations(DimeObject, removeDime);
						}

						if (coinType.equalsIgnoreCase("nickels") || coinType.equalsIgnoreCase("nickel"))
						{
							System.out.println("Enter the number of nickels you want to remove");
							removeNickel = sc.nextInt();
							bank.removeNickelDenominations(NickelObject, removeNickel);
						}

						if (coinType.equalsIgnoreCase("quarters") || coinType.equalsIgnoreCase("quarter"))
						{
							System.out.println("Enter the number of quarters you want to remove");
							removeQuarter = sc.nextInt();
							bank.removeQuarterDenominations(QuarterObject, removeQuarter);
						}

						if (coinType.equalsIgnoreCase("loonie") || coinType.equalsIgnoreCase("loonies"))
						{
							System.out.println("Enter the number of loonies you want to remove");
							removeLoonie = sc.nextInt();
							bank.removeLoonieDenominations(LoonieObject, removeLoonie);
						}

						if (coinType.equalsIgnoreCase("toonie") || coinType.equalsIgnoreCase("toonies"))
						{
							System.out.println("Enter the number of toonies you want to remove");
							removeToonie = sc.nextInt();
							bank.removeToonieDenominations(ToonieObject, removeToonie);
						}
					}
				}
			System.out.print("\nEnter 0 to quit.\n \nPlease enter your choice #: \n");
			choice = sc.nextInt();
			if (choice != 0 || choice > 0)
				continue;
			else if (choice == 0)
			{
				System.out.print("Thank you for using HB Piggy Bank service!"); 		// User Friendly Prompt
				break;
			}

		}while (choice > 0);											// End of do-while loop
	} 																	// End main method
}																		// End mySavings class
