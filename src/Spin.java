public class Spin extends Obstacle {

    private Position pos;

    protected Spin(Position p){
	super("spin",p);
    }

    public String toString(){
	return ("@");
    }	

    public void collideWith(Steerable s)
    {
	Direction dir = s.getDirection();
	
	int x = dir.getDx();
	int y = dir.getDy();
	
	int x2 = ((int)(Math.random() * 4 )- 2);
	int y2 = ((int)(Math.random() * 4 )- 2);

	dir.setDx(x2);
	dir.setDy(y2);

	dir.format();

        
        
    }
	
}

