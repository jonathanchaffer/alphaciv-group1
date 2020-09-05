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
	private Object[][] board = new Object[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
	private Player playerInTurn;
	private int age = GameConstants.STARTAGE;

	public GameImpl() {
		board[1][1] = new CityImpl(Player.RED);
		board[1][0] = new TileImpl(GameConstants.OCEANS);
		board[2][2] = new TileImpl(GameConstants.MOUNTAINS);
		playerInTurn = Player.RED;
		board[2][0] = new UnitImpl(GameConstants.ARCHER, Player.RED);
		board[3][2] = new UnitImpl(GameConstants.LEGION, Player.BLUE);
		board[4][3] = new UnitImpl(GameConstants.SETTLER, Player.RED);

	}

	public Tile getTileAt(Position p) {
		Object objectAtPosition = getObjectAtPosition(p);
		if (objectAtPosition instanceof Tile)
			return (Tile) objectAtPosition;
		return null;
	}

	public Unit getUnitAt(Position p) {
		Object objectAtPosition = getObjectAtPosition(p);
		if (objectAtPosition instanceof Unit)
			return (Unit) objectAtPosition;
		return null;
	}

	public City getCityAt(Position p) {
		Object objectAtPosition = getObjectAtPosition(p);
		if (objectAtPosition instanceof City)
			return (City) objectAtPosition;
		return null;
	}

	public Player getPlayerInTurn() {
		return playerInTurn;
	}

	public Player getWinner() {
		if (age == -3000) return Player.RED;
		return null;
	}

	public int getAge() {
		return age;
	}

	public boolean moveUnit(Position from, Position to) {
		Object objectAtFromPosition = getObjectAtPosition(from);
		Object objectAtToPosition = getObjectAtPosition(to); 
		if (objectAtToPosition instanceof Tile) {
			Tile tileAtToPosition = (Tile)objectAtToPosition;
			if(tileAtToPosition.getTypeString().equals(GameConstants.OCEANS) || tileAtToPosition.getTypeString().equals(GameConstants.MOUNTAINS)) {
				return false; 
			}
		}
		if (objectAtFromPosition instanceof Unit) {
			Unit unitAtFromPosition = (Unit)objectAtFromPosition; 
			if(unitAtFromPosition.getOwner() != playerInTurn){
				return false; 
			}
			if (Math.abs(to.getRow() - from.getRow()) <= 1 && Math.abs(to.getColumn() - from.getColumn()) <= 1) {
				board[to.getRow()][to.getColumn()] = objectAtFromPosition;
				board[from.getRow()][from.getColumn()] = null;
				return true;
			}
		}
		return false;
	}

	public void endOfTurn() {
		if (playerInTurn == Player.RED){
			playerInTurn = Player.BLUE;
		} else {
			playerInTurn = Player.RED;
			age += GameConstants.YEARSPERROUND;
		}
	}

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
	}

	public void changeProductionInCityAt(Position p, String unitType) {
	}

	public void performUnitActionAt(Position p) {
	}
	
	private Object getObjectAtPosition(Position p) {
		return board[p.getRow()][p.getColumn()];
	}
}
