package alphaciv.domain;

public class CityImpl implements City {
	Player owner; 
	
	public CityImpl(Player player) {
		owner = player; 
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWorkforceFocus() {
		// TODO Auto-generated method stub
		return null;
	}

}
