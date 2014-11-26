public class Stoner extends NPC
{
    public Stoner(Position pos)
    {
	super(pos,"stoner");
    }

    public String toString()
    {
	return "X";
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
