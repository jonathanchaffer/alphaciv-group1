package alphaciv.domain;

public class CityImpl implements City {
	Player owner; 
	String productionType;
	
	public CityImpl(Player player) {
		owner = player; 
		productionType = GameConstants.ARCHER;
	}
	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getProduction() {
		return productionType;
	}

	@Override
	public String getWorkforceFocus() {
		// TODO Auto-generated method stub
		return null;
	}

}
