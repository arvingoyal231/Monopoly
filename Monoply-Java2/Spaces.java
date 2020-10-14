
/**
 * @author Arvin
 */
public abstract class Spaces {
	protected String name;
	protected int price;
	protected int rent;
	protected boolean isSellable;
	protected Player owner;
	
	public Spaces (String name, int price, int rent, boolean isSellable, Player owner) {
		this.name = name;
		this.price = price;
		this.rent = rent;
		this.isSellable = isSellable;
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void mortgage() 	{
		price /= 2;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void newOwner(Player player) {
		owner = player;
	}
	
	public boolean getStatus() {
		return isSellable;
	}
	
	public abstract void action(Player player);
	
	public abstract void updateRent();
	
	public abstract void removeEverything();
	
	public abstract boolean changeHouses(int add);
	
	public abstract boolean changeHotels();
}
