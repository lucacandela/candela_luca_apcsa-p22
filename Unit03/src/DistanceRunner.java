//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;
 
public class DistanceRunner
{	
	static Scanner keyboard = new Scanner(System.in);
	public static void main( String[] args )
	{
			int x1, y1, x2, y2;
			System.out.printf("Enter X1 :: ");
			x1 = keyboard.nextInt();
			System.out.printf("Enter Y1 :: ");
			y1 = keyboard.nextInt();
			System.out.printf("Enter X2 :: ");
			x2 = keyboard.nextInt();
			System.out.printf("Enter y2 :: ");
			y2 = keyboard.nextInt();
			
			Distance line = new Distance(x1,y1,x2,y2);
			line.calcDistance();
			line.print();
	}
}