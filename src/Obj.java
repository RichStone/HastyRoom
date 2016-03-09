/**
 * 
 * @author Rich
 * The Game has a Room where different Objects are placed which
 * you can interact with.
 * Every Object has a name and a description. 
 * Interactable objects have an additional description.
 * It's necessary to add commands which are performed on an
 * interactable object.
 */

public class Obj {
	
	boolean used; // gets true when all commands or an irrevocable action was taken	
	
	private String name;
	String description; // description when an object is approached
	
	Command exitCommand;
		
	// 1st constructor for static objects (no interaction possible)
	public Obj (String name, String description) {
		used = false;
		this.name = name;
		this.description = description;
	}
	
	public int clicks() {
		//TODO counter method to count how many times it was tried to interact with a static object.
		return 0;
	}
	
	public void changeUsedStatus () {
		used = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

}
