package alphaciv.domain;

public class DeltaGameFactory implements GameFactory {
	WorldCreationStrategy worldCreationStrategy;

	public DeltaGameFactory() {
		this.worldCreationStrategy = new DeltaWorldCreationStrategy();
	}

	public DeltaGameFactory(WorldCreationStrategy worldCreationStrategy) {
		this.worldCreationStrategy = worldCreationStrategy;
	}

	@Override
	public Game createGame() {
		return new GameImpl(new AlphaAgingStrategy(), new AlphaWinningStrategy(), new AlphaUnitActionStrategy(),
				new AlphaUnitMovementStrategy(), worldCreationStrategy);
	}

}
