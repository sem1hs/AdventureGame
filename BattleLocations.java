import java.util.Scanner;

public abstract class BattleLocations extends Location {
	private Obstacle obstacle;
	private static Scanner scn = new Scanner(System.in);

	BattleLocations(Player player, String name, Obstacle obstacle) {
		super(player, name);
		this.obstacle = obstacle;
	}

	public void checkArmor() {
		if (player.getInv().getArmor() > 0) {
			if (player.getInv().getArmor() < obstacle.getDamage()) {
				player.setHealth(player.getHealth() + player.getInv().getArmor() - obstacle.getDamage());
				player.getInv().setArmor(0);

			} else {
				player.getInv().setArmor(player.getInv().getArmor() - obstacle.getDamage());

			}

		} else {
			player.setHealth(player.getHealth() - obstacle.getDamage());

		}
	}

	public boolean checkWin(int count, int award) {
		if (count < 1) {
			System.out.println("You Won !");

			player.setMoney(player.getMoney() + award);
			player.printCharacter();
			return true;
		}
		return false;
	}

	public void initAward() {
		switch (obstacle.getName()) {
		case "Zombie":
			player.getInv().setIron(true);
			player.printAwards();
			break;
		case "Bear":
			player.getInv().setFirewood(true);
			player.printAwards();
			break;
		case "Chest":
			player.getInv().setChest(true);
			player.printAwards();
			break;
		default:
			break;
		}
	}

	public void getLocations() {
		int count = obstacle.obstacleCount();
		int award = count * obstacle.getAward();
		System.out.println(
				"Be careful ! There are " + count + " " + this.obstacle.getName() + " in Cave -- Award : " + award);

		boolean flag = true;
		while (flag) {
			switch (fightOrEscape()) {
			case 1: {
				if (player.getHealth() > 0) {

					if (checkWin(count, award)) {
						initAward();
						flag = false;
						break;
					}

					player.printCharacter();
					System.out.print(count + "* ");
					obstacle.printObstacle();

					obstacle.setHealth(obstacle.getHealth() - player.getDamage());
					checkArmor();

					System.out.println();

					if (obstacle.getHealth() < 0) {
						obstacle.setHealth(4);
						count--;
						break;
					} else if (player.getHealth() < 0) {
						System.out.println("You Died :( ");
						player.setHealth(0);
						break;
					}
					break;
				}
				System.out.println("Your health is not enough !");
				break;
			}

			case 2:
				flag = false;
				break;
			default:
				break;
			}
		}

	}

	public static int fightOrEscape() {
		System.out.println("1) Fight");
		System.out.println("2) Escape");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}

}
