package alphaciv.domain;

public interface UnitActionStrategy {
	public void performUnitAction(Position p, UnitActionRequirements requirements);
}
