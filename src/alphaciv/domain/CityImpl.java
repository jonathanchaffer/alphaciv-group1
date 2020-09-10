package alphaciv.domain;

public class CityImpl implements City {
	Player owner; 
	String productionType;
	int populationSize;
	int resources;
	
	public CityImpl(Player player) {
		owner = player; 
		productionType = GameConstants.ARCHER;
		populationSize = 1;
	}
	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getSize() {
		return populationSize;
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
	public boolean canProduceUnit() {
		if(GameConstants.getCostForUnit(productionType) <= resources) {
			return true;
		}
		return false;
	}
	public void addResources(int amount) {
		resources += amount;
	}

}
