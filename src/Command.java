/**
 * There is one type of commands for now: 
 * 1. some which have just a text as a reaction
 * TODO add other types of commands
 * @author Rich
 *
 */
public class Command {
	private String description;
	private String reactionString;
	
	public Command(String description, String reactionString) {
		this.description = description;
		this.reactionString = reactionString;
	}
	
	public String getCommandDescription() {
		return description;
	}
	
	public String getReactionString() {
		return reactionString;
	}
}
