/**
 * This is a text-based room game. There are usable and unusable objects in 
 * a single room and there is an enemy like your wife who is getting nearer
 * every time you take an action. You have for example to find something
 * before she reaches your flat.
 * You can win the game through the interaction with the objects.
 * @author Rich
 * 
 */
public class Game {
	public static void main(String[] args ) {
		Object hund = new Object();
		hund.addCommand("Weck ihn auf");
		System.out.println(hund.listOptions());
	}
}
