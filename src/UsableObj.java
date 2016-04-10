import java.util.Scanner;
import java.util.ArrayList;

public class UsableObj extends Obj {
	
	private String descriptionFocus;
	
	private ArrayList <Command> commands = new ArrayList<>(); // contains the possible commands of interaction with an object

	//constructor for interactable objects
	public UsableObj (String name, String description, String descriptionFocus) {
		super(name, description);
		this.descriptionFocus = descriptionFocus;
		commands.add(exitCommand = new Command("Interessiert dich nicht.", "Hop Hop\n")); //Any interactable object may be exited at any time
	}
	
	@Override	
	public void focus() {
		System.out.println(getDescription());
		// TODO add rule for out of bounds input
		Scanner scanner = new Scanner(System.in); //TODO determine case if input not Integer
		boolean exited = false; //player can exit the focus any time by typing the index of "interessiert mich nicht"
		
		if(used) {
			//FIXME new game is created every time an used object is being tried to use!
			//should jump out of focus somehow in another manner!
			//return 0 or -1 for example?
			Game game = new Game(); 
			System.out.println("Da gibt's nichts mehr zu sehen!");
			game.play();
		}
		
		while(!used && !exited) {
			System.out.println(listCommands());	
			System.out.println("Was willsche machen?");
			int choice = scanner.nextInt() - 1;
			
			if(choice == 0) {
				exited = true;
			}
			else {
				if(commands.get(choice) instanceof IrrevocableCommand) {
					changeUsedStatus(); // TODO add text reaction! 
					//how to make it all work from the IrrevocableCommand interface?
					//MAYBE: add method reactionText() to UsableObj which has a setter
					// where you can put the reaction text and give it as a parameter to changeUsedStatus?
				}
				else {
					System.out.println(commands.get(choice).getReactionString());
				}
			}
		}
	}
	
	
	//TODO Try catch here with Illegal Argument exception or something
	public void addCommand(Command command) {
			commands.add(command);
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

	public String getDescriptionFocus () {
		return descriptionFocus;
	}
}
