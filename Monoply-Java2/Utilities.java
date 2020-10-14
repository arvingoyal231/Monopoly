
/**
 * @author Arvin
 */
public class Utilities extends Spaces {

	private Group groups;
	
	public Utilities(String name, int price, int rent, boolean isSellable, Player owner, Group group) {
		super(name, price, rent, true, null);
		this.groups = group;
	}
	
	public void removeEverything() {}
	
	public void action(Player player) {
		if (player != owner)
			updateRent();
			player.payment(getRent(), getOwner());
	}
	
	public void updateRent() {
		int utilities = groups.ownedProperties(owner);
		int roll = (int) (Math.random() * 11 + 2);
		if (utilities == 1)
			setRent(roll * 4);
		if (utilities == 2)
			setRent(roll * 10);
	}
	
	public boolean changeHouses(int add) {
    	return false;
    }
	
	public boolean changeHotels() {
		return false;
	}
	public String toString() {
		String string = "Utilities Space\n Space name: " + name + "\n Space Rent: " + rent + "\n" +
	    "Space Owner: " + owner + "\n";
		return string;
}
}
