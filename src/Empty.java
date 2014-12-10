public class Empty extends Tile {

    private Position pos;

    protected Empty(Position p){
	super("empty",p);
    }

    public String toString(){
	return (".");
    }	

}

