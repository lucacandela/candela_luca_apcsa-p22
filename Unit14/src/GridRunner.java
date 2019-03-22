//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		Grid g = new Grid(20,20,new String[] {"a","b","c","7","9","x","2"});
		
	
		
		System.out.println(g);
		
		System.out.println("--debugging code to help see if algorithm is working-");
		System.out.println("--these println statements can be added to the max method\n");
		System.out.print(g.findMax(g.values()));
	}
}