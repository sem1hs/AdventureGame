
public class Inventory {
	private boolean chest, iron, firewood;
	private String weaponName, armorName;
	private int weapon, armor;

	Inventory() {
		this.chest = true;
		this.iron = false;
		this.firewood = true;

		this.weaponName = null;
		this.armorName = null;

		this.weapon = 0;
		this.armor = 0;
	}

	public void printInv() {
		System.out.println(" -- Weapon Id : " + this.weapon + " -- Weapon Name : " + this.weaponName);
		System.out.println(" -- Armor : " + this.armor+ " -- Armor Name : " + this.armorName);
	}

	public boolean getChest() {
		return chest;
	}

	public void setChest(boolean chest) {
		this.chest = chest;
	}

	public boolean getIron() {
		return iron;
	}

	public void setIron(boolean iron) {
		this.iron = iron;
	}

	public boolean getFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}
