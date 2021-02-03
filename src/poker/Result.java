package poker;

import java.util.Scanner;

public class Result 
{
	private static String[][] score = {{"Ones","0","0"},{"Twos","0","0"},{"Threes","0","0"},{"Fours","0","0"},{"Fives","0","0"},{"Sixes","0","0"},{"Three of a kind","0","0"},{"Four of a kind","0","0"},{"Full house","0","0"},{"Small straight","0","0"},{"Large Straight","0","0"},{"Yahtzee","0","0"}};
	private static String[][] finalScore = {{"Ones","0","0", null, null},{"Twos","0","0", null, null},{"Threes","0","0",null,null},{"Fours","0","0",null,null},{"Fives","0","0",null,null},{"Sixes","0","0",null,null},{"Three of a kind","0","0",null,null},{"Four of a kind","0","0",null,null},{"Full house","0","0",null,null},{"Small straight","0","0",null,null},{"Large Straight","0","0",null,null},{"Yahtzee","0","0",null,null}};
	
	public static boolean compareArray(int[] a, int[] b)
	{
		if(a.length!=b.length)
			return false;
		int length=a.length;
		for(int i=0;i<length;i++)
		{
			if((a[i]==0 && b[i]>0) || (a[i]>0 && b[i]==0))
				return false;
			
		}
		return true;
	}
	public static boolean hasSmallStraight(int[] tab)
	{
		int[] comb1={0,1,1,1,1,0};
		int[] comb2={0,0,1,1,1,1};
		int[] comb3={1,1,1,1,0,0};
		if(compareArray(comb1,tab) || compareArray(comb2,tab) || compareArray(comb3,tab))
		{
			return true;
		}
		return false;
			
	}
	
	public static boolean hasLargeStraight(int[] tab)
	{
		int[] comb1={0,1,1,1,1,1};
		int[] comb2={1,1,1,1,1,0};
		
		if(compareArray(comb1,tab) || compareArray(comb2,tab))
		{
			return true;
		}
		return false;
			
	}
	
	public static int sumOfHand(int[] sum)
	{
		int a = 0;
		for(int i=0;i<sum.length;i++)
		{
			a+=(i+1)*sum[i];
		}
		return a;
		
	}
	
	public static int score(int n)
	{
		int score=0;
		for(int i=0;i<finalScore.length;i++)
		{
			
			score+=Integer.parseInt(finalScore[i][n]);	

		}
		return score;
	}
	
	static void restoreScore()
	{
		score[0][1]=score[0][2]= score[1][1]=score[1][2]= score[2][1]=score[2][2]=score[3][1]=score[3][2]= score[4][1]=score[4][2]= score[5][1]=score[5][2]= score[6][1]=score[6][2]= score[7][1]=score[7][2]= score[8][1]=score[8][2]=score[9][1]=score[9][2]= score[10][1]=score[10][2]= score[11][1]=score[11][2]="0";
	}
	
	public static void displayScore(String[][] score)
	{
		System.out.printf(" 1. %s %s %s \n 2. %s %s %s \n 3. %s %s %s \n 4. %s %s %s \n 5. %s %s %s \n 6. %s %s %s \n 7. %s %s %s \n 8. %s %s %s \n 9. %s %s %s \n10. %s %s %s \n11. %s %s %s \n12. %s %s %s \n", score[0][0],score[0][1],score[0][2], score[1][0],score[1][1],score[1][2], score[2][0],score[2][1],score[2][2], score[3][0],score[3][1],score[3][2], score[4][0],score[4][1],score[4][2], score[5][0],score[5][1],score[5][2], score[6][0],score[6][1],score[6][2], score[7][0],score[7][1],score[7][2], score[8][0],score[8][1],score[8][2], score[9][0],score[9][1],score[9][2], score[10][0],score[10][1],score[10][2], score[11][0],score[11][1],score[11][2]);
	}
	
	
	public static void verifyComb(Player p, int n)
	{
		int[] numberOf= {0,0,0,0,0,0};
		
		for(int i=1;i<=p.hand.size();i++) 
		{
			 Dice dice = p.hand.get(i);
			 switch(dice.diceResult)
			    {
			    case 1:
			    	numberOf[0]++;
			    	break;
			    case 2:
			    	numberOf[1]++;
			    	break;
			    case 3:
			    	numberOf[2]++;
			    	break;
			    case 4:
			    	numberOf[3]++;
			    	break;
			    case 5:
			    	numberOf[4]++;
			    	break;
			    case 6:
			    	numberOf[5]++;
			    	break;
			    default:
			    	break;
			    }
			
		}
		 System.out.println(numberOf[0] +"  " + numberOf[1]+"   " +numberOf[2]+"    "+numberOf[3]+"   "+numberOf[4]+"   "+numberOf[5] );
		for(int i=0;i<6;i++)
		{
			score[i][n]= "" +(numberOf[i]*(i+1));
			if(numberOf[i]==3)
			{
				score[6][n]=""+sumOfHand(numberOf);
				for (int j=0;j<6;j++)
				{
					if(j!=i && numberOf[j]==2)
						score[8][n]="30";
				}
			}
			else if(numberOf[i]==4)
			{
				score[7][n]=""+sumOfHand(numberOf);
			}
			else if(numberOf[i]==5)
			{
				score[11][n]="50";
			}
			
		}
		if(hasSmallStraight(numberOf))
		{
			score[9][n]="30";
		}
		
		if(hasLargeStraight(numberOf))
		{
			score[10][n]="40";
		}
		
		displayScore(score);
		int combSaved = 20;
		do
		{
			System.out.println("\n Enter the line number of the combination you want to keep: \n");
			Scanner myObj = new Scanner(System.in); 
			combSaved = myObj.nextInt();
		}while(combSaved>12 || combSaved <=0 || finalScore[combSaved-1][n+2]!=null );
		finalScore[combSaved-1][n+2]="this combination has been saved !";
		finalScore[combSaved-1][n]=score[combSaved-1][n];
		restoreScore();
		displayScore(finalScore);
		
	}
	
}
