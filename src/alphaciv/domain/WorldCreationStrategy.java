package alphaciv.domain;

public interface WorldCreationStrategy {
	public void createWorld(Tile[][] tiles, Unit[][] units, City[][] cities);
}
