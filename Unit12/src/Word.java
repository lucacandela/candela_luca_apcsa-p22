//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{	
		String other = (String)rhs.word;
		
		if (word.length() > other.length()) {
			return 1;
		}
		else if (word.length()<other.length()) {
			return -1;
		}
		else if (word.length() == other.length()) {
			if (word.charAt(0) > other.charAt(0)) {
				return 1;
			}
			else
				return -1;
		}
		return 0;
	}
	
	public String toString()
	{
		return word;
	}
}