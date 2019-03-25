//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RecursionFunThree
{
	/* luckyThrees will return the count of 3s in the number
	 * unless the 3 is at the front and then it does not count
	 * 3 would return 0
	 * 31332  would return 2
	 * 134523 would return 2
	 * 3113  would return 1
	 * 13331 would return 3
	 * 777337777  would return 2
	 * the solution to this problem must use recursion
	 */
	public static int luckyThrees( long number )
	{
		long remainingDigits = 0;
		long lastDigit = number % 10;
		if (number > 0) {
			String str = "" + number;
			if(str.length() > 1){
				remainingDigits = (long)Integer.parseInt(str.substring(0,str.length()-1));
			}
			else {
				remainingDigits = 0;
			}
			if (lastDigit == 3 && remainingDigits > 0) {
				return 1 + luckyThrees(remainingDigits);
			}
			else {
				return 0 + luckyThrees(remainingDigits);
			}
		}
		return 0;
	}
}