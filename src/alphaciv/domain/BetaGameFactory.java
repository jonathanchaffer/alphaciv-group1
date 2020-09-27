package alphaciv.domain;

public class BetaGameFactory implements GameFactory {

	@Override
	public Game createGame() {
		return new GameImpl(new BetaAgingStrategy(), new BetaWinningStrategy());
	}

}
