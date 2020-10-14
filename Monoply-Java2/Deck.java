import java.util.ArrayList;

/**
 * @author Arvin
 */
public class Deck {

	private ArrayList<Cards> deck = new ArrayList<Cards>();
	public Deck() {
		deck.add(new Cards(0, 0, "Get Out Of Jail Free"));
		deck.add(new Cards(1, 50, "You had to visit the doctor, pay $50"));
		deck.add(new Cards(2, 30, "Collect 30$ for service to the community"));
		deck.add(new Cards(3, 100, "Christmas came early, collect $100"));
		deck.add(new Cards(4, 150, "Bank Error, Collect $150!"));
		deck.add(new Cards(5, 100, "You went to summer school, pay $100 "));
		deck.add(new Cards(6, 75, "Collect $75 For Free!"));
		deck.add(new Cards(7, 200, "You Went to FBLA Nationals. Pay $200 for Flight Tickets"));
		deck.add(new Cards(8, 50, "Pay $50 in Taxes to the State"));
		deck.add(new Cards(9, 100, "You Won the Race! Collect $100."));
		deck.add(new Cards(10, 100, "Duval Street Proved Fruitful. Collect $100"));
		deck.add(new Cards(11, 100, "Mr.Hatcher Got Angry At You. Pay Him $100"));
		deck.add(new Cards(12, 200, "You Won Big Time! Collect $200!"));
		deck.add(new Cards(13, 150, "You Failed to Pay Taxes on Time. Pay An Extra $150"));
		deck.add(new Cards(14, 50, "Mr.Hatcher Needs Some Money. Pay $50"));
		deck.add(new Cards(15, 100, "You Just Closed On A House Deal. Collect $100."));
	}
	
	public Cards getCard() {
		Cards card = deck.get(0);
		deck.add(deck.remove(0));
		return card;
	}
	
	public String toString() {
		return deck.get(0).toString();
	}
}
