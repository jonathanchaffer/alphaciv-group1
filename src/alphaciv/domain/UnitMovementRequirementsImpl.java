package alphaciv.domain;

public class UnitMovementRequirementsImpl implements UnitMovementRequirements {

	Tile destinationTile;
	City[][] cities;
	Unit[][] units;
	
	public UnitMovementRequirementsImpl(Tile destinationTile, City[][] cities, Unit[][] units) {
		this.destinationTile = destinationTile;
		this.cities = cities;
		this.units = units;
	}
	@Override
	public Tile getDestinationTile() {
		return destinationTile;
	}

	@Override
	public City[][] getCities() {
		return cities;
	}

	@Override
	public Unit[][] getUnits() {
		return units;
	}

}
