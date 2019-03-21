//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));
		
		int size = file.nextInt();
		file.nextLine();
		
		Word w;
		
		Comparable[] list = new Comparable[size];
		for (int i = 0; i < size; i++) {
			if (file.hasNextLine()) {
				w = new Word(file.next());
				
				list[i] = w;
			}
		
		}
		Arrays.sort(list);
		
		for (int i = 0; i < size; i++) {
			System.out.println(list[i]);
		}
	}
}