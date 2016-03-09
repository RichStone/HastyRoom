/**
 * This is a text-based room game. There are usable and unusable objects in 
 * a single room and there is an enemy like your wife who is getting nearer
 * every time you take an action. You have for example to find something
 * before she reaches your flat.
 * You can win the game through the interaction with the objects.
 * The Objects you see in the room are stored in an ArrayList. To interact with an object the user
 * will get listed all the objects in the room with their indices. The user then can type in the
 * the index of the object he wants to interact with.
 * 
 * @author Rich
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private boolean gameWon = false;
	private boolean gameLost = false;
	
	public Game() {
		addObjectsToGame();
	}
	private ArrayList<Obj> objects = new ArrayList<>();
	
	/**
	 * at this point all the wished objects are created and described.
	 * add an object to the objects collection and add commands to it.
	 * don't add commands to static objects (those with two parameters).
	 */
	private void addObjectsToGame() {
		
		UsableObj hund, meinungsverstaerker, refrigerator;
		Obj  tv, phrasenschwein;
		
		objects.add(hund = new UsableObj("Hund", "der Hund liegt links neben dir auf der Couch, vielleicht ist er tot. Auf jeden "
				+ "Fall riecht er ganz streng", "du lehnst dich zu ihm vor. Er murmelt etwas vor sich hin, aber er ist "
						+ "nicht ansprechbar. "));
			hund.addCommand(new Command("Rüttel ihn.", "Nur ein leises Grummeln."));
			hund.addCommand(new Command("Schlag ihn!", "Nur ein Grummeln."));
			hund.addCommand(new IrrevocableCommand("Verbanne ihn ins Reich!", "Jetzt ist es vorbei mit ihm"));
			
		objects.add(meinungsverstaerker = new UsableObj("Meinungsverstärker", "Ein solider Bambusstock", "Oh nein! Er hat Krebs!"));
			meinungsverstaerker.addCommand(new Command("Heb ihn auf!", "Er ist zu schwer, schade..."));
		
		objects.add(tv = new Obj("Fernseher", "\n\tAuf dem Uraltfernseher läuft die Wiederholung eines ProEvo "
				+ "Spiels in Endlosschleife.."));
		
		objects.add(refrigerator = new UsableObj("Kühlschrank", "Alter weißer Kühlschrank, so klein wie ein Zwerg.", "Der Kühlschrank "
				+ "ist leer, nur zwei Flaschen Bitburger an der Seite und ein verdächtiger weißer Beutel im offenen Tiefkühlfach.."));
		
		objects.add(phrasenschwein = new Obj("Phrasenschwein", "Da sind ne Menge Sachen drin, aber die brauchst du jetzt nicht."));
	}
	
	private String listObjects() {
		String objectList = "Du bist sehr wach und siehst folgende Sachen: \n";
		int index = 1;
		for(Obj object : objects) {
			objectList += index + ". " + object.getName() + "\n";
			index++;
		}
		return objectList;
	}
	
	public void play() {
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println(welcomeText());
		
		while(!gameWon && !gameLost) {
			System.out.println(listObjects());
			System.out.println("Was möchtest du dir anschauen? Gebe die entsprechende Zahl ein und bestätige mit Enter."
					+ " (Seit vorsichtig mit der Eingabe!)");
			// TODO add rule for out of bounds input
			int choice = scanner.nextInt() - 1;
			if(choice > objects.size() || choice < 0) {
				System.out.println("Es war ein Fehler, sich mit dem System anzulegen!\n");
				gameLost = true;
			}
			else if(objects.get(choice) instanceof UsableObj) {
				UsableObj actualObj = (UsableObj)(objects.get(choice));
				actualObj.focus();
			}
			else if(objects.get(choice) instanceof Obj) {
				System.out.println(objects.get(choice).getDescription());
			}
		}
		
		if(gameWon) {
			System.out.println(gameWonText());
		}
		
		if(gameLost) {
			System.out.println(gameOverText());
		}
	}
	
	private String welcomeText()	{
		return "Hey!";
	}
	
	private String gameWonText() {
		return "Well done bro";
	}
	
	private String gameOverText() {
		return "Du bist am Arsch!";
	}
	
	public static void main(String[] args ) {
		Game game = new Game();
		game.play();
	}
}