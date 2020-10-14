import java.util.ArrayList;

/**
 * @author Arvin
 */
public class Player {

	private String name;
	private int totalMoney = 1500;
	private int position;
	private boolean prison = false;
	private boolean getOut = false;
	private int prisonSentence = 3;
	private ArrayList<Spaces> spacesOwned = new ArrayList<Spaces>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void withdraw (int money) {
		totalMoney -= money;
	}
	
	public void deposit (int money) {
		totalMoney += money;
	}
	
	public void payment(int money, Player otherPlayer) {
		withdraw(money);
		if (otherPlayer != null)
			otherPlayer.deposit(money);
	}
	
	public int getPosition() {
		return position;
	}
	
	//Used for direct, skipping other spaces, movement
	public void newPosition(int position) {
		this.position = position;
	}
	
	//Used for regular movement
	public void moveSpaces(int number) {
		int newPosition = (position + number) % 40;
		if (newPosition < position)
			deposit(200);
		position = newPosition;
	}
	
	public boolean inJail() {
		return prison;
	}
	
	public void arrest() {
		prison = true;
		prisonSentence = 3;
	}
	
	public void updateSentece() {
		prisonSentence -= 1;
	}
	
	//if the player has a Get Out Of Jail Free Card
	public boolean getOutFree() {
		return getOut;
	}
	
	public void hasGetOut(boolean has) {
		getOut = has;
	}
	
	//movement out of jail
	public void freeJail(int steps) {
		moveSpaces(steps);
	}
	
	public ArrayList<Spaces> getOwnedProperties() {
		return spacesOwned;
	}
	
	public void addProperty(Spaces property) {
		spacesOwned.add(property);
	}
	
	public void remove(Spaces property) {
		for (int count = 0; count < spacesOwned.size(); count++){
			if (spacesOwned.get(count) == property)
					spacesOwned.remove(count);
		}
	}
	
	public boolean isBroke() {
		return totalMoney <= 0;
	}
	
	public void setBroke() {
		totalMoney = 0;
		for (int count = 0; count < spacesOwned.size(); count++) {
			spacesOwned.get(count).removeEverything();
			spacesOwned.get(count).newOwner(null);
			spacesOwned.remove(count);
		}
	}
	
		public void canBuy(Spaces space) {
		if (space.getStatus()) {
			addProperty(space);
			withdraw(space.getPrice());
			space.newOwner(this);
		}
	}
	
		public String toString() {
			String string = "";
			string += getName() + "\nTotal Money: " + getTotalMoney() + "\nProperties Owned: ";
			for (Spaces space: spacesOwned)
				string+= space.getName() + ",\n";
			return string;
		}
}
	
	
