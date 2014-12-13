/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public abstract class Tile {

    protected Position pos;
    protected String id;

    /**
     * @param id Identifiant de la Tile
     * @param p Position de construction de la Tile
     */
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
