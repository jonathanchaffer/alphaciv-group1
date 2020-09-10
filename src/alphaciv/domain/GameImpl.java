package alphaciv.domain;

/**
 * Skeleton implementation of HotCiv.
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */

public class GameImpl implements Game {
	private Tile[][] tiles = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	private Unit[][] units = new Unit[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	private City[][] cities = new City[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];

	private Player playerInTurn;
	private int age = GameConstants.STARTAGE;

	public GameImpl() {
		playerInTurn = Player.RED;

		cities[1][1] = new CityImpl(Player.RED);
		cities[4][1] = new CityImpl(Player.BLUE);
		tiles[1][0] = new TileImpl(GameConstants.OCEANS);
		tiles[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		tiles[0][1] = new TileImpl(GameConstants.HILLS);
		units[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
		units[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
		units[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);
	}

	public Tile getTileAt(Position p) {
		Tile tile = tiles[p.getRow()][p.getColumn()];
		if (tile != null)
			return tile;
		else
			return new TileImpl(GameConstants.PLAINS);
	}

	public Unit getUnitAt(Position p) {
		return units[p.getRow()][p.getColumn()];
	}

	public City getCityAt(Position p) {
		return cities[p.getRow()][p.getColumn()];
	}

	public Player getPlayerInTurn() {
		return playerInTurn;
	}

	public Player getWinner() {
		if (age == -3000)
			return Player.RED;
		return null;
	}

	public int getAge() {
		return age;
	}

	public boolean moveUnit(Position from, Position to) {
		Unit unitAtFromPosition = getUnitAt(from);
		Tile tileAtToPosition = getTileAt(to);
		if (tileAtToPosition.getTypeString().equals(GameConstants.OCEANS)
				|| tileAtToPosition.getTypeString().equals(GameConstants.MOUNTAINS))
			return false;
		if (unitAtFromPosition.getOwner() != playerInTurn)
			return false;
		if (Math.abs(to.getRow() - from.getRow()) <= 1 && Math.abs(to.getColumn() - from.getColumn()) <= 1) {
			units[to.getRow()][to.getColumn()] = unitAtFromPosition;
			units[from.getRow()][from.getColumn()] = null;
			return true;
		}
		return false;
	}

	public void endOfTurn() {
		if (playerInTurn == Player.RED) {
			playerInTurn = Player.BLUE;
		} else {
			playerInTurn = Player.RED;
			age += GameConstants.YEARSPERROUND;
			gatherAllCitiesResources();
			produceAllCitiesUnits();
		}
	}

	private void gatherAllCitiesResources() {
		for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < cities[i].length; j++) {
				CityImpl c = (CityImpl) cities[i][j];
				if (c != null) {
					c.addResources(6);
				}
			}
		}

	}

	private void produceAllCitiesUnits() {
		for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < cities[i].length; j++) {
				CityImpl c = (CityImpl) cities[i][j];
				if (c != null) {
					if (c.canProduceUnit()) {
						units[i][j] = new UnitImpl(c.getProduction(), c.getOwner());
					}
				}
			}
		}
	}

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
	}

	public void changeProductionInCityAt(Position p, String unitType) {
	}

	public void performUnitActionAt(Position p) {
	}
}
