package alphaciv.domain;

public class GammaUnitActionStrategy implements UnitActionStrategy {

	@Override
	public void performUnitAction(Position p, UnitActionRequirements requirements) {
		Unit[][] units = requirements.getUnits();
		City[][] cities = requirements.getCities();

		Unit unit = units[p.getRow()][p.getColumn()];

		if (unit.getTypeString() == GameConstants.SETTLER) {
			cities[p.getRow()][p.getColumn()] = new CityImpl(unit.getOwner());
			units[p.getRow()][p.getColumn()] = null;
		}else if(unit.getTypeString() == GameConstants.ARCHER) {
			((UnitImpl) unit).toggleIsFortified(); 
		}
	}

}
