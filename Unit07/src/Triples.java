//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		setNum(0);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		if (a ==0)
			return 0;
		int limit;
		limit = Math.min(a, b);
	    limit = Math.min(limit, c);
	    for(int n = limit; n >= 2; n--)
	    {
	        if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
	            return n;
	        }
	    }

	    return 1;
	}

	public String toString()
	{
		String output="";
		for (int x = 0; x < number; x++) {
			for (int y = 0; y < number; y++) {
				for(int z = 0; z< number; z++) {
					int a=x, b=y, c=z;
					
					if((((Math.pow(a, 2)) + Math.pow(b, 2) == Math.pow(c, 2)) && greatestCommonFactor(a,b,c) == 1)) {
						if (a < b)
						{
							if (((a % 2 == 0 && b % 2 == 1) || (a % 2 == 1 && b % 2 ==0) ) && c % 2 == 1) {
								output+= a + " " + b + " " + c + "\n";
							}
							
						}
					}
				}
			}
		}





		return output+"\n";
	}
}