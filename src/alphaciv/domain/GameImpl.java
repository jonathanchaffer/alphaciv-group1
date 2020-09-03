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
		playerInTurn = Player.RED;
	}
	
	public Tile getTileAt(Position p) {
		return null;
	}

	public Unit getUnitAt(Position p) {
		return null;
	}

	public City getCityAt(Position p) {
		Object objectAtPosition = board[p.getRow()][p.getColumn()];
		if(objectAtPosition instanceof City) {
			return (City) objectAtPosition;
		}
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
	}

	public void changeWorkForceFocusInCityAt(Position p, String balance) {
	}

	public void changeProductionInCityAt(Position p, String unitType) {
	}

	public void performUnitActionAt(Position p) {
	}
}
