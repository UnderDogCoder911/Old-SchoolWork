import java.util.Random;
public class tryingstufflol {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		//String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium",
				//"Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", 
				//"Colombia","England"};
				
				
		
		
		//String[] QuarterFinalsTeams = new String [8];
	

	
		
		for (int j = 0; j <=20; j++) {
			
			int[] ScoreRound16 = {rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5)};
			
			int[] ScoreQuarterFinals = {rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),
					rand.nextInt(5),rand.nextInt(5)};
			int[] ScoreSemiFinals={rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5)};
			int[] ScoreFinal={rand.nextInt(5),rand.nextInt(5)};
		
			
			
			double[][] TotalScores = {{(ScoreRound16[0] + ScoreRound16[1]), (ScoreRound16[2] + ScoreRound16[3]), (ScoreRound16[4] + ScoreRound16[5]), (ScoreRound16[6] + ScoreRound16[7]),
				(ScoreRound16[8] + ScoreRound16[9]), (ScoreRound16[10] + ScoreRound16[11]), (ScoreRound16[12] + ScoreRound16[13]), (ScoreRound16[14] + ScoreRound16[15]),(ScoreQuarterFinals[0] + ScoreQuarterFinals[1]),
				(ScoreQuarterFinals[2] + ScoreQuarterFinals[3]), (ScoreQuarterFinals[4] + ScoreQuarterFinals[5]), (ScoreQuarterFinals[6] + ScoreQuarterFinals[7]), (ScoreSemiFinals[0] + ScoreSemiFinals[1]), (ScoreSemiFinals[2] + ScoreSemiFinals[3]),
				(ScoreFinal[0] + ScoreFinal[1])}};
		
			System.out.println(TotalScores[0][0]+" "+TotalScores[0][1]+" "+TotalScores[0][2]+" "+TotalScores[0][3]+" "+TotalScores[0][4]+" "+TotalScores[0][5]+" "+TotalScores[0][6]+" "+TotalScores[0][7]+
				" "+TotalScores[0][8]+" "+TotalScores[0][9]+" "+TotalScores[0][10]+" "+TotalScores[0][11]+" "+TotalScores[0][12]+" "+TotalScores[0][13]+" "+TotalScores[0][14]);
		
			 double average = ((TotalScores[0][0] + TotalScores[0][1]+TotalScores[0][2]+TotalScores[0][3]+TotalScores[0][4]+TotalScores[0][5]+TotalScores[0][6]+TotalScores[0][7]+
					 TotalScores[0][8]+TotalScores[0][9]+TotalScores[0][10]+TotalScores[0][11]+TotalScores[0][12]+TotalScores[0][13]+TotalScores[0][14])/15);
			 System.out.println(average);
			 
		}
			}
	
			
		
		}
		
		

	


