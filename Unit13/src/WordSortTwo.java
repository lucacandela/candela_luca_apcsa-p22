//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
		sort();
	}

	public void sort()
	{
		List<String> s;
		String[] sorted = new String[wordRay.length];
		String temp = wordRay[0];
		int count = -1;
		for (int x = 0; x < wordRay.length; x++) {
			for(int i = 0; i < wordRay.length; i++) {
				if (wordRay[x].charAt(0) < wordRay[i].charAt(0)) {
					temp = wordRay[x];
					wordRay[x] = wordRay[i]; 
					wordRay[i] = temp;
				}
			}
			temp = null;
		}
	}

	public String toString()
	{
		String output="";
		for(int i = 0; i < wordRay.length; i ++){
			output += wordRay[i] + "\n";
		}
		return output+"\n\n";
	}
}