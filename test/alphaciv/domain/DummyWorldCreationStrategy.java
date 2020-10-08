package alphaciv.domain;

public class DummyWorldCreationStrategy implements WorldCreationStrategy {

	@Override
	public void createWorld(Tile[][] tiles, Unit[][] units, City[][] cities) {
		tiles[0][0] = new TileImpl(GameConstants.HILLS);
		units[1][1] = new UnitImpl(GameConstants.SETTLER, Player.GREEN);
		cities[2][2] = new CityImpl(Player.YELLOW);
	}

}
