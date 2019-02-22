//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter('a');
		setAmount('4');
		
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		int count = 0;
		char character = letter;
		
		for(int a = 0; a < amount; a++){
			for (int i = 0; i< amount; i++) {
				for (int x = 0; x< amount-count; x++) {
					output+= (character);
				}
				output+=" ";
				
				if (character == 'Z')
					character = 'A';
				else if (character == 'z')
					character = 'a';
				else
					character++;
				count ++;
			}
			output+="\n";
		}
		
		return output;
	}
}