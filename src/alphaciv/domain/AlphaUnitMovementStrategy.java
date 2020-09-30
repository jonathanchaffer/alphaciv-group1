package alphaciv.domain;

public class AlphaUnitMovementStrategy implements UnitMovementStrategy {

	@Override
	public boolean moveUnit(Position from, Position to, UnitMovementRequirements requirements) {
		Unit[][] units = requirements.getUnits();
		City[][] cities = requirements.getCities();
		Unit unitAtFromPosition = units[from.getRow()][from.getColumn()];
		Tile tileAtToPosition = requirements.getDestinationTile();
		if (tileAtToPosition.getTypeString().equals(GameConstants.OCEANS)
				|| tileAtToPosition.getTypeString().equals(GameConstants.MOUNTAINS))
			return false;
		if (Math.abs(to.getRow() - from.getRow()) <= 1 && Math.abs(to.getColumn() - from.getColumn()) <= 1) {
			units[to.getRow()][to.getColumn()] = unitAtFromPosition;
			units[from.getRow()][from.getColumn()] = null;
			if (cities[to.getRow()][to.getColumn()] != null) {
				((CityImpl) cities[to.getRow()][to.getColumn()]).setOwner(unitAtFromPosition.getOwner());
			}
			return true;
		}
		return false;
	}

}
