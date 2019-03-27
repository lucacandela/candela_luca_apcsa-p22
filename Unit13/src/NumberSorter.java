//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	
	private static List<Integer> separateDigits(int number) {
		List<Integer> n = new ArrayList<Integer>();
		int result;
		while(!(number == 0)) {
			result = number % 10;
			number = number /10;
			n.add(result);
		}
		return n;
	}
	private static int getNumDigits(int number)
	{
		int size = separateDigits(number).size();
		return size;
	}
	
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		List<Integer> n = separateDigits(number);
		int count = 0;
		for(Integer x : n) {
			sorted[count] = x;
			count++;
		}
		int placeHolder = 0;
		for(int i = 0; i < sorted.length-1; i++) {
			for(int x = 0; x < sorted.length-1; x++) {
				if(sorted[x] > sorted[x+1]){
					placeHolder = sorted[x+1];
					sorted[x+1] = sorted[x];
					sorted[x] = placeHolder;
					}
			}
		}
		return sorted;
	}
}