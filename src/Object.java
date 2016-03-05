/**
 * 
 * @author Rich
 * Every Object has a name and a description. 
 * Some objects have their own commands.
 */

import java.util.ArrayList;

public class Object {
	
	// TODO all of this stuff below belongs into a subclass -> Refactor! Super constructor should contain name and description.
	
	private boolean used = false; // gets true when all commands or an irrevocable one was taken
	private ArrayList <String> commands = new ArrayList<>();
	
	public Object () {
		commands.add("Interessiert dich nicht..."); //Any object may be exited at any time
	}
	
	public void addCommand(String option) {
		commands.add(option);
	}
	
	public String listOptions() {
		String allOptions = "";
		int optionCounter = 1;
		
		for(String option : commands) {

			if(used) {
				return "Da gibt's nix mehr zu holen Kollege";
			}
			
			allOptions += optionCounter + ". " + option + "\n";
			
			optionCounter++;
			
		}
		return allOptions;
	}
	
	public void changeUsedStatus () {
		used = true;
	}

}
