/* 
 * Assignment 3
 * Written by: Luca Stefanutti
 * For COMP 248 Section FF
 */
import java.util.Random;
import java.util.Scanner;
public class Question1 {

	public static void main(String[] args) {
		//Create Scanner in order to prompt user in future
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
				
		//Create the array of the teams in every round and the scores as well as the future totalscores and averages
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium",
							"Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", 
							"Colombia","England"};
		String[] QuarterFinalsTeams = new String [8];
		String[] SemiFinalsTeams = new String [4];
		String[] FinalTeams = new String [2];
		int [][] TotalScores = new int [21][16];
		double averages[] = new double [21]; 
		
		
		//Prompt user for favorite team + greet user
		System.out.print("Welcome to Fifa 2018 super game!");
		System.out.print("\nEnter your favorite team: ");
		String userChoice = kb.next();
				
		//Exit message if team is not within teams16
		int x = 0;
		for (int i= 0; i <=15; i++) {
		if ((userChoice.compareToIgnoreCase(teams16[i])!= 0)) 
					x++;
			if (x == 16) {
				System.out.print("Your team is not in the Round of 16");
				System.exit(0);
			}
			}
		
		//creating the 20 tournaments loop, j will be the number of times the tournament is played and will reappear in many formulas
		for (int j =0; j<21; j++) {
		
			//initalize the scores and indexes for each array of teams
			int[] ScoreRound16 = {rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5)};
			int[] ScoreQuarterFinals = {rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5)};
			int[] ScoreSemiFinals={rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5)};
			int[] ScoreFinal={rand.nextInt(5),rand.nextInt(5)};
			
			int indexQFTeams=0;
			int indexSFTeams=0;
			int indexFTeams=0; 
		
		
		
			
		//This will attribute a winner chosen in case of a tie breaker in Round of 16
		for (int i = 0; i<=15; i+=2) {
			if (ScoreRound16[i] == ScoreRound16[i+1])
				ScoreRound16[i]++;
			//The following if elseif will compare the scores in Round of 16 and assign the winners to the array of Quarter-final teams
			if (ScoreRound16[i] > ScoreRound16[i+1]) {
				QuarterFinalsTeams[indexQFTeams] = teams16[i];
				indexQFTeams++;}
			else if (ScoreRound16[i+1] > ScoreRound16[i]) {
				QuarterFinalsTeams[indexQFTeams]= teams16[i+1];
				indexQFTeams++;
			}		
			}
		//Printing out the Round of 16 results
		System.out.print("\nROUND OF 16");
		System.out.print("["+teams16[0] +" " +ScoreRound16[0] +":"+ScoreRound16[1] + " "+teams16[1]+"]"+"["+teams16[2] +" " + ScoreRound16[2]+":"+ScoreRound16[3] + " "+teams16[3]+"]"+
		"["+teams16[4] +" " + ScoreRound16[4]+":"+ScoreRound16[5] + " "+teams16[5]+"]"+"["+teams16[6] +" " + ScoreRound16[6]+":"+ScoreRound16[7] + "\n "+teams16[7]+"]"+
		"["+teams16[8] +" " + ScoreRound16[8]+":"+ScoreRound16[9] + " "+teams16[9]+"]"+"["+teams16[10] +" " + ScoreRound16[10]+":"+ScoreRound16[11] + " "+teams16[11]+"]"+
		"["+teams16[12] +" " + ScoreRound16[12]+":"+ScoreRound16[13] + " "+teams16[13]+"]"+"["+teams16[14] +" " + ScoreRound16[14]+":"+ScoreRound16[15] + "\n "+teams16[15]+"]");
		
		//This will attribute a winner chosen in case of a tie in Quarter-Finals
				for (int i = 0; i<=7; i+=2) {
					if (ScoreQuarterFinals[i] == ScoreQuarterFinals[i+1])
						ScoreQuarterFinals[i+1]++;
					//The following if elseif will compare the scores in Quarter-Finals and assign the winners to the array of Semi-final teams
					if(ScoreQuarterFinals[i] > ScoreQuarterFinals[i+1]) {
						SemiFinalsTeams[indexSFTeams] = QuarterFinalsTeams[i];
						indexSFTeams++;
					}
					else if (ScoreQuarterFinals[i+1] > ScoreQuarterFinals[i]) {
						SemiFinalsTeams[indexSFTeams] = QuarterFinalsTeams[i+1];
						indexSFTeams++;
					
					}
				}
		//Printing out the Quarter-Final results
		System.out.print("\nQUARTER-FINALS");
		System.out.print("["+QuarterFinalsTeams[0]+" " +ScoreQuarterFinals[0]+":"+ScoreQuarterFinals[1]+ " "+QuarterFinalsTeams[1]+"]"
		+"["+QuarterFinalsTeams[2]+" " +ScoreQuarterFinals[2]+":"+ScoreQuarterFinals[3]+ " "+QuarterFinalsTeams[3]+"]"
		+"["+QuarterFinalsTeams[4]+" " +ScoreQuarterFinals[4]+":"+ScoreQuarterFinals[5]+ " "+QuarterFinalsTeams[5]+"]"
		+"["+QuarterFinalsTeams[6]+" \n" +ScoreQuarterFinals[6]+":"+ScoreQuarterFinals[7]+ " "+QuarterFinalsTeams[7]+"]");
		
		//this will attribute a winner in case of a tie in SemiFinals
		for (int i = 0; i<=3; i+=2) {
			if (ScoreSemiFinals[i] == ScoreSemiFinals[i+1])
				ScoreSemiFinals[i]++;
			//The following if elseif will compare the scores in Semi-Finals and assign the winners to the array of final teams
			if (ScoreSemiFinals[i] > ScoreSemiFinals[i+1]) {
				FinalTeams[indexFTeams] =  SemiFinalsTeams[i];
				indexFTeams++;
			}
			else if (ScoreSemiFinals[i+1] > ScoreSemiFinals[i]) {
				FinalTeams[indexFTeams] = SemiFinalsTeams[i+1];
				indexFTeams++;
			}
		}
	//printing out the Semi-finalists	
	System.out.print("\nSEMI-FINALS");
	System.out.print("["+SemiFinalsTeams[0]+" " +ScoreSemiFinals[0]+":"+ScoreSemiFinals[1]+" " +SemiFinalsTeams[1]+"]"
					+"["+SemiFinalsTeams[2]+" " +ScoreSemiFinals[2]+":"+ScoreSemiFinals[3]+" " +SemiFinalsTeams[3]+"]");
	
	//deciding a winner in Finals in case of a tie
	if (ScoreFinal[0] == ScoreFinal[1])
		ScoreFinal[1]++;
	//printing out the Final winners
	System.out.print("\nFINAL");
	System.out.print("["+FinalTeams[0]+" " +ScoreFinal[0]+":"+ScoreFinal[1]+" " +FinalTeams[1]+"]");
	
	// k, n, p are indexes for the arrays of the various scores that must now be stored in a 2D array
	int k=0;
	int n = 0;
	int p = 0;
	//count is meant to keep track of the number of matches with scores bigger than the average *gives logical error, don't know how to fix*
	int count = 0;
	double averageofaverages = 0;
	
	//this for loop assigns values from the various arrays of scores to one 2D array of Totalscores
	for (int i=0; i <=14; i++) {
		
		//the first if statement assigns the indexes Totalscore[j][0 to 7] which is the addition of the scores in Roundof16
		if (i <= 7) {
		TotalScores [j][i] = (ScoreRound16[k] + ScoreRound16[k+1]); 
		k+=2;}
		
		//the second if statement assigns the indexes Totalscore[j][8 to 11]
		else if (i <=11 ) {
			TotalScores [j][i] = (ScoreQuarterFinals[n] + ScoreQuarterFinals[n+1]);
			n+=2;}
		
		//the thrid if statement assigns the indexes Totalscore[j][12 to 13]
		else if (i <= 13) {
			TotalScores [j][i] = (ScoreSemiFinals[p] + ScoreSemiFinals[p+1]);
			p+=2;
		}
		
		//the last if statement assigns the final scores to the final index Totalscore[j][14]
		else if (i == 14) {
			TotalScores [j][i] = (ScoreFinal[0] + ScoreFinal[1]);
		}
		
		//the array of averages at index j, is assigned the sum of all the added up scores divided by the number of matches in a given Tournament, namely 15 
		averages [j] = (TotalScores[j][0] + TotalScores[j][1]+TotalScores[j][2] + TotalScores[j][3]+TotalScores[j][4] + TotalScores[j][5]
				+TotalScores[j][6] + TotalScores[j][7]+TotalScores[j][8] + TotalScores[j][9]+TotalScores[j][10] + TotalScores[j][11]+
				TotalScores[j][12] + TotalScores[j][13]+TotalScores[j][14])/15.0;
		
		//this average of averages is meant to take all the averages of the scores and make a sum of them to be divided by the number of tournaments 
		//however this too is a logical error...
		 averageofaverages = ((averages[0]+averages[1]+averages[2]+averages[3]+averages[4]+averages[5]+averages[6]+averages[7]+averages[8]+averages[9]+
				 averages[10]+averages[11]+averages[12]+averages[13]+averages[14]+averages[15]+averages[16]+averages[17]+averages[18]+averages[19]+averages[20])/j);
		
		 //here is where the program ought to count the number of matches scores bigger than the average but seems to give logical error instead
		if (TotalScores [j][i]>averageofaverages) {
			count++;
			}
	}
	
	//prints out the winner at index 0 if his score is bigger, along with all the goals, averages, averages of averages and matches over the average goals scored
	if (ScoreFinal[0] > ScoreFinal[1]) {
		System.out.print("\nTournament: " +j+" The WINNER is: " + FinalTeams[0]+"\n");
		
		System.out.print("\n[Tournament "+j+"] Total Goals: ["+TotalScores[j][0]+", "+TotalScores[j][1]+", "+TotalScores[j][2]+", "+TotalScores[j][3]
				+", "+TotalScores[j][4]+", "+TotalScores[j][5]+", "+TotalScores[j][6]+", "+TotalScores[j][7]+", "+TotalScores[j][8]+", "+TotalScores[j][9]+
				", "+TotalScores[j][10]+", "+TotalScores[j][11]+", "+TotalScores[j][12]+", "+TotalScores[j][13]+", "+TotalScores[j][14]+"] [Average: "+averages[j]+"]\n");
		
		System.out.print("Average goals for "+(j+1)+" tournament(s): "+averageofaverages);
		
		System.out.print("\nTotal matches in all tournaments over the average goal value: "+count+"\n");
	}
	//prints out the winner at index 1 if his score is bigger, along with all the goals, averages, averages of averages and matches over the average goals scored
	else if (ScoreFinal[1] > ScoreFinal[0]) {
		System.out.print("\nTournament: " +j+" The WINNER is: " + FinalTeams[1]+"\n");
		
		System.out.print("\n[Tournament "+j+"] Total Goals: ["+TotalScores[j][0]+", "+TotalScores[j][1]+", "+TotalScores[j][2]+", "+TotalScores[j][3]
				+", "+TotalScores[j][4]+", "+TotalScores[j][5]+", "+TotalScores[j][6]+", "+TotalScores[j][7]+", "+TotalScores[j][8]+", "+TotalScores[j][9]+
				", "+TotalScores[j][10]+", "+TotalScores[j][11]+", "+TotalScores[j][12]+", "+TotalScores[j][13]+", "+TotalScores[j][14]+"] [Average: "+averages[j]+"]\n");
		
		System.out.print("Average goals for "+(j+1)+" tournament(s): "+averageofaverages);
		
		System.out.print("\nTotal matches in all tournaments over the average goal value: "+count+"\n");
		}
	//if the team picked by the user is at index 0 and has a bigger score then it prints the number of tournaments and the team at that index
	if (userChoice.equalsIgnoreCase(FinalTeams[0]) && ScoreFinal[0] > ScoreFinal[1]) {
		System.out.print("\n It took"+" "+(j+1)+" "+"tournament(s) of the game for "+FinalTeams[0]+" to win!!!");
		break;
		}
	//if the team picked by the user is at index 1, same as previous comment
	else if (userChoice.equalsIgnoreCase(FinalTeams[1]) && ScoreFinal[1] > ScoreFinal[0]) {
		System.out.print("\n It took"+" "+(j+1)+" "+"tournament(s) of the game for "+FinalTeams[1]+" to win!!!");
		break;
		}
	//
	else if (j == 20) {
		System.out.print("\n Sorry, "+userChoice+" didn't win in 20 tournaments!");
		
		}
	
	}
		System.out.println("\nThanks for trying out this game!");
	}
}
				
		
		

	


