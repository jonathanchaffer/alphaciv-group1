package alphaciv.domain;

public interface UnitMovementRequirements {
	public Tile getDestinationTile();
	public City[][] getCities();
	public Unit[][] getUnits();
}
