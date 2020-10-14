
/**
 * @author Arvin
 */
public class Building extends Spaces {

	private Group group;
	protected int houses;
	protected boolean hotel;
	protected int hotelPrice; //Same as HousePrice
	protected int housePrice[] = new int[6]; //0 - 4 Changes rent based on how many houses there are. 5 is hotel rent. 
	
	public Building(String name, int price, int rent, boolean isSellable, Player owner, Group group, int houses, int hotelPrice, int[] housePrice) {
		super(name, price, rent, true, null);
		this.group = group;
		this.houses = houses;
		this.hotelPrice = hotelPrice;
		this.housePrice = housePrice;
	}

	private void addHotel() {
		hotel = true;
	}
	
	private void removeHotel() {
		hotel = false;
	}
	
	private void addHouse() {
		houses++;
	}
	
	private void removeHouse() {
		houses--;
	}
	
	private boolean destroyHotels()
	{
		if(hotel) 
			removeHotel();
		return true;
	}
	
	private void destroyHouses() {
		if (houses > 0)
		    houses = 0;
	}
	
	public void action(Player player) {
		if (player != owner)
			player.payment(rent, owner);
	}

	public boolean changeHouses(int add)
	{
		if (group.getOwner(owner))
			{
			    if (houses + add <=4 && !hotel)
			    {
			    	if (owner.getTotalMoney() >= hotelPrice * add)
			    	{
			    	getOwner().payment(hotelPrice * add, null);
			    	while (add > 0) {
			    		addHouse();
			    		add--; }
			    	updateRent();
			    	return true;
			    }
			}
		}
		return false;
	}
	
	public boolean changeHotels()
	{
		if (group.getOwner(owner))
		{
			if (houses == 4 && !hotel)
			{
				if (owner.getTotalMoney() >= hotelPrice)
				{
					getOwner().payment(hotelPrice, null);
					destroyHouses();
					addHotel();
					updateRent();
					return hotel;
				}
			}
		}
	  return false;
	}
	
	public void updateRent() {
	if (hotel)
		rent = housePrice[5];
	else
		rent = housePrice[houses];
	}

	public void removeEverything() {
		if(hotel)
		{
			destroyHotels();
		}
		
		if (houses > 0)
			destroyHouses();
	}

	public String toString() {
		String string = "Property\n Space Name: " + name + "\n Space Price: " + price + " Space Owner: " + owner + "\n Space rents: ";
		for (int counter = 0; counter < 6; counter++)
			string += housePrice[counter] + " ";
		return string;
		
	}
	
}
