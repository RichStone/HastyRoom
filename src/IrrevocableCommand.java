
public class IrrevocableCommand extends Command	{
	public IrrevocableCommand(String description, String reactionString) {
		super(description, reactionString);
	}
	
	public void changeObjectState(Obj object) {
		object.changeUsedStatus();
	}
}
