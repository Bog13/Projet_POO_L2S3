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


    //Meetable
    public void collideWith(Steerable s)
    {
	///TODO
    }

   

    
}
