/**
 * static objects are just there for the atmosphere. You can never interact with them.
 * If you click on them repeatedly it is counted as an action and the enemy will get nearer.
 * You will also get a feedback then to do something more reasonable then try to examine 
 * unuseful objects.
 */
public class StaticObj extends Obj {

	private int clickCounter = 0; // counts the "clicks" performed on a static object
	
	public StaticObj(String name, String descriptionRoom) {
		super(name, descriptionRoom);
	}

	public int clicks() {
		//TODO counter method to count how many times it was tried to interact with a static object.
		return -1;
	}
	
}
