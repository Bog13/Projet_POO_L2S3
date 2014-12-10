public class Wall extends Obstacle {

    private Position pos;

    protected Wall(Position p){
	super("wall",p);
    }

    public String toString(){
	return ("#");
    }

    public void generate(Game g, int nb)
    {
	
    }

    
	
}

