package alphaciv.domain;

public class UnitActionRequirementsImpl implements UnitActionRequirements {
	City[][] cities;
	Unit[][] units;

	public UnitActionRequirementsImpl(City[][] cities, Unit[][] units) {
		this.cities = cities;
		this.units = units;
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
