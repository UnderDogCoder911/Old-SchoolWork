import java.util.Scanner;
public class Question2IntegerDivisionsandLoops {

	public static void main(String[] args) {
	
		//Initalize the Scanner
		
		Scanner kb = new Scanner(System.in);
		
		//Display Greeting
		
		System.out.println("Welcome to our Calculation Program!");
		
		//Prompt user for a number with at most 7 digits
		
		System.out.print("\nEnter a number with at most 7-digits: ");
		int Digit = kb.nextInt();
		
		//Using a mix of integer division and modulus we obtain each singular digit in any given 7 digit number
		//Because we are using integers, we do not worry about the decimal values
		//As such the 1st left most digit of any given integer will be the result of a division by 1000000 which will yield our first number
		//subsequent Digits require the use of modulus
		//because modulus gives only the remainder, if we do the modulus of a integer division we will be left with the digit we seek
		
		int First_Digit = Digit/1000000;
		int Second_Digit = ((Digit/100000)%10);
		int Third_Digit = ((((Digit/10000)%100)%10));
		int Fourth_Digit = (((((Digit/1000)%1000)%100)%10));
		int Fifth_Digit = (((((Digit/100)%10000)%1000)%100)%10);
		int Sixth_Digit = ((((((Digit/10)%100000)%10000)%1000)%100)%10);
		int Seventh_Digit = ((((((Digit%1000000)%100000)%10000)%1000)%100)%10);
		
		//Now we must create and if else statement for every possible value the user can enter 
		//Some digits inputed maybe 1 digit long while others 7 digits
		//We will use a if-else loop
		//The for loop will work to find the divisors of any given sum by doing a continual modulus starting by 1 
		//The values of x that yield a remainder of 0 are the divisors we seek
		
		int SumOfDigits;
		int x;
		int y;
			
		if(Digit<10)
			 {SumOfDigits = Seventh_Digit;
			 System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
			 System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
			 for(x=1;x<10;x++)
			 { y = SumOfDigits%x;
			 if(y==0)
				 System.out.print(x+" ");}}
		else
			if(Digit<100)
				{SumOfDigits = Sixth_Digit + Seventh_Digit;
				System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
				System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
				 for(x=1;x<100;x++)
				 { y = SumOfDigits%x;
				 if(y==0)
					 System.out.print(x+" ");}}
			else
				if(Digit<1000)
					{SumOfDigits = Fifth_Digit + Sixth_Digit + Seventh_Digit;
					System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
					System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
					 for(x=1;x<1000;x++)
					 { y = SumOfDigits%x;
					 if(y==0)
						 System.out.print(x+" ");}}
				else
					if(Digit<10000)
						{SumOfDigits = Fourth_Digit + Fifth_Digit + Sixth_Digit + Seventh_Digit;
						System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
						System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
						 for(x=1;x<10000;x++)
						 { y = SumOfDigits%x;
						 if(y==0)
							System.out.print(x+" ");}}
					else
						if(Digit<100000)
							{SumOfDigits = Third_Digit + Fourth_Digit + Fifth_Digit + Sixth_Digit + Seventh_Digit;
							System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
							System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
							 for(x=1;x<100000;x++)
							 { y = SumOfDigits%x;
							 if(y==0)
								 System.out.print(x+" ");}}
						else
							if(Digit<1000000)
								{SumOfDigits = Second_Digit + Third_Digit + Fourth_Digit + Fifth_Digit + Sixth_Digit + Seventh_Digit;
								System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
								System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
								 for(x=1;x<1000000;x++)
								 { y = SumOfDigits%x;
								 if(y==0)
									 System.out.print(x+" ");}}
							else
								if(Digit<10000000)
									{SumOfDigits = First_Digit + Second_Digit + Third_Digit + Fourth_Digit + Fifth_Digit + Sixth_Digit + Seventh_Digit;
									System.out.println("\nSum of the digits of "+Digit+" is: " + SumOfDigits);
									System.out.println("\nThe divisors of "+SumOfDigits+" are as follows:");
									 for(x=1;x<10000000;x++)
									 { y = SumOfDigits%x;
									 if(y==0)
										 System.out.print(x+" ");}}
		
		//We will now offer the user to relaunch the program
		
		System.out.print("\n\nDo you want to try another number? (yes to repeat, no to stop) ");
		String Restart = kb.next();
		String yes = "yes";
		String no = "no";
		
		//For the program to loop on itself we need a while loop
		//So if yes is entered it will remain true up until the next keyboard prompt
		//If at the next keyboard prompt no is entered, it will break the loop
		
			while(Restart.equals(yes))
				
				{ System.out.print("\nEnter a number with at most 7-digits: ");
				int Digit2 = kb.nextInt();
		
				int First_Digit2 = Digit2/1000000;
				int Second_Digit2 = ((Digit2/100000)%10);
				int Third_Digit2 = ((((Digit2/10000)%100)%10));
				int Fourth_Digit2 = (((((Digit2/1000)%1000)%100)%10));
				int Fifth_Digit2 = (((((Digit2/100)%10000)%1000)%100)%10);
				int Sixth_Digit2 = ((((((Digit2/10)%100000)%10000)%1000)%100)%10);
				int Seventh_Digit2 = ((((((Digit2%1000000)%100000)%10000)%1000)%100)%10);
		
				int SumOfDigits2;
				int x2;
				int y2;
			
				if(Digit2<10)
			 		{SumOfDigits2 = Seventh_Digit2;
			 		System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
			 		System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
			 		for(x2=1;x2<10;x2++)
			 		{ y2 = SumOfDigits2%x2;
			 		if(y2==0)
			 			System.out.print(x2+" ");}}
				else
					if(Digit2<100)
						{SumOfDigits2 = Sixth_Digit2 + Seventh_Digit2;
						System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
						System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
						for(x2=1;x2<100;x2++)
						{ y2 = SumOfDigits2%x2;
						if(y2==0)
							System.out.print(x2+" ");}}
					else
						if(Digit2<1000)
							{SumOfDigits2 = Fifth_Digit2 + Sixth_Digit2 + Seventh_Digit2;
							System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
							System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
							for(x2=1;x2<1000;x2++)
							{ y2 = SumOfDigits2%x2;
							if(y2==0)
								System.out.print(x2+" ");}}
						else
							if(Digit2<10000)
								{SumOfDigits2 = Fourth_Digit2 + Fifth_Digit2 + Sixth_Digit2 + Seventh_Digit2;
								System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
								System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
								for(x2=1;x2<10000;x2++)
								{ y2 = SumOfDigits2%x2;
								if(y2==0)
									System.out.print(x2+" ");}}
							else	
								if(Digit2<100000)
									{SumOfDigits2 = Third_Digit2 + Fourth_Digit2 + Fifth_Digit2 + Sixth_Digit2 + Seventh_Digit2;
									System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
									System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
									for(x2=1;x2<100000;x2++)
									{ y2 = SumOfDigits2%x2;
									if(y2==0)
										System.out.print(x2+" ");}}
								else
									if(Digit2<1000000)
										{SumOfDigits2 = Second_Digit2 + Third_Digit2 + Fourth_Digit2 + Fifth_Digit2 + Sixth_Digit2 + Seventh_Digit2;
										System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
										System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
										for(x2=1;x2<1000000;x2++)
										{ y2 = SumOfDigits2%x2;
										if(y2==0)
											System.out.print(x2+" ");}}
									else
										if(Digit2<10000000)
											{SumOfDigits2 = First_Digit2 + Second_Digit2 + Third_Digit2 + Fourth_Digit2 + Fifth_Digit2 + Sixth_Digit2 + Seventh_Digit2;
											System.out.println("\nSum of the digits of "+Digit2+" is: " + SumOfDigits2);
											System.out.println("\nThe divisors of "+SumOfDigits2+" are as follows:");
											for(x2=1;x2<10000000;x2++)
											{ y2 = SumOfDigits2%x2;
											if(y2==0)
												System.out.print(x2+" ");}}
				
				
				System.out.print("\n\nDo you want to try another number? (yes to repeat, no to stop) ");
				String Restart2 = kb.next();
				String yes2 = yes;
				String no2 = no;
			
		if(Restart2.equals(no2))
				{System.out.println("\nThanks and have a Great Day!");
				break;
				}
	
				}
								
						
	kb.close();}

}
