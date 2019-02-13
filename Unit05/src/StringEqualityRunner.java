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
		StringEquality s = new StringEquality();
		s.setWords("three", "htree");
		out.println(s.toString(s.checkEquality()));
		
		s.setWords("dog", "cat");
		out.println(s.toString(s.checkEquality()));
		
		s.setWords("one", "one");
		out.println(s.toString(s.checkEquality()));
		
		Scanner keyboard = new Scanner(in);
		out.printf("String one :: ");
		String stringOne = keyboard.next();
		
		out.printf("String two :: ");
		String stringTwo = keyboard.next();
		
		s.setWords(stringOne, stringTwo);
		out.println(s.toString(s.checkEquality()));
		
	}
}