import java.util.ArrayList;

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
	
	public String getDescritpionFocus () {
		return descriptionFocus;
	}
}
