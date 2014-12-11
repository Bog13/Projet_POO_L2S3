public class Walker extends NPC
{
    public Walker(Position pos)
    {
	super(pos,"walker");
    }

    public String toString()
    {
	return "O";
    }


    //Meetable
    public void collideWith(Steerable s)
    {
	///TODO
    }


    

    
}
