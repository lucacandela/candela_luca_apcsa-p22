//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=5.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist,hrs,mins);
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}

	public void calcMPH()
	{
		mph = hours * 60;
		mph += minutes;
		mph /= 60;
		mph = distance/mph;
	}

	public void print()
	{
		System.out.printf(toString());
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		return distance + " miles in " + hours + " hour and " + minutes + " minutes = " + mph + " MPH.";
	}
}