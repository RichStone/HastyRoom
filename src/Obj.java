import java.util.ArrayList;
import java.util.Scanner;

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
	
	private boolean used; // gets true when all commands or an irrevocable action was taken	
	private boolean interactable;
	
	private String name;
	private String descriptionRoom; // description when an object is approached
	private String descriptionFocus; // a detailed description when focused on the object
	
	Command exitCommand;
	
	
	private ArrayList <Command> commands = new ArrayList<>(); // contains the possible commands of interaction with an object
	
	// 1st constructor for static objects (no interaction possible)
	public Obj (String name, String descriptionRoom) {
		used = false;
		interactable = false;
		this.name = name;
		this.descriptionRoom = descriptionRoom;
	}
	
	//2nd constructor for interactable objects
	public Obj (String name, String descriptionRoom, String descriptionFocus) {
		used = false;
		interactable = true;
		this.name = name;
		this.descriptionRoom = descriptionRoom;
		this.descriptionFocus = descriptionFocus;
		commands.add(exitCommand = new Command("Interessiert dich nicht.", "Hop Hop\n")); //Any interactable object may be exited at any time
	}
	
	//TODO Try catch here with Illegal Argument exception or something
	public void addCommand(Command command) {
		if(interactable) {
			commands.add(command);
		}
		else {
			System.out.println("Can't add a command to a static Obj");
		}
	}
	
	public String listCommands() {

		String allCommands = "";
		int commandIndex = 1;  // is used to display an index ingame
		
		for(Command accessibleCommand : commands) {

			if(used) {
				return "Da gibt's nix mehr zu holen Kollege";
			}
			
			allCommands += commandIndex + ". " + accessibleCommand.getCommandDescription() + "\n";
			
			commandIndex++;
		}
		return allCommands;
	}
	
	public void focus() {
		System.out.println(getDescriptionRoom());
		
		if(interactable) {
			// TODO add rule for out of bounds input
			Scanner scanner = new Scanner(System.in); //TODO determine case if input not Integer
			boolean exited = false; //player can exit the focus any time by typing the index of "interessiert mich nicht"

			while(!used && !exited) {
				System.out.println(listCommands());	
				System.out.println("Was willsche machen?");
				int choice = scanner.nextInt() - 1;
				
				if(choice == 0) {
					exited = true;
				}
				else {
					System.out.println(commands.get(choice).getReactionString());
				}
			}
		}
	}
	
	public int clicks() {
		//TODO counter method to count how many times it was tried to interact with a static object.
		return 0;
	}
	
	public String getDescriptionFocus () {
		return descriptionFocus;
	}
	
	public void changeUsedStatus () {
		used = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescriptionRoom() {
		return descriptionRoom;
	}

}
