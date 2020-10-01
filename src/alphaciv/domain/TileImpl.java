package alphaciv.domain;

public class TileImpl implements Tile {
	String type;

	public TileImpl(String type) {
		this.type = type;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeString() {
		return type;
	}

}
