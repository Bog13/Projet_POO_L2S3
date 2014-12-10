public abstract class NPC implements Steerable, Meetable, Generable
{
    protected Position pos;
    protected Direction dir;
    protected String id;
    protected boolean isPetrified;

    public NPC(Position pos, String id)
    {
	this.pos = new Position(pos);
	this.id = id;

	isPetrified = true;
    }

    
    abstract public String toString();
    

    public void setIsPetrified(boolean petrified)
    {
	isPetrified = petrified;
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

    //Meetable
    public void collideWith(Steerable s)
    {
	///TODO
    }

    //Generable
    public abstract void generate(Game g, int nb);
   

   
}
