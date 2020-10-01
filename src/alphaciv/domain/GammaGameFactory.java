package alphaciv.domain;

public class GammaGameFactory implements GameFactory {

	@Override
	public Game createGame() {
		return new GameImpl(new AlphaAgingStrategy(), new AlphaWinningStrategy(), new GammaUnitActionStrategy(),
				new GammaUnitMovementStrategy());
	}

}
