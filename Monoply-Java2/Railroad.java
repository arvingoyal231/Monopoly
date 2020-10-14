
/**
 * @author Arvin
 */
public class Railroad extends Spaces {

	private Group groups;
	
	public Railroad(String name, int price, int rent, boolean isSellable, Player owner, Group group) {
		super(name, price, rent, true, null);
		groups = group;
	}
	
	public void removeEverything() {}
	
	public void action(Player player) {
		if (player != owner)
			player.payment(getRent(), getOwner());
	}
	
	public void updateRent() {
		int properties = groups.ownedProperties(owner);	
		if (properties == 1)
			setRent(25);
		if (properties == 2)
			setRent(50);
		if (properties == 3)
			setRent(100);
		if (properties == 4)
			setRent(200);
	}
	
	public boolean changeHouses(int add) {
    	return false;
    }
	
	public boolean changeHotels() {
		return false;
	}
	
	public String toString() {
		String string = "Railroad\n Space Name: " + name + "\n Space Rent: " + rent + "\n Space Price: " + price + "\n Space Owner: " + owner + "\n";
		return string;
	}
	
}
