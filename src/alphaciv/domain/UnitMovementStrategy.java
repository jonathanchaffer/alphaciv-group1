package alphaciv.domain;

public interface UnitMovementStrategy {

	public boolean moveUnit(Position from, Position to, UnitMovementRequirements requirements);
}
