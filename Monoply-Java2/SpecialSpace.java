
/**
 * @author Arvin
 */
public class SpecialSpace extends Spaces {

	private int special;
	private int cost;
	
	public SpecialSpace(String name, int price, int rent, boolean isSellable, Player owner, int special, int cost) {
		super(name, price, rent, false, null);
		this.special = special;
		this.cost = cost;
	}
	
	/*
	 * Special Case 0 = GoSquare
	 * Special Case 1 = Income Tax
	 * Special Case 2 = Free Parking
	 * Special Case 3 = Go To Jail
	 * Special Case 4 = Luxury Tax
	 * Special Case 5 = Move to Square
	 */
	public void action(Player player) {
		if (special == 0)
			player.deposit(cost);
		
		else if (special == 1)
			player.withdraw(cost);
		
		else if (special == 2);
	
		else if (special == 3) {
			player.arrest();
			player.newPosition(cost); }
	
		else if (special == 4)
			player.withdraw(cost);
		
		else if (special == 5)
			player.newPosition(cost);
		}
	public void updateRent() {}
	
	public Player getOwner() {
		return null; 
		}
	
	public void newOwner(Player player) {
		player = null;
	}
	
	public void removeEverything() {}
	
	public boolean changeHouses(int add) {
    	return false;
    }
	
	public boolean changeHotels() {
		return false;
	}
	
	public String toString() {
		return "Special Space\n Square name: " + name + "\n Space cost: " + cost + "\n";  
			
	}
}
