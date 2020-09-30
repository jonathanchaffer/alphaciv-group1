package alphaciv.domain;

public class AlphaGameFactory implements GameFactory {

	@Override
	public Game createGame() {
		return new GameImpl(new AlphaAgingStrategy(), new AlphaWinningStrategy(), new AlphaUnitActionStrategy(), new AlphaUnitMovementStrategy());
	}

}
