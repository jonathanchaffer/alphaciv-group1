package alphaciv.domain;

public class UnitImpl implements Unit {
	String unitType;
	Player owner;
	boolean fortified = false;
	
	public UnitImpl (String unitType, Player owner) {
		this.unitType = unitType;
		this.owner = owner;
	}

	@Override
	public String getTypeString() {
		return unitType;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getMoveCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDefensiveStrength() {
		switch (unitType) {		
		case GameConstants.ARCHER:
			return 3;
		case GameConstants.SETTLER:
			return 3;
		case GameConstants.LEGION:
			return 2; 
		}
		return 0;
	}

	@Override
	public int getAttackingStrength() {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean isFortified() {
		return fortified;
	}
	public void toggleIsFortified(){
		fortified = !fortified;
	}

}
