import java.util.Scanner;

public abstract class Location {
	private static Scanner scn = new Scanner(System.in);
	
	protected Player player;
	protected String name;
	
	Location(Player player,String name) {
		this.player = player;
		this.name = name;
		System.out.println("You are currently in " + this.name);
	}
	
	public abstract void getLocations();
	
	public static int locationMenu() {
		System.out.println("1) Safehouse -- There is no any enemy in here !");
		System.out.println("2) Cave -- Maybe there are zombies in here !");
		System.out.println("3) Forest -- Maybe there are bears in here !");
		System.out.println("4) Castle -- Maybe there are vampire in here !");
		System.out.println("0) Previous Menu");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}
}
