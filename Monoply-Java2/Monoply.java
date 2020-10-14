import java.util.*;

/**
 * @author Arvin
 */
public class Monoply {

	private static Dice dice = new Dice();
	public static MonoplyBoard board;
	private static ArrayList<Player> playing = new ArrayList<Player>();
	private static ArrayList<Player> out = new ArrayList<Player>();
	private boolean turnEnd = false;
	private boolean gameEnd = false;
	private Player currentPlayer = null;
	private int doubles = 0;
	private int turns = 0;
	Scanner scan = new Scanner(System.in);
	
	public Monoply() {
	}
	
	public void setUp() {
		board = new MonoplyBoard();
		int players = 0;
		while (players < 2 || players > 6) {
			System.out.println("How many players will be playing today?");
			players = scan.nextInt();
			if (players < 2 ||players > 6)
				System.out.println("Only 2 - 6 Players Are Allowed");
		}
		while (players > 0) {
			System.out.println("What is player " + players + "'s name?");
			String name = scan.next();
			playing.add(0, new Player(name));
			players--;
		}
		currentPlayer = playing.get(0);
	}
	
	public void startGame() {
		System.out.println("**********************************************");
		System.out.println("Welcome to Monopoly Created in Java! Have Fun!");
		System.out.println("**********************************************");
		setUp();
		begin();
	}
	
	public void bankruptPlayer(Player player) {
		if(playing.remove(player))
			out.add(0, player);
	}
	
	public boolean endGame() {
		if (playing.size() == 1)
			return true;
		return false;
	}
	
	public void setEndGame(boolean end) {
		gameEnd = end;
	}
	
	public boolean turnEnd() {
		return turnEnd;
	}
	
	public void setTurnEnd(boolean end)
	{
		turnEnd = end;
	}
	
	public Player getCurrent() {
		return currentPlayer;
	}
	
	public void nextPlayer(Player player) {
		int play = playing.indexOf(player);
		if (play == playing.size() - 1)
			play = 0;
		else if (dice.isDouble())
			play = play;
		else
			play += 1;
		currentPlayer = playing.get(play);
	}
	
	public void newTurn() {
		setTurnEnd(false);
		nextPlayer(currentPlayer);
		turns++;
		doubles = 0;
		dice.setDouble();
		System.out.println("It is now turn: " + getTurnCount());
		System.out.println("***********************************");
		System.out.println(currentPlayer.toString());
		System.out.println("You are at position " + currentPlayer.getPosition());
		System.out.println();
	}
	
	public int getTurnCount() {
		return turns;
	}
	
	public int getNumDoubles() {
		return doubles;
	}
	
	public void inPrison(Player player, int option) {
		if (option == 1) {
			currentPlayer.payment(50, null);
			currentPlayer.freeJail(dice.getValue());
		}
		if (option == 2) {
			int numThrows = 0;
			dice.rollDice();
			while (numThrows < 3) {
				if (dice.isDouble()) {
					currentPlayer.freeJail(dice.getValue());
					System.out.println("You have just gotten out of prison");
					numThrows = 3;
				}
				else {
					dice.rollDice();
					System.out.println("You got " + dice.getValue() + ". It was not a double");
				}
					
			}
		}
		if (option == 3) {
			currentPlayer.hasGetOut(false);
			currentPlayer.freeJail(dice.getValue());
		}
	}
	
	public void begin() {
		
		while(!gameEnd) {
			System.out.println(currentPlayer.toString());
			System.out.println();
			System.out.println("You are at position " + currentPlayer.getPosition());
			System.out.println();
			while(!turnEnd()) {
			if(currentPlayer.inJail()) {
				System.out.println("What action do you wish to take?");
				System.out.println("Do not pay and take chances to roll doubles on the dice, type 1");
				System.out.println("Pay the $50 fee and leave jail, type 2");
				System.out.println("If you have a get out of jail free card, type 3 to use it");
				System.out.println();
				int option = scan.nextInt();
				inPrison(currentPlayer, option);
				setTurnEnd(true);
			}
			else {
				System.out.println("Are you ready to roll the dice? Type Yes or No.");
				if (scan.next().equalsIgnoreCase("yes")) {
					dice.rollDice();
					System.out.println("You got a " + dice.getValue() + "\n Was the roll a double: " + dice.isDouble());
					System.out.println();
					currentPlayer.moveSpaces(dice.getValue());
				System.out.println("Your new position is at: " + board.getSpaces(currentPlayer.getPosition()).toString());
				if(board.getSpaces(currentPlayer.getPosition()).getOwner() == currentPlayer) {
					System.out.println("What do you wish to do? Enter: buy house, buy hotel, end turn");
					while(!scan.next().equalsIgnoreCase("end turn")) {
					if (scan.next().equalsIgnoreCase("buy house")) {
						System.out.println("How many houses do you want to build?");
						int number = scan.nextInt();
						if (board.getSpaces(currentPlayer.getPosition()).changeHouses(number)) {
							System.out.println("You have succesfully added houses to this property");
							System.out.println();
							System.out.println("The new rent is: " + board.getSpaces(currentPlayer.getPosition()).getRent());
							System.out.println();
						}	
						else
							System.out.println("Error, you can not add houses to this property");
						
					}
					if (scan.next().equalsIgnoreCase("buy hotel")) {
						if (board.getSpaces(currentPlayer.getPosition()).changeHotels()) {
							System.out.println("You have succesfully added houses to this property");
							System.out.println();
							System.out.println("The new rent is: " + board.getSpaces(currentPlayer.getPosition()).getRent());
							System.out.println();
						}	
						else
							System.out.println("Error, you can not add houses to this property");
						}
					}
				}
				
				else if (board.getSpaces(currentPlayer.getPosition()).getOwner() == null) {
					board.getSpaces(currentPlayer.getPosition()).action(currentPlayer);
					if (board.getSpaces(currentPlayer.getPosition()).getStatus()) {
						System.out.println("Do you want to buy this property? Type Yes or No.");
						if (scan.next().equalsIgnoreCase("yes")) {
							currentPlayer.canBuy(board.getSpaces(currentPlayer.getPosition()));
							System.out.println();
							setTurnEnd(true);
					}
						else if (scan.next().equalsIgnoreCase("no")) {
							System.out.println("You do not want to buy this property");
							System.out.println();
							setTurnEnd(true);
					}
				}
					else {
						System.out.println("You can not buy this property");
						System.out.println();
						setTurnEnd(true);
					}
			}
				else if (board.getSpaces(currentPlayer.getPosition()).getOwner() != currentPlayer) {
					board.getSpaces(currentPlayer.getPosition()).action(currentPlayer);
					System.out.println();
					setTurnEnd(true);
				}
				else {
						if (currentPlayer.inJail())
							System.out.println("You are now in jail");
							setTurnEnd(true);
					 }
						
					}
				}
			if (currentPlayer.isBroke()) {
				currentPlayer.setBroke();
				bankruptPlayer(currentPlayer);
			}
			if (endGame()) {
				setEndGame(true);
				System.out.println("The winner was " + playing.get(0));
			}
			
			setTurnEnd(true);
			if (turnEnd())
				newTurn();
	   }
	}
  }
}

	

