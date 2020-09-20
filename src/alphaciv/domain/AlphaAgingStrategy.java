package alphaciv.domain;

public class AlphaAgingStrategy implements AgingStrategy {

	@Override
	public int getNewAge(int currentAge) {
		return currentAge + 100;
	}

}
