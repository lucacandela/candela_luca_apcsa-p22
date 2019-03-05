/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card = new Card("King","Clubs",10);
		System.out.print("Is the King of Hearts equal to " + card + "? :: ");
		System.out.println(card.matches(new Card("King","Hearts",10)));
		
		card = new Card("Queen","Diamonds",10);
		System.out.print("Is the Queen of Diamonds equal to " + card + "? :: ");
		System.out.println(card.matches(new Card("Queen","Diamonds",10)));
		
		card = new Card("6","Hearts",6);
		System.out.print("Is the Queen of Diamonds equal to " + card + "? :: ");
		System.out.println(card.matches(new Card("Queen","Diamonds",10)));
	}
}
