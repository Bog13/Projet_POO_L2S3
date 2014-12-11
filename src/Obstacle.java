public abstract class Obstacle extends Tile implements Meetable {

    protected Position pos;

    protected Obstacle(String id,Position p){
	super(id,p);
    }

    abstract public String toString ();

    public abstract void collideWith(Steerable s);
    
}

