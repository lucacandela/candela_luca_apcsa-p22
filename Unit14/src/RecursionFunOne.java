//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.List;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
		int remainingDigits = 1;
		String str = "" + num;
		if(num>0) {
			int lastDigit = num % 10;
			if (str.length() > 1) {
				remainingDigits = Integer.parseInt(str.substring(0, str.length()-1));
			}
			else {
				remainingDigits = 0;
			}
			if (lastDigit % 2 == 0) {
				return 1 + countOddDigits(remainingDigits);
			}
			return 0 + countOddDigits(remainingDigits);
		}
		return 0;

	}
}