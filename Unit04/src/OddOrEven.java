//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class OddOrEven
{
	public static boolean isOdd( int num )
	{
		return num % 2 !=0;
	}
	public static boolean isEven( int num )
	{
		return !isOdd(num);
	}
	
	public static void main(String[] args) {
		out.println("14 is odd? :: " + isOdd(14));
		out.println("14 is even? :: " + isEven(14));
		
		out.println("86 is even? :: " + isEven(86));
		
		out.println("74 is odd? :: " + isOdd(74));
	}
}