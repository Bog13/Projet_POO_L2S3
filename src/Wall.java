public class Wall extends Obstacle {

    private Position pos;

    protected Wall(Position p){
	super("wall",p);
    }

    public String toString(){
	return ("#");
    }

    public void collideWith(Steerable s)
    {
	float angle = (float)( - Math.PI/2 );
	Direction dir = s.getDirection();
	
	int x = dir.getDx();
	int y = dir.getDy();
	
	int x2 = (int)( (Math.cos(angle) * x + Math.sin(angle) * y) * 1.4 );
	int y2 = (int)((-Math.sin(angle) * x + Math.cos(angle) * y) * 1.4);

	dir.setDx(x2);
	dir.setDy(y2);

    }

    
	
}

