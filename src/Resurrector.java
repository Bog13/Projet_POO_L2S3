public class Resurrector extends NPC implements StoneModificator
{
    public Resurrector(Position pos)
    {
	super(pos,"resurrector");
    }

    public String toString()
    {
	if(this.isPetrified)return "r";
	return "R";
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
	petrified.setIsPetrified(false);
    }
    
    
}
