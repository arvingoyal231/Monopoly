
/**
 * @author Arvin
 */
public class Cards {

	private int condition;
	private int value;
	private String text;
	
	public Cards(int condition, int value, String text) {
		this.condition = condition;
		this.value = value;
		this.text = text;
	}

	public int getCondition() {
		return condition;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		String string = "Text: " + text + "\n Card Condition: " + condition + "\n Card Value: " + value + "\n";
		return string;
	}
}
