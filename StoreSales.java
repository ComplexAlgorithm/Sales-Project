/*
 * Create a modular program using structured programming to store the amount of money a local
store made in sales for each day of the past week. The user will be given the option to enter an
amount for the next day, compute the average, find the highest amount, find the lowest amount,
or print all the information including the daily sales with the average, highest, and lowest
amount.
When the user chooses an option to enter an amount for the next day, the user will be prompted
to enter the amount. The amount must be greater than or equal to 0. If a negative amount is
entered the user will be given an error message and prompted to enter a value greater than or
equal to 0 for the same day. Once the user has entered a value greater than or equal to 0, that
amount will be saved. If the user attempts to enter more than seven days the program will give
the user an error message informing them the information for the entire week has already been
entered.
If the user chooses to compute the average, find the highest amount, or find the lowest amount
that amount will be printed to screen.
This program will only have one class which has static methods and uses a single array of size
seven to save the daily sales amounts. There should be a main method, a static method to get an
amount from the user, compute the average, find the lowest amount, find the highest amount, and
print out all the information.
 */
import java.util.Scanner;
public class StoreSales {
	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		
		double [] salesArray = new double [7];
		int numberOfDays = 0;
		int option;
		do {
			System.out.println("Press 1 to enter a sales amount for the next day.");
			System.out.println("Press 2 to compute the average sales amount.");
			System.out.println("press 3 to find the highest amount of sales.");
			System.out.println("Press 4 to find the lowest amount in sales.");
			System.out.println("Press 5 to view all of the information.");
			System.out.println("Press 6 to end the program.");
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if(option == 1) {
				if(numberOfDays < 7) {
					numberOfDays = enterAmount(salesArray, numberOfDays);
				}
				else {
					System.out.println("All sales amounts have been entered for this week.");
				}
			}
			else if(option == 2) {
				double average = computeAverage(salesArray, numberOfDays);
				System.out.println("The average sales is: " + average);
			}
			else if(option == 3) {
				double highestAmount = findHighestAmount(salesArray, numberOfDays);
				System.out.println("The highest amount is: " + highestAmount);
			}
			else if(option == 4) {
				double lowestAmount = findLowestAmount(salesArray, numberOfDays);
				System.out.println("The lowest amount is: " + lowestAmount);
			}
			else if(option == 5) {
				print(salesArray, numberOfDays);
			}
			else if(option == 6) {
				System.out.println("Goodbye!");
			}
			else {
				System.out.println("Error!");
			}
		}while(option != 6);
	}
	public static int enterAmount(double [] sArray, int index) {
		Scanner keyboard = new Scanner(System.in);
		double amount;
		do {
			System.out.println("Enter the sales amount for the next day.");
			amount = keyboard.nextDouble();
			
			if(amount < 0) { 
				System.out.println("Error! amount cannot be less than 0!");
			}
		}while(amount < 0);
		
		sArray[index] = amount;
		index++;
		return index;
	}
	public static double computeAverage(double [] salesArray, int numberOfDays) {
		double sum = 0.0;
		double average = 0.0;
		for(int index = 0; index < numberOfDays; index++) {
			sum = sum + salesArray[index];
		}
		if(numberOfDays > 0) 
			average = sum / (double) numberOfDays;
		
		return average;
	}
	public static double findHighestAmount(double [] mArray, int days) {
		double highestAmount = mArray[0];
		for(int index = 0; index < days; index++) {
			if(mArray[index] > highestAmount)
				highestAmount = mArray[index];
		}
		return highestAmount;
		
	}
	public static double findLowestAmount(double [] dArray, int days) {
		double lowestAmount = dArray[0];
		for(int index = 0; index < days; index++) {
			if(dArray[index] < lowestAmount)
				lowestAmount = dArray[index];
		}
		return lowestAmount;
	}
	public static void print(double [] array, int days) {
		for(int i = 0; i < days; i++ ) {
			System.out.println("The amount made in sales for this day is:$  " + array[i]);
		}
		System.out.println("The sales average is:$ " + computeAverage(array, days));
		System.out.println("The highest amount is: $ " + findHighestAmount(array, days));
		System.out.println("The lowest amount is: $ " + findLowestAmount(array, days));
	}
	
		
}


