public abstract class Obstacle extends Tile implements Generable{

    protected Position pos;

    protected Obstacle(String id,Position p){
	super(id,p);
    }

    abstract public String toString ();
    
    //Generable
    public void generate(Game g, int nb)
    {
	///TODO
    }
}

