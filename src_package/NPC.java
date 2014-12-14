package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * None Playable Character ( NPC )
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public abstract class NPC implements Steerable, Meetable
{
    protected Position pos;
    protected Direction dir;
    protected String id;
    protected boolean isPetrified;

    /**
     * @param pos Position du NPC
     * @param id Identifiant du NPC
     */
    public NPC(Position pos, String id)
    {
	this.pos = new Position(pos);
	
	int x,y;
	
	do
	    {
		x = (int)(Math.random()*4 -2);
		y = (int)(Math.random()*4 -2);
	    } while(x==0 && y==0);
	
	this.dir = new Direction(x ,y);
	

	this.id = id;

	this.isPetrified = false;
    }

    
    abstract public String toString();
    

    public void setIsPetrified(boolean petrified)
    {
	this.isPetrified = petrified;
    }

    public boolean getIsPetrified()
    {
	return this.isPetrified;
    }

    //Methode de Steerable
    public Direction getDirection()
    {
	return this.dir;
    }

    public void setDirection(Direction dir)
    {
	this.dir = new Direction(dir);
    }

    public Position getPosition()
    {
	return new Position(this.pos);
    }
    
    
    public void setPosition(Position pos)
    {
	this.pos = new Position(pos);
    }

    //Methode de Meetable


    /**
     * @param s Steerable dont la direction change lors de la collision avec l'instance courante du NPC
     */
    public void collideWith(Steerable s)
    {
	NPC n = (NPC)s;

	if(!n.getIsPetrified())
	    {
		s.getDirection().setDx(-s.getDirection().getDx());	
		s.getDirection().setDy(-s.getDirection().getDy());
	    }

	
    }

    
   

   
}
