package alphaciv.domain;

public class GammaUnitActionStrategy implements UnitActionStrategy {

	@Override
	public void performUnitAction(Position p, Unit[][] units) {

		if(units[p.getRow()][p.getColumn()].getTypeString() == GameConstants.SETTLER){
			units[p.getRow()][p.getColumn()] = null;		
		}
	}

}
