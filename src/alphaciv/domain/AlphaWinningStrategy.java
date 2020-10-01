package alphaciv.domain;

public class AlphaWinningStrategy implements WinningStrategy {
	public Player getWinner(int age, City[][] cities) {
		if (age == -3000) {
			return Player.RED;
		}
		return null;
	}
}
