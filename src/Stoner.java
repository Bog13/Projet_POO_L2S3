public class Stoner extends NPC implements StoneModificator
{
    public Stoner(Position pos)
    {
	super(pos,"stoner");
    }

    public String toString()
    {
	if(this.isPetrified) return "x";
	return "X";
    }

    
    //Meetable
    public void collideWith(Steerable s)
    {
	super.collideWith(s);

	NPC n = (NPC)(s);
	petrifiedModificator(n);
    }

    public void petrifiedModificator(NPC petrified)
    {
	petrified.setIsPetrified(true);
    }

   



    
}
