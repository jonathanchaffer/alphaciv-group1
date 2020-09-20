package alphaciv.domain;

public interface WinningStrategy {
	public Player getWinner(int age, City[][] cities);
}
