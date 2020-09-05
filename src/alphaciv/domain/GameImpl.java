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
	static int BOARDSIZE = 16;
	private Object[][] board = new Object[BOARDSIZE][BOARDSIZE];
	private Player playerInTurn;

	public GameImpl() {
		board[1][1] = new CityImpl(Player.RED);
		board[1][0] = new TileImpl(GameConstants.OCEANS);
		playerInTurn = Player.RED;
		board[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
		board[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
		board[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);

	}

	public Tile getTileAt(Position p) {
		Object objectAtPosition = board[p.getRow()][p.getColumn()];
		if (objectAtPosition instanceof Tile)
			return (Tile) objectAtPosition;
		return null;
	}

	public Unit getUnitAt(Position p) {
		Object objectAtPosition = board[p.getRow()][p.getColumn()];
		if (objectAtPosition instanceof Unit)
			return (Unit) objectAtPosition;
		return null;
	}

	public City getCityAt(Position p) {
		Object objectAtPosition = board[p.getRow()][p.getColumn()];
		if (objectAtPosition instanceof City)
			return (City) objectAtPosition;
		return null;
	}

	public Player getPlayerInTurn() {
		return playerInTurn;
	}

	public Player getWinner() {
		return null;
	}

	public int getAge() {
		return 0;
	}

	public boolean moveUnit(Position from, Position to) {
		return false;
	}

	public void endOfTurn() {
		if (playerInTurn == Player.RED){
			playerInTurn = Player.BLUE;
		} else {
			playerInTurn = Player.RED;
		}
	}

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
	}

	public void changeProductionInCityAt(Position p, String unitType) {
	}

	public void performUnitActionAt(Position p) {
	}
}
