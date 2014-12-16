package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Spin extends Obstacle {

    private Position pos;

    /**
     * @param p Position de construction du Spin
     */
    public Spin(Position p){
	super("spin",p);
    }

    public String toString(){
	return ("@");
    }	

    /**
     * @param s Steerable dont la direction est modifiee aleatoirement lors de sa collision avec l'instante courante de Spin
     */
    public void collideWith(Steerable s)
    {
	Direction dir = s.getDirection();
	
	int x = dir.getDx();
	int y = dir.getDy();
	
	int x2; 
	int y2; 
	
	do
	    {
		x2 = ((int)(Math.random() * 4 )- 2);
		y2 = ((int)(Math.random() * 4 )- 2);
	    }
	while(x2 == 0 && y2 ==0);
	
	dir.setDx(x2);
	dir.setDy(y2);

	dir.format();

        
        
    }
	
}
