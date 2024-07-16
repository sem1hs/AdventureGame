import java.util.Scanner;

public class Player {
	private int id, damage, health, money, baseHealth;
	private String name, chName;
	private Inventory inv;
	private static Scanner scn = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	public boolean selectCharacter() {
		System.out.println("Please select one character !\n");
		System.out.println("1) Samurai -- Damage : 5 -- Health : 21 -- Money : 15 ");
		System.out.println("2) Archer -- Damage : 7 -- Health : 18 -- Money : 20 ");
		System.out.println("3) Knight -- Damage : 8 -- Health : 24 -- Money : 5 ");
		System.out.print("Your Choise : ");

		this.setId(scn.nextInt());

		switch (this.getId()) {
		case 1:
			this.initChar("Samurai", 5, 21, 21, 15);
			break;
		case 2:
			this.initChar("Archer", 7, 18, 18, 20);
			break;
		case 3:
			this.initChar("Knight", 8, 24, 24, 5);
			break;
		default:
			System.out.println("Please select one from these characters !");
			return false;
		}
		return true;
	}

	public boolean checkFinish() {
		boolean iron = getInv().getIron();
		boolean firewood = getInv().getFirewood();
		boolean chest = getInv().getChest();
		
		if(iron && firewood && chest ) {
			System.out.println("You have succesful finished the game !");
			return true;
		}
		System.out.println("You have to collect awards !");
		return false;
	}
	private void initChar(String chName, int damage, int health, int baseHealth, int money) {
		this.setChName(chName);
		this.setDamage(damage);
		this.setHealth(health);
		this.setMoney(money);
		this.setBaseHealth(baseHealth);
	}

	public void printCharacter() {
		System.out.println("Your character\n");
		System.out.println(this.getChName() + " -- Damage : " + this.getDamage() + " -- Health : " + this.getHealth()
				+ " -- Money : " + this.getMoney() + " -- Armor : " + this.getInv().getArmor());
	}

	public void printAwards() {
		System.out.println(" -- Iron : " + this.getInv().getIron() + " -- Firewoord : " + this.getInv().getFirewood()
				+ " -- Chest : " + this.getInv().getChest());
	}

	public static int charMenu() {
		System.out.println("1) Go Locations");
		System.out.println("2) Show Characters");
		System.out.println("3) Go Shop");
		System.out.println("4) Show Awards");
		System.out.println("5) Finish Game");
		System.out.println("0) Quit");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}

	// Getters and Setters
	public int getBaseHealth() {
		return baseHealth;
	}

	public void setBaseHealth(int baseHealth) {
		this.baseHealth = baseHealth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
