//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		int checkNum;
		String checkType;
		Scanner keyboard = new Scanner(System.in);
		
		out.println("5 is odd :: " + NumberVerify.isOdd(5));
		out.println("5 is even :: " + NumberVerify.isEven(5));
		out.println("12 is odd :: " + NumberVerify.isOdd(12));
		out.println("12 is even :: " + NumberVerify.isEven(12));
		
		out.printf("Enter an integer :: ");
		checkNum = keyboard.nextInt();
		
		out.printf("Is this odd or even? :: ");
		checkType = keyboard.next();
		keyboard.close();
		NumberVerify.checkEvenOdd(checkType, checkNum);
		
		
		//add in more test cases
	}
}