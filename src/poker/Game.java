package poker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game 
{
	static List<Player> listPlayer = new ArrayList<Player>();
	public static void main(String[] args) 
	{
		
		
		// *************  Entering players name  *************
		Scanner sc= new Scanner(System.in);
		String input;
		
		
		System.out.println("Player 1: Enter your name:  ");
		input=sc.nextLine();
		listPlayer.add(new Player(input));
		System.out.println("Player 2: Enter your name:  ");
		input=sc.nextLine();
		listPlayer.add(new Player(input));
		
			
			
		
		
		// *************  Play  *************
		
		for(int i=0;i<12;i++)
		{
			int c=1;
			for(Player p:listPlayer)
			{
				p.play();
				Result.verifyComb(p,c);
				c++;
			}
			c=0;
			
			
		}
		
		// *************  Results  *************
		
		
		listPlayer.get(0).score=Result.score(1);
		listPlayer.get(1).score=Result.score(2);
		
		if(listPlayer.get(0).score>listPlayer.get(1).score)
		{
			System.out.println("The winner is: "+ listPlayer.get(0).pseudo+"\n With a score of: "+ listPlayer.get(0).score +" against: "+ listPlayer.get(1).score);
			
		}
		else if(listPlayer.get(0).score>listPlayer.get(1).score)
		{
			System.out.println("This is an equality with a score of:  "+ listPlayer.get(0).score);
			
		}
		else
		{
			System.out.println("The winner is: "+ listPlayer.get(1).pseudo+"\n With a score of: "+ listPlayer.get(1).score +" against: "+ listPlayer.get(0).score);
		}
		
		
		
		

	}
	

}
