
public class Safehouse extends NormalLocations {

	Safehouse(Player player) {
		super(player,"Safehouse");
	}
	
	public void getLocations() {
		
		System.out.println("Your health have renewed ! ");
		player.printCharacter();
		player.setHealth(player.getBaseHealth());
	}

}
