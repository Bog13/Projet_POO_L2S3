public class Resurrector extends NPC
{
    public Resurrector(Position pos)
    {
	super(pos,"resurrector");
    }

    public String toString()
    {
	return "R";
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

    //Meetable
    public void collideWith(Steerable s)
    {
	///TODO
    }

    //Generable
    public void generate(Board b, float p)
    {
	///TODO
    }

    
}
