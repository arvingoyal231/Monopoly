import java.util.ArrayList;

/**
 * @author Arvin
 */
public class MonoplyBoard {

	private ArrayList<Spaces> board = new ArrayList<Spaces>();
	Deck CommunityChestDeck = new Deck();
	Deck ChanceDeck = new Deck();
	
	Group utilitiesGroup = new Group("Neutral");
	Group railRoadGroup = new Group("Neutral");
	
	Group purpleGroup = new Group("Purple");
	int[] purpleHousePrices = {2, 10, 30, 90, 160, 250};
	int[] purpleHousePrices2 = {4, 20, 60, 180, 320, 450};
	
	Group cyanGroup = new Group("Cyan");
	int[] cyanHousePrices = {6, 30, 90, 270, 400, 550};
	int[] cyanHousePrices2 = {8, 40, 100, 300, 450, 600};
	
	Group darkPinkGroup = new Group("Dark Pink");
	int[] darkPinkHousePrices = {10, 50, 150, 450, 625, 750};
	int[] darkPinkHousePrices2 = {12, 60, 180, 500, 700, 900};
	
	Group orangeGroup = new Group("Orange");
	int[] orangeHousePrices = {14, 70, 200, 550, 705, 950};
	int[] orangeHousePrices2 = {16, 80, 220, 600, 800, 1000};
	
	Group redGroup = new Group("red");
	int[] redHousePrices = {18, 90, 250, 700, 875, 1050};
	int[] redHousePrices2 = {20, 100, 300, 750, 925, 1100};
	
	Group yellowGroup = new Group("Yellow");
	int[] yellowHousePrices = {22, 110, 330, 800, 975, 1150};
	int[] yellowHousePrices2 = {24, 120, 360, 850, 1025, 1200};
	
	Group greenGroup = new Group("Green");
	int[] greenHousePrices = {26, 130, 390, 900, 1100, 1275};
	int[] greenHousePrices2 = {28, 150, 450, 1000, 1200, 1400};
	
	Group blueGroup = new Group("Blue");
	int[] blueHousePrices = {35, 175,500, 1100, 1300, 1500};
	int[] blueHousePrices2 = {50, 200, 600, 1400, 1700, 2000};
	
	public MonoplyBoard() {
		board.add(new SpecialSpace("Go Space", 0, 0, false, null, 0, 0)); //0
		board.add(new Building("Mediterranean Avenue", 60, 0, true, null, purpleGroup, 0, 50, purpleHousePrices)); //1
		board.add(new CommunityChest("Community Chest", 0, 0, false, null, CommunityChestDeck)); //2
		board.add(new Building("Baltic Avenue", 60, 0, true, null, purpleGroup, 0, 50, purpleHousePrices2)); //3
		board.add(new SpecialSpace("Income Tax", 0, 0, false, null, 1, 200)); //4
		board.add(new Railroad("Reading Railroad", 200, 0, true, null, railRoadGroup)); //5
		board.add(new Building("Oriental Avenue", 100, 0, true, null, cyanGroup, 0, 50, cyanHousePrices)); //6
		board.add(new Chance("Chance", 0, 0, false, null, ChanceDeck)); //7
		board.add(new Building("Vermont Avenue", 100, 0, true, null, cyanGroup, 0, 50, cyanHousePrices)); //8
		board.add(new Building("Connecticut Avenue", 120, 0, true, null, cyanGroup, 0, 50, cyanHousePrices2)); //9
		board.add(new SpecialSpace("Jail", 0, 0, false, null, 2, 0)); //10
		board.add(new Building("St. Charles Place", 140, 0, true, null, darkPinkGroup, 0, 100, darkPinkHousePrices)); //11
		board.add(new Utilities("Electric Company", 150, 0, true, null, utilitiesGroup)); //12
		board.add(new Building("States Avenue", 140, 0, true, null, darkPinkGroup, 0, 100, darkPinkHousePrices)); //13
		board.add(new Building("Virginia Avenue", 160, 0, true, null, darkPinkGroup, 0, 100, darkPinkHousePrices2)); //14
		board.add(new Railroad("Penssylvania Railroad", 200, 0, true, null, railRoadGroup)); //15
		board.add(new Building("St. James Place", 180, 0, true, null, orangeGroup, 0, 100, orangeHousePrices)); //16
		board.add(new CommunityChest("Community Chest", 0, 0, false, null, CommunityChestDeck)); //17
		board.add(new Building("Tennessee Avenue", 180, 0, true, null, orangeGroup, 0, 100, orangeHousePrices)); //18
		board.add(new Building("New York Avenue", 200, 0, true, null, orangeGroup, 0, 100, orangeHousePrices2)); //19
		board.add(new SpecialSpace("Free Parking", 0, 0, false, null, 2, 0)); //20
		board.add(new Building("Kentucky Avenue", 220, 0, true, null, redGroup, 0, 150, redHousePrices)); //21
		board.add(new Chance("Chance", 0, 0, false, null, ChanceDeck)); //22
		board.add(new Building("Indiana Avenue", 220, 0, true, null, redGroup, 0, 150, redHousePrices)); //23
		board.add(new Building("Illinois Avenue", 240, 0, true, null, redGroup, 0, 150, redHousePrices2)); //24
		board.add(new Railroad("B & O Railroad", 200, 0, true, null, railRoadGroup)); //25
		board.add(new Building("Atlantic Avenue", 260, 0, true, null, yellowGroup, 0, 150, yellowHousePrices)); //26
		board.add(new Building("Ventnor Avenue", 260, 0, true, null, yellowGroup, 0, 150, yellowHousePrices)); //27
		board.add(new Utilities("Water Works", 150, 0, true, null, utilitiesGroup)); //28
		board.add(new Building("Marvin Gardens", 280, 0, true, null, yellowGroup, 0, 150, yellowHousePrices2)); //29
		board.add(new SpecialSpace("Go To Jail", 0, 0, false, null, 3, 0)); //30
		board.add(new Building("Pacific Avenue", 300, 0, true, null, greenGroup, 0, 200, greenHousePrices)); //31
		board.add(new Building("Pacific Avenue", 300, 0, true, null, greenGroup, 0, 200, greenHousePrices)); //32
		board.add(new CommunityChest("Community Chest", 0, 0, false, null, CommunityChestDeck)); //33
		board.add(new Building("Pacific Avenue", 320, 0, true, null, greenGroup, 0, 200, greenHousePrices2)); //34
		board.add(new Railroad("Short Line", 200, 0, true, null, railRoadGroup)); //35
		board.add(new Chance("Chance", 0, 0, false, null, ChanceDeck)); //36
		board.add(new Building("Park Place", 350, 0, true, null, blueGroup, 0, 200, blueHousePrices)); //37
		board.add(new SpecialSpace("Luxury Tax", 0, 0, false, null, 4, 75)); //38
		board.add(new Building("Boardwalk", 400, 0, true, null, blueGroup, 0, 200, blueHousePrices2)); //39
		
		utilitiesGroup.addProperty(getSpaces(12));
		utilitiesGroup.addProperty(getSpaces(28));
		
		railRoadGroup.addProperty(getSpaces(5));
		railRoadGroup.addProperty(getSpaces(15));
		railRoadGroup.addProperty(getSpaces(25));
		railRoadGroup.addProperty(getSpaces(35));
		
		purpleGroup.addProperty(getSpaces(1));
		purpleGroup.addProperty(getSpaces(3));
		
		cyanGroup.addProperty(getSpaces(6));
		cyanGroup.addProperty(getSpaces(8));
		cyanGroup.addProperty(getSpaces(9));
		
		darkPinkGroup.addProperty(getSpaces(11));
		darkPinkGroup.addProperty(getSpaces(13));
		darkPinkGroup.addProperty(getSpaces(14));
		
		orangeGroup.addProperty(getSpaces(16));
		orangeGroup.addProperty(getSpaces(18));
		orangeGroup.addProperty(getSpaces(19));
		
		redGroup.addProperty(getSpaces(21));
		redGroup.addProperty(getSpaces(23));
		redGroup.addProperty(getSpaces(24));
		
		yellowGroup.addProperty(getSpaces(26));
		yellowGroup.addProperty(getSpaces(27));
		yellowGroup.addProperty(getSpaces(29));
		
		greenGroup.addProperty(getSpaces(31));
		greenGroup.addProperty(getSpaces(32));
		greenGroup.addProperty(getSpaces(34));
		
		blueGroup.addProperty(getSpaces(37));
		blueGroup.addProperty(getSpaces(39));
	}
	
	public Spaces getSpaces(int value) {
		return board.get(value);
	}
	
	public ArrayList<Spaces> returnSpaces() {
		return board;
	}
	
	public void printBoard() {
		for (int counter = 0; counter < 40; counter++) {
			System.out.println(board.get(counter).toString());
		}
		
		
	}
	
}
