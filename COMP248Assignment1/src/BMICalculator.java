/* This program will calculate your BMI index by taking the mass in kg of the user and the height in meters squared 
 *
 *It begins with importing the Scanner function
 */
import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		//We First create the myKeyboard variable in order to allow keyboard inputs from the user, also making the use of System.in to achieve this input//
		Scanner myKeyboard = new Scanner(System.in);
		
		//We then prompt the user about his weight and allow him to enter the appropriate integer//
		System.out.println("Please enter your weight in kilograms:");
			float userWeight = myKeyboard.nextFloat();
		
		//Followed by his height as a Float type variable since it requires decimals//
		System.out.println("Please enter your height in meters:");
			float userHeight = myKeyboard.nextFloat();
			
		//Now we make the actual calculator which uses weight divided by height//
		float bmiCalculator = userWeight / (userHeight*userHeight);
		
		//It is time to display the inputs and outputs//
		System.out.println("Your weight: " + userWeight + "kg");
		System.out.println("Your Height: " + userHeight + "m\n");
		System.out.println("Your BMI is: " + bmiCalculator + "kg/m^2\n\n\n");
		System.out.print("Thanks for using the Ultmate XXXSupernova_ExterminatusXXX BMI Calculator!");
		
		//Don't forget to close the keyboard function!//
		myKeyboard.close();
		
		

	}

}
