//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
	
	public String go(String a)
	{	
		String first,last;
		String vowels = "AEIOUaeiou";
		
		first= a.substring(0,1);
		last = a.substring(a.length()-1);
		
	   if ((vowels.indexOf(first) > -1) || (vowels.indexOf(last) > -1)){
		   return "yes";
	   }
	   return "no";
	   
	   
	}
}