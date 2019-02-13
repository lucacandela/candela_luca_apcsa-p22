//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		StringOddOrEven s = new StringOddOrEven();
		Scanner keyboard = new Scanner(in);
		String arg;
		
		out.print("Enter a word :: ");
		arg = keyboard.next();
		s.setString(arg);
		s.isEven();
		out.println(s.toString());
		
		
		
	}
}