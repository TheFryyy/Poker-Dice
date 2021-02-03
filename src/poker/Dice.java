package poker;
import java.util.Random;

public class Dice 
{
	Random rd = new Random();
	int diceResult;
	boolean isSaved=false;	
	
	void roll()
	{	
		if(!isSaved)
		{
			diceResult= rd.nextInt(6)+1;
		}
					
	}
	

}
