package alphaciv.domain;

public class AlphaWorldCreationStrategy implements WorldCreationStrategy {

	@Override
	public void createWorld(Tile[][] tiles, Unit[][] units, City[][] cities) {
		cities[1][1] = new CityImpl(Player.RED);
		cities[4][1] = new CityImpl(Player.BLUE);
		tiles[1][0] = new TileImpl(GameConstants.OCEANS);
		tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		tiles[0][1] = new TileImpl(GameConstants.HILLS);
		units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
		units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
		units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);
	}

}
