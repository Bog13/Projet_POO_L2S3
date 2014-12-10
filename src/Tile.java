public abstract class Tile {

    protected Position pos;
    protected String id;

    protected Tile(String id,Position p){
	this.pos=p;
	this.id = id;
    }

    public Position getPosition()
    {
	return new Position(this.pos);
    }

    public String getId()
    {
	return this.id;
    }

    abstract public String toString();

}
