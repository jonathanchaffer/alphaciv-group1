package alphaciv.domain;

public class UnitImpl implements Unit {
	String unitType;
	Player owner;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAttackingStrength() {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean isFortified() {
		return false;
	}

}
