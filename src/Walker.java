public class Walker extends NPC
{
    public Walker(Position pos)
    {
	super(pos,"walker");
    }

    public String toString()
    {
	if(this.isPetrified)return "o";
	return "O";
    }


    //Meetable
    public void collideWith(Steerable s)
    {
	super.collideWith(s);
	///TODO
    }


    

    
}
