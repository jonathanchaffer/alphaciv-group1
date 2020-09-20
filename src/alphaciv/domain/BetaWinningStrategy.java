package alphaciv.domain;

public class BetaWinningStrategy implements WinningStrategy {

	@Override
	public Player getWinner(int age, City[][] cities) {
		Player ownerOfFirstCity = null;
		for(int i = 0; i < cities.length; i++) {
			for(int j = 0; j < cities[i].length; j++) {
				City city = cities[i][j];
				if(city != null) {
					if(ownerOfFirstCity == null) {
						ownerOfFirstCity = city.getOwner();
					} else {
						if(city.getOwner() != ownerOfFirstCity) {
							return null;
						}
					}
				}
			}
		}
		return ownerOfFirstCity;
	}

}
