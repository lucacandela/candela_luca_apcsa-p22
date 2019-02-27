//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int firstOdd = 0; int firstEven = 1;
		int firstIndex = 0; int secondIndex = 0;
		
		for (int i = 0; i < ray.length-1; i++) {
			if (ray[i] % 2 == 1) {
				firstOdd = ray[i];
				firstIndex = i;
				break;
			}
				
		}
		for (int i = firstIndex; i < ray.length-1; i++) {
			if (ray[i] % 2 == 0) {
				firstEven = ray[i];
				secondIndex = i;
				break;
			}
		}
		if (firstOdd == 0 || (!(firstOdd == 0) && firstEven ==1)) {
			return -1;
		}
		else
			return secondIndex - firstIndex;
	}
}