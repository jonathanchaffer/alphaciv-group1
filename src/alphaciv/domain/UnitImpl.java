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
		int strength = 0;
		switch (unitType) {		
		case GameConstants.ARCHER:
			strength = 3;
			if(isFortified()) {
				strength *= 2;
			}
			break;
		case GameConstants.SETTLER:
			strength = 3;
			break;
		case GameConstants.LEGION:
			strength = 2;
			break;
		}
		return strength;
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
