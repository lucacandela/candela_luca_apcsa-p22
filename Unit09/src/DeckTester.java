/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck(new String[] {"A","B","C"}, new String[] {"Giraffes","Lions"}, new int[] {2,1,6});
		System.out.println("Is deck empty? :: " + deck.isEmpty());
		System.out.println("How many cards are in the deck? :: " + deck.size());
		System.out.print("Deal me five cards. :: ");
		for(int i = 0; i <= 4; i++) deck.deal();
		System.out.println(deck);
		
		System.out.print("\n\n");
		deck = new Deck(new String[] {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"}, new String[] {"Hearts","Spades","Diamonds","Clubs"}, new int[] {2,3,4,5,6,7,8,9,10,10,10,10,11});
		System.out.println("Is deck empty? :: " + deck.isEmpty());
		System.out.println("How many cards are in the deck? :: " + deck.size());
		System.out.print("Deal me five cards. :: ");
		for(int i = 0; i <= 4; i++) deck.deal();
		System.out.println(deck);
		
		System.out.print("\n\n");
		deck = new Deck(new String[] {"One","Two","Three"}, new String[] {"Apples","Bannanas"}, new int[] {1,2,3});
		System.out.println("Is deck empty? :: " + deck.isEmpty());
		System.out.println("How many cards are in the deck? :: " + deck.size());
		System.out.print("Deal me five cards. :: ");
		for(int i = 0; i <= 4; i++) deck.deal();
		System.out.println(deck);
	}
}
