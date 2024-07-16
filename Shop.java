import java.util.Scanner;

public class Shop extends NormalLocations {
	private static Scanner scn = new Scanner(System.in);

	Shop(Player player) {
		super(player, "Shop");
	}

	@Override
	public void getLocations() {
		boolean flag1 = true;
		do {
			switch (shopMenu()) {
			case 1: {
				boolean flag2 = true;
				do {
					switch (weaponsMenu()) {
					case 0:
						flag2 = false;
						break;
					case 1:
						if (!checkGun(1, "Gun", 2, 15))
							break;
						break;
					case 2:
						if (!checkGun(2, "Sword", 3, 35))
							break;
					case 3:
						if (!checkGun(3, "Rifle", 7, 45))
							break;
					default:
						break;
					}
				} while (flag2);
				break;
			}
			case 2: {
				boolean flag2 = true;
				do {
					switch (armorsMenu()) {
					case 0:
						flag2 = false;
						break;
					case 1:
						if (!checkArmor(15, "Hafif", 1))
							break;
						break;
					case 2:
						if (!checkArmor(25, "Orta", 3))
							break;
						break;
					case 3:
						if (!checkArmor(40, "Ağır", 5))
							break;
						break;
					default:
						break;
					}

				} while (flag2);
				break;
			}
			default:
				break;
			case 0:
				flag1 = false;
				break;
			}
		} while (flag1);
	}

	public boolean checkArmor(int money, String name, int armor) {
		if (player.getMoney() > money) {
			initArmor(armor,name,money);
			System.out.println("You have successfull buyed a new " + player.getInv().getArmorName());
			player.getInv().printInv();
			return false;
		}
		System.out.println("Your money is not enough !");
		return false;
	}

	public boolean checkGun(int id, String name, int damage, int money) {
		if (player.getInv().getWeapon() == id) {
			System.out.println("You have already this weapon !");
			return false;
		} else if (player.getMoney() >= money) {
			initDamage(id, name, damage, money);
			System.out.println("You have successfull buyed a new " + player.getInv().getWeaponName());
			player.getInv().printInv();
			player.printCharacter();
			return false;
		}
		System.out.println("Your money is not enough !");
		return false;

	}

	public void initDamage(int id, String name, int damage, int money) {
		player.getInv().setWeapon(id);
		player.getInv().setWeaponName(name);
		player.setDamage(player.getDamage() + damage);
		player.setMoney(player.getMoney() - money);
	}
	
	public void initArmor(int armor,String name, int money) {
		player.getInv().setArmor(player.getInv().getArmor() + armor);
		player.getInv().setArmorName(name);
		player.setMoney(player.getMoney() - money);
	}

	public int shopMenu() {
		System.out.println("Money : " + this.player.getMoney());
		System.out.println("1) Weapons");
		System.out.println("2) Armors");
		System.out.println("0) Previous Menu");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}

	public int weaponsMenu() {
		System.out.println("Money : " + this.player.getMoney());
		System.out.println("1) Gun -- Price : 25 -- Damage : 2");
		System.out.println("2) Sword -- Price : 35 -- Damage : 3");
		System.out.println("3) Rifle -- Price : 45 -- Damage : 7");
		System.out.println("0) Previous Menu");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}

	public int armorsMenu() {
		System.out.println("Money : " + this.player.getMoney());
		System.out.println("1) Hafif -- Price : 15 -- Armor : 1");
		System.out.println("2) Orta -- Price : 25 -- Armor : 3");
		System.out.println("3) Ağır -- Price : 40 -- Armor : 5");
		System.out.println("0) Previous Menu");
		System.out.print("Your Choice : ");

		return scn.nextInt();
	}

}
