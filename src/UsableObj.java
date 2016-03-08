import java.util.ArrayList;
import java.util.Scanner;

public class UsableObj extends Obj {
	
	private String descriptionFocus; // a detailed description when focused on the object
	private ArrayList <String> commands = new ArrayList<>(); // contains the possible commands in interaction with an object
	
	public UsableObj (String name, String descriptionRoom, String descriptionFocus) {
		
		super(name, descriptionRoom);
		
		this.descriptionFocus = descriptionFocus;
		
		commands.add("Interessiert dich nicht..."); //Any object may be exited at any time
	}
	
	public void addCommand(String option) {
		commands.add(option);
	}
	
	public String listOptions() {

		String allOptions = "";
		int optionCounter = 1;  // is used to display an index ingame
		
		for(String option : commands) {

			if(used) {
				return "Da gibt's nix mehr zu holen Kollege";
			}
			
			allOptions += optionCounter + ". " + option + "\n";
			
			optionCounter++;
			
		}
		return allOptions;
	}
	
	public void focus() {
		Scanner scanner = new Scanner(System.in); //TODO determine case if input not Integer
		boolean exited = false; //player can exit the focus any time by typing the index of "interessiert mich nicht"

		while(!used && !exited) {
		System.out.println(listOptions());	
		System.out.println("Was willsche machen?");
		int choice = scanner.nextInt() - 1;
		
		if(choice == 0) {
			exited = true;
		}
		
		react();
		
		}
	}
	
	public void react() {
		//TODO reaction to a choice of an option
		System.out.println("FU so far");
	}
	
	public String getDescritpionFocus () {
		return descriptionFocus;
	}
}
