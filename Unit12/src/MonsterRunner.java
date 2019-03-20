//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		String name; String type = ""; int size;
		Monster one, two;
		String count;
		
		
		System.out.print("Enter monster type (Skeleton/Werewolf) : ");
		type = keyboard.next();
		while (!(type.toLowerCase().equals("skeleton") || type.toLowerCase().equals("werewolf"))) {
			System.out.print("Did not choose proper monster type. Try again : ");
			type = keyboard.next();
		}
		
		System.out.print("Enter 1st "+ type + "'s name : ");
		name = keyboard.next();
		
		System.out.print("Enter 1st "+ type +"'s size : ");
		size = keyboard.nextInt();
		
		if (type.toLowerCase().equals("werewolf"))
			one = new Werewolf(name,size);
		else
			one= new Skeleton(name, size);
		
		System.out.print("Enter monster type (Skeleton/Werewolf) : ");
		type = keyboard.next();
		while (!(type.toLowerCase().equals("skeleton") || type.toLowerCase().equals("werewolf"))) {
			System.out.print("Did not choose proper monster type. Try again : ");
			type = keyboard.next();
		}
		
		if(type.toLowerCase().equals(one.getClass().getName().toLowerCase())) //Determine if the two monster types are the same
			count = "2nd";
		else
			count = "1st";
			
		System.out.print("Enter " + count + " " + type + "'s name : ");
		name = keyboard.next();
		
		System.out.print("Enter " + count + " " + type + "'s size : ");
		size = keyboard.nextInt();
		
		if (type.toLowerCase().equals("werewolf"))
			two = new Werewolf(name,size);
		else
			two = new Skeleton(name, size);
		
		System.out.println();
		System.out.println(one.getClass().getName()+ " 1 - " + one);
		System.out.println(two.getClass().getName() + " 2 - " + two);
		System.out.println();
		
		if (one.isSmaller(two)) {
			System.out.println(one.getClass().getName() + " 1 is smaller than " + two.getClass().getName() + " 2");
		}
		else if(one.isBigger(two))
			System.out.println(one.getClass().getName() + " 1 is bigger than " + two.getClass().getName() +  " 2");
		else
			System.out.println(one.getClass().getName() + " 1 is the same size as " + two.getClass().getName() + " 2");
		if(one.namesTheSame(two)) {
			System.out.println(one.getClass().getName() + " has the same name as " + two.getClass().getName() + " 2");
		}
		
		//instantiate monster one
		
		//ask for name and size
		
		//instantiate monster two
	}
}