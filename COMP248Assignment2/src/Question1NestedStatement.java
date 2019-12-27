/*
 * Assignment 2
 * Written by Luca Stefanutti  
 * For COMP 248 Section FF
 */
import java.util.Scanner;
public class Question1NestedStatement {

	public static void main(String[] args) {
	//Initialize keyboard option
		
		Scanner kb = new Scanner(System.in);
	
	//Display welcome
		
		System.out.print("Welcome to Concordia Language Proficiency Evaluator!"
							+ "\n         based on IELTS exam");
	
	//Initialize values for all skills, overall score and integer part
		
		double WritingSkill;
		double ReadingSkill;
		double ListeningSkill;
		double SpeakingSkill;
		double OverallScore;
		int IntegerPart;
	
	//print option choices
		
		System.out.println("\n\nPlease select one of the following options:");
		System.out.println("1 - Language Proficiency Requirements for the Applicant");
		System.out.println("2 - Evaluation of your English Proficiency");
	
	//Prompt user for option
		
		System.out.print("\nPlease enter the digit corresponding to your case: ");
		int OptionChoice = kb.nextInt();
	
	//Create Option for 1
		
		if(OptionChoice == 1)
			{System.out.println("\n- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores"
					+ "\nfor writing and reading skills should not be below 6.0. If your overall score is 6, and your"
					+ "\nreading and writing scores are at least 6, you will be eligible for conditional admission. So"
					+ "\nyou need to take an English course in the first semester. Otherwise you have to retake the IELTS"
					+ "\nexam."
					+ "\nThanks for choosing Concordia.");}
		//Create Option for 2
		
		if(OptionChoice == 2) {
			
			//Prompt for each skill
			
			System.out.print("\nPlease enter your listening score: ");
			ListeningSkill = kb.nextDouble();
			
			System.out.print("\nPlease enter your speaking score: ");
			SpeakingSkill = kb.nextDouble();
			
			System.out.print("\nPlease enter your reading score: ");
			ReadingSkill = kb.nextDouble();
			
			System.out.print("\nPlease enter your writing score: ");
			WritingSkill = kb.nextDouble();
			
			//define OverallScore which is the average of all other scores
			
			OverallScore = ((ListeningSkill + SpeakingSkill + ReadingSkill + WritingSkill)/4);
			
			//roundup or down the Overall score, making use of IntegerPart which will be subtracted from the OverallScore
			
			IntegerPart = (int)OverallScore;
			double Rounding = OverallScore - IntegerPart;
			
			//depending on the difference between OverallScore and IntegerPart it will remain the same, be rounded to a half
			//or rounded up since there can only be whole of half marks
			
			if(Rounding < 0.25)
				{OverallScore = IntegerPart;
				System.out.println("\nYour overall score is: " + OverallScore);}
			else
				if(Rounding < 0.75)
					{OverallScore = IntegerPart + 0.5;
					System.out.println("\nYour overall score is: " + OverallScore);}
				else 
					if(Rounding < 1) 
						{OverallScore = IntegerPart + 1;
						System.out.println("\nYour overall score is: " + OverallScore);}
		
			//Now print the results for each score
			System.out.println("Your reading score is: " + ReadingSkill);
			System.out.println("Your writing score is: " + WritingSkill);
			
			//For each RoundedOverallScore we have to print weather the student is eligible, has conditional eligibility or needs to retake the exam
			
			if((OverallScore >= 6.5) & (ReadingSkill >= 6.0)  & (WritingSkill >= 6.0))
				{System.out.println("\nCongradulations: You are eligible for Admission.");}
			else
				if((OverallScore >= 6.5) & (ReadingSkill < 6.0) | (WritingSkill < 6.0))
				{System.out.println("\nYou are eligible for Conditional Admission.");}
				else
					if((OverallScore == 6.0) & (ReadingSkill >= 6.0) & (WritingSkill >= 6.0))
						{System.out.println("\nYou are eligible for Conditional Admission.");}
					else
						if((OverallScore == 6.0) & (ReadingSkill < 6.0) | (WritingSkill < 6.0))
							{System.out.println("\nSorry, you have to retake the exam.");}
						else
							if(OverallScore < 6)
								{System.out.println("\nSorry, you have to retake the exam.");}
			System.out.println("\nThank You for using The Concordia Language Proficiency Evaluator.");
			kb.close();
		
					
		}
	}

}