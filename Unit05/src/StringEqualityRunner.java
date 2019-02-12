//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

import java.util.Scanner;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		out.println("true".equals("true"));
		Scanner keyboard = new Scanner(in);
		out.println("String one :: ");
		String stringOne = keyboard.next();
		
		out.println("String two :: ");
		String stringTwo = keyboard.next();
		
		StringEquality s = new StringEquality();
		s.setWords(stringOne, stringTwo);
		s.toString(s.checkEquality());
		
	}
}