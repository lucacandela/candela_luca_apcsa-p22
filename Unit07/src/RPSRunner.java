//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response = 'y';
		//add in a do while loop after you get the basics up and running
		do {	
			String player = "";
		
			out.print("Rock, Paper, or Scissors? - pick your weapon [R,P,S] :: ");
			player = keyboard.next();
			//read in the player value
			
			RockPaperScissors game = new RockPaperScissors(player);
			
		}
		while (response == 'y');
	}
}



