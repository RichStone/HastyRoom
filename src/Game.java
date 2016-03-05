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
	
	private static boolean gameWon = false;
	private static boolean enemyArrived = false;
	
	UsableObj hund, meinungsverstärker;
	StaticObj tv;
	
	private static ArrayList<Obj> objects = new ArrayList<>();
	
	private void addObjectsToGame() {
		objects.add(hund = new UsableObj("Hund", "der Hund liegt links neben dir auf der Couch, vielleicht ist er tot. Auf jeden Fall riecht er ganz streng", "du lehnst dich zu ihm vor. Er murmelt etwas vor sich hin, aber er ist nicht ansprechbar. "));
		objects.add(meinungsverstärker = new UsableObj("Meinungsverstärker", "Ein solider Bambusstock", "Oh nein! Er hat Krebs!"));
		objects.add(tv = new StaticObj("Fernseher", "Auf dem Uraltfernseher läuft die Wiederholung eines ProEvo Spiels in Endlosschleife.."));
	}
	
	private static String listObjects() {
		String objectList = "Du bist sehr wach und siehst folgende Sachen: \n";
		int index = 1;
		for(Obj object : objects) {
			objectList += index + ". " + object.getName() + "\n";
			index++;
		}
		return objectList;
	}
	
	private static String welcomeText()	{
		return "Hey!";
	}
	
	private static String gameWonText() {
		return "Well done bro";
	}
	
	private static String gameOverText() {
		return "Du bist am Arsch!";
	}
	
	public static void main(String[] args ) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		
		game.addObjectsToGame();
		
		System.out.println(welcomeText());
		
		while(!gameWon && !enemyArrived) {
			System.out.println(listObjects());
			System.out.println("Was willst du dir genauer anschauen?");
			int choice = scanner.nextInt();
			//KLEINER TEST AB HIER
			System.out.println("Choice: "  + choice);
			if(choice == 5) {
				enemyArrived = true;
			}
			//TEST ENDE
			
		}
		
		if(gameWon) {
			System.out.println(gameWonText());
		}
		if(enemyArrived) {
			System.out.println(gameOverText());
		}
		
	}
}
