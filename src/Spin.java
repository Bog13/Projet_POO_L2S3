public class Spin extends Obstacle {

    private Position pos;

    protected Spin(Position p){
	super("spin",p);
    }

    public String toString(){
	return ("@");
    }	

    public  void generate(Game g, int nb)
    {
	
    }
	
}

