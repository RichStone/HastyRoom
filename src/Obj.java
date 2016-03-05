/**
 * 
 * @author Rich
 * The Game has a Room where different Objects are placed which
 * you can interact with.
 * Every Object has a name and a description. 
 * Some objects have their own commands.
 */

public class Obj {
	
	boolean used; // gets true when all commands or an irrevocable action was taken	
	
	private String name;
	private String descriptionRoom;
	
	public Obj (String name, String descriptionRoom) {
		
		used = false;
		
		this.name = name;
		this.descriptionRoom = descriptionRoom;
	}
	
	public void changeUsedStatus () {
		used = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescritpionRoom () {
		return descriptionRoom;
	}

}
