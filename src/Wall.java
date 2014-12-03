public class Wall extends Obstacle {

	private Position pos;

	protected Wall(Position p){
		super(p);
	}

	public String toString(){
		return ("#");
	}	
	
}

