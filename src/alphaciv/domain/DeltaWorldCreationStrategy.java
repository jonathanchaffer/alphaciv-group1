package alphaciv.domain;

public class DeltaWorldCreationStrategy implements WorldCreationStrategy {
	// @formatter:off
	static String[][] defaultTiles = new String[][] {
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.MOUNTAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.FOREST, GameConstants.FOREST, GameConstants.FOREST, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.MOUNTAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.MOUNTAINS, GameConstants.MOUNTAINS, GameConstants.MOUNTAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.FOREST, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.MOUNTAINS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.FOREST, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.PLAINS, GameConstants.FOREST, GameConstants.FOREST, GameConstants.FOREST, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.FOREST, GameConstants.FOREST, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS},
		{GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS},
		{GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.MOUNTAINS, GameConstants.MOUNTAINS, GameConstants.MOUNTAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.FOREST, GameConstants.FOREST, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.HILLS, GameConstants.HILLS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS},
		{GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.OCEANS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.PLAINS, GameConstants.OCEANS, GameConstants.OCEANS},
	};
	// @formatter:on

	@Override
	public void createWorld(Tile[][] tiles, Unit[][] units, City[][] cities) {
		for (int i = 0; i < defaultTiles.length; i++) {
			for (int j = 0; j < defaultTiles[i].length; j++) {
				tiles[i][j] = new TileImpl(defaultTiles[i][j]);
			}
		}
		cities[8][12] = new CityImpl(Player.RED);
		cities[4][5] = new CityImpl(Player.BLUE);
	}

}
