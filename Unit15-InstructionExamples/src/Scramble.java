import java.util.List;
import java.util.ArrayList;

public class Scramble{
	private static List<String> wordList = new ArrayList<String>();
	public static String scrambleWord(String word) {
		String[] characters = new String[word.length()];
		for (int i = 0; i < word.length(); i++) {
			characters[i] = word.substring(i, i+1);
		}
		for (int n = 0; n < characters.length-1; n++) {
			if (characters[n].equals("A") && !(characters[n+1].equals("A"))) {
				characters[n] = characters[n+1];
				characters[n+1] = "A";
				n++;
			}
		}
		String out = "";
		for (String s : characters)
			out+= s;
		return out;
	}
	
	public static void scrambleOrRemove(List<String> wordList) {
		int count = 0;
		for (String s : wordList) {
			if(scrambleWord(s).equals(s)) {
				wordList.remove(count);
				count--;
			}
			else {
				wordList.set(count, scrambleWord(s));
			}
			count++;
		}
	}
	public static void main(String[] args) {
		wordList.add("AARDVARK");
		wordList.add("TAN");
		wordList.add("EGGS");
		wordList.add("APPLE");
		
		scrambleOrRemove(wordList);
		for (String s : wordList) {
			System.out.print(s + " ");
		}
	}
}