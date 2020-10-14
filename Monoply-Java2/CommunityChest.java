
/**
 * @author Arvin
 */
public class CommunityChest extends Spaces {
	
	private Deck deck;
	
	public CommunityChest(String name, int price, int rent, boolean isSellable, Player owner, Deck deck) {
		super(name, price, rent, false, null);
		this.deck = deck;
 }
	public void removeEverything() {}
	
	public void updateRent() {}
	
	public void action(Player player) {
		Cards card = deck.getCard();
		System.out.println(card.toString());
		if (card.getCondition() == 0) {
			player.hasGetOut(true);
		}
		else if (card.getCondition() == 1) {
			player.payment(50, null);
		}
		else if (card.getCondition() == 2) {
			player.deposit(30);
		}
		else if (card.getCondition() == 3) {
			player.deposit(100);
		}
		else if (card.getCondition() == 4) {
			player.deposit(150);
		}
		else if (card.getCondition() == 5) {
			player.payment(100, null);
		}
		else if (card.getCondition() == 6) {
			player.deposit(75);
		}
		else if (card.getCondition() == 7) {
			player.payment(200, null);
		}
		else if (card.getCondition() == 8) {
			player.payment(50, null);
		}
		else if (card.getCondition() == 9) {
			player.deposit(100);
		}
		else if (card.getCondition() == 10) {
			player.deposit(100);
		}
		else if (card.getCondition() == 11) {
			player.payment(100, null);
		}
		else if (card.getCondition() == 12) {
			player.deposit(200);
		}
		else if (card.getCondition() == 13) {
			player.payment(150, null);
		}
		else if (card.getCondition() == 14) {
			player.payment(50, null);
		}
		else if (card.getCondition() == 15) {
			player.deposit(100);
		}
	}
	
	public boolean changeHouses(int add) {
    	return false;
    }
	
	public boolean changeHotels() {
		return false;
	}
	
	public String toString() {
		String string = "Community Chest";
		return string;
	}
}
