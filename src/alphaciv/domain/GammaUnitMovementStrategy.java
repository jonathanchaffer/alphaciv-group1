package alphaciv.domain;

public class GammaUnitMovementStrategy implements UnitMovementStrategy {

	@Override
	public boolean canMoveUnit(Unit u) {
		if(u instanceof UnitImpl) {
			return !((UnitImpl) u).isFortified();
		}
		return true;
	}

}
