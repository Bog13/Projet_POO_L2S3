public abstract class Obstacle extends Tile{

	protected Position pos;

	protected Obstacle(Position p){
	    super(p);
	}

	abstract public String toString ();

}

