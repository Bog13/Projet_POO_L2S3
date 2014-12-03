public class Empty extends Tile {

	private Position pos;

	protected Empty(Position p){
		super(p);
	}

	public String toString(){
		return (".");
	}	

}

