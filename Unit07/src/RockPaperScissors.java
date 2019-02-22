//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;
	private int randChoice;
	private String winner;
	public RockPaperScissors()
	{
		setPlayers("");
		winner="";
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
		determineWinner();
	}

	public void setPlayers(String player)
	{
		playChoice = player;
		
		randChoice = ((int)(Math.random()*3)+ 1);
		if (randChoice ==1) {
			compChoice="R";
		}
		else if (randChoice == 2) {
			compChoice="P";
		}
		else if (randChoice == 3) {
			compChoice="S";
		}
		else
			compChoice = "nothing";
		winner = determineWinner();
	}

	public String determineWinner()
	{
		String winner="";
		if (playChoice.equalsIgnoreCase(compChoice))
			winner = "!Draw Game!";
		else if (playChoice.equalsIgnoreCase("R") && compChoice.equalsIgnoreCase("S"))
			winner = "!Player wins <<Rock Breaks Scissors>>!";
		else if(playChoice.equalsIgnoreCase("S") && compChoice.equalsIgnoreCase("R"))
			winner = "!Computer wins <<Rock Breaks Scissors>>!";
		else if (playChoice.equalsIgnoreCase("R") && compChoice.equalsIgnoreCase("P"))
			winner = "!Computer wins <<Paper Covers Rock>>!";
		else if (playChoice.equalsIgnoreCase("P") && compChoice.equalsIgnoreCase("R"))
			winner = "!Player wins <<Paper Covers Rock>>!";
		else if (playChoice.equalsIgnoreCase("P") && compChoice.equalsIgnoreCase("S"))
			winner = "!Computer wins <<Scissors Cuts Paper>>!";
		else if (playChoice.equalsIgnoreCase("S") && compChoice.equalsIgnoreCase("P"))
			winner = "!Player wins <<Scissors Cuts Paper>>";
		return winner;
	}

	public String toString()
	{
		return winner;
	}
}