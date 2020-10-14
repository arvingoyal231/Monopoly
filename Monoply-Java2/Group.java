import java.util.ArrayList;

/**
 * @author Arvin
 */
public class Group {
	
	private String color;
	private ArrayList<Spaces> group = new ArrayList<Spaces>();
	
	public Group(String color) {
		setColor(color);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void addProperty(Spaces space) {
		group.add(space);
	}
	
	public boolean getOwner(Player player) {
		for (Spaces space: group) {
			if (player != space.getOwner())
				return false;
		}
		return true;
	}
	
	public int ownedProperties(Player player) {
		int owned = 0;
		for (Spaces space: group)
			if(player == space.getOwner())
				owned++;
		return owned;
	}
	
	
	public ArrayList<Spaces> getGroup() {
		return group;
	}
}
