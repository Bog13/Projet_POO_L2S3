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
    public void generate(Game g, int nb)
    {

    }

    
}
