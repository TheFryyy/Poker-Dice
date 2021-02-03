package poker;
import java.util.Scanner;
import java.util.HashMap;

public class Player 
{
	String pseudo;
	HashMap<Integer,Dice> hand = new HashMap<Integer,Dice>();
	int score;
	
	Player(String p)
	{
		score=0;
		pseudo=p;
		hand.put(1, new Dice());
		hand.put(2, new Dice());
		hand.put(3, new Dice());
		hand.put(4, new Dice());
		hand.put(5, new Dice());
	}
	
	
	boolean isADiceNotSaved()
	{
		return (hand.get(1).isSaved==false || hand.get(2).isSaved==false || hand.get(3).isSaved==false || hand.get(4).isSaved==false || hand.get(5).isSaved==false);
	}
	
	
	void unsaveDice()
	{
		hand.get(1).isSaved=hand.get(2).isSaved=hand.get(3).isSaved=hand.get(4).isSaved=hand.get(5).isSaved=false;
		
	}
	
	void play()
	{
		
		System.out.println(this.pseudo+ " : it's your turn !");
	
		int diceSaved; // Variable which store the value entered by the player
		int numberOfRoll=2;
		String handDisplay="Your hand:    ";
		
		Scanner myObj = new Scanner(System.in); 
		
		
		// The first roll is done by default and displayed 
		for(int i=1;i!=6;i++) 
		{
			hand.get(i).roll();
			handDisplay+=hand.get(i).diceResult;
			handDisplay+="    ";
		}
		handDisplay+="\n";
		
		System.out.println(handDisplay);
		
		
		// Loop for each turn during which the player chose which dice he will save (stop if all dice are saved or if the player enter 0).
		do
		{
			unsaveDice(); // initialize all dice as non saved
			handDisplay="Your hand:    ";
	
			System.out.println("Which dice would you like to save ? (enter the number of the dice you want to save ot 0 if you want to roll again) ");
			
			do // Loop that take player input and save dice.
			{
				
				
				diceSaved = myObj.nextInt();
				if(diceSaved!=0 && diceSaved<6 && diceSaved>0)
				{
					hand.get(diceSaved).isSaved=true;
				}
				
			}while(diceSaved!=0 );
			
			
			for(int i=1;i!=6;i++) // Loop that roll all dice which are not saved
			{
				hand.get(i).roll();
				handDisplay+=hand.get(i).diceResult;
				handDisplay+="    ";
			}
				
				handDisplay+="    ";
			
			handDisplay+="\n";
			System.out.println(handDisplay); // Display the hand.
			
			numberOfRoll--;
			
		}while(numberOfRoll!=0  && isADiceNotSaved());
		
		unsaveDice(); // initialize all dices as non saved for next turns. (because the first roll is done by default)
	}
	
	

}
