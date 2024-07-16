import java.util.Scanner;

public class Game {
	Player player;
	Location location;

	public boolean Login() {
		System.out.println("Welcome to the Adventure Game ! ");
		System.out.print("Before you start, you have to write Your Name : ");

		Scanner scn = new Scanner(System.in);
		player = new Player(scn.nextLine());

		boolean ifSetted = player.selectCharacter();
		if (!ifSetted) {
			do {
				ifSetted = player.selectCharacter();
			} while (!ifSetted);
		}
		return true;
	}

	public void Start() {
		System.out.println("Welcome " + player.getName());
		boolean flag = true;

		while (flag) {
			switch (Player.charMenu()) {
			case 0:
				flag = false;
				break;
			case 1: {
				boolean flag1 = true;
				while (flag1) {
					switch (Location.locationMenu()) {
					case 1:
						location = new Safehouse(player);
						location.getLocations();
						break;
					case 2: {
						location = new Cave(player);
						location.getLocations();
						break;
					}
					case 3: {
						location = new Forest(player);
						location.getLocations();
						break;
					}
					case 4: {
						location = new Castle(player);
						location.getLocations();
						break;
					}
					case 0:
						flag1 = false;
						break;
					default:
						System.out.println("Please enter correct value !");
						break;
					}
				}
				break;
			}
			case 2: {
				player.printCharacter();
				break;
			}
			case 3: {
				location = new Shop(player);
				location.getLocations();
				break;
			}
			case 4: {
				player.printAwards();
				break;
			}
			case 5: {
				if (player.checkFinish()) {
					flag = false;
					break;
				}
				break;
			}
			default:
				System.out.println("Please enter correct value !");
				break;
			}
		}
	}
}
