import java.util.Random;

public class Obstacle {
	private String name;
	private int damage, award, health, maxCount;

	public Obstacle(String name, int damage, int award, int health, int maxCount) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxCount = maxCount;
	}

	public int obstacleCount() {
		Random rnd = new Random();
		return rnd.nextInt(1, this.maxCount + 1);
	}

	public void printObstacle() {
		System.out.println(this.getName() + " -- Damage : " + this.getDamage() + " -- Health : " + this.getHealth());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}
