// None Playable Character --> NPC
// car Character est une classe java
 
public abstract class NPC implements Steerable, Meetable
{
    protected Position pos;
    protected Direction dir;
    protected String id;
    protected boolean isPetrified;

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

    //Steerable
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

    //Meetable
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
