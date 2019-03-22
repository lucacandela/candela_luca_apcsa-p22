import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if ((containsPairSum11(selectedCards) || containsJQK(selectedCards)) && (!(selectedCards.size() > 3))) {
			return true;
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> n = cardIndexes();
		List<Integer> cardVals = new ArrayList<>();
		for (int i = 0; i< n.size()-1; i++) {
			cardVals.add(cardAt(n.get(i)).pointValue());
		}
		if (containsPairSum11(n) || containsJQK(n) ){
			return true;
		}
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		int count = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			for (int x = 0; x < selectedCards.size(); x++){
				if(!(i == x)) {
					count = cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(x)).pointValue();
					if (count == 11) {
						return true;
					}
				}
			}
			
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		int count = 0;
		int jCount =0, qCount=0, kCount=0;
		Card c;
		for(int i = 0; i < selectedCards.size(); i++) {
			c = cardAt(selectedCards.get(i));
			if (c.pointValue() == 0)
				count +=1;
			if (c.rank().equals("jack") && !(jCount == 1))
				jCount++;
			if (c.rank().equals("king") && !(kCount == 1))
				kCount++;
			if (c.rank().equals("queen") && !(qCount == 1))
				qCount++;
			if (count == 3 && jCount == 1 && kCount == 1 && qCount == 1)
				return true;
		}
		
		return false;
	}
}