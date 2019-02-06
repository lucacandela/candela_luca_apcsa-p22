//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -  
//Class -
//Lab  -

import static java.lang.System.*;

public class NumberVerify
{
	
	public static boolean isOdd( int num )
	{
		return num % 2 !=0;
	}
	public static boolean isEven( int num )
	{
		return !isOdd(num);
	}	
	
	public static void checkEvenOdd(String type, int num){
		if (type.compareToIgnoreCase("even") == 0) {
			out.println(NumberVerify.isEven(num));
		}
		else if (type.compareToIgnoreCase("odd") == 0) {
			out.println(NumberVerify.isOdd(num));
		}
		else
		{
			out.println("error");
		}
	}
}