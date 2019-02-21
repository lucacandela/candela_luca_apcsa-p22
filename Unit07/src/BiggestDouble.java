//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;
	private double[] list;
	public BiggestDouble()
	{
		setDoubles(0,0,0,0);
		
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a,b,c,d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
		list = new double[] {a,b,c,d};
	}

	public double getBiggest()
	{
		double largest = 0;
		for (int i = 0; i < 4; i++)
			if (list[i] > largest) {
				largest = list[i];

			}
		return largest;
	}
	
	

	public String toString()
	{
	   return one + " " + two + " " + three + " " + four;
	}
}