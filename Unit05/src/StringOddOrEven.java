//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;
	private boolean decision;
	public StringOddOrEven()
	{
		word = "";
	}

	public StringOddOrEven(String s)
	{
		word = s;
	}

	public void setString(String s)
	{
		word = s;
	}

 	public boolean isEven()
 	{
 		if (word.length() % 2 == 0) {
 			decision = true;
 			return true;
 		}
 		else { 
 			decision = false;
 			return false;
 		}
	}

 	public String toString()
 	{
 		String output = "error";
 		if (decision == true)
 			output="even";
 		else
 			output="odd";
 		return output;
	}
}