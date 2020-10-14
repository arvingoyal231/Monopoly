
/**
 * @author Arvin
 */
public class Dice {
	private int value;
	private boolean isDouble;
	
	public Dice() {};
	
	public void rollDice() {
		int roll1, roll2;
		roll1 = (int) (Math.random() * 6 + 1); 
		roll2 = (int) (Math.random() * 6 + 1); 
		if (roll1 == roll2)
		{
			isDouble = true;
		}
	value = roll1 + roll2;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isDouble() {
		return isDouble;
	}
	
	public void setDouble() {
		isDouble = false;
	}
	
	
}
