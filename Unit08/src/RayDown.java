//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public static boolean go(int[] numArray)
	{
		int count =0;
		for (int i = numArray.length-2; i > 0; i--) {
			if (!(numArray[i] < numArray[i+1])) {
				count++;
			}
		}
		if (count == 0)
			return true;
		else
			return false;
	}	
}