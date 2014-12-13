/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Empty extends Tile {

    private Position pos;

    /**
     * @param p Position ou construire la Tile Empty
     */
    protected Empty(Position p){
	super("empty",p);
    }

    public String toString(){
	return (".");
    }	

}

