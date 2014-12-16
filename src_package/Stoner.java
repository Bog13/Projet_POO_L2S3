package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;

/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Stoner extends NPC implements StoneModificator
{
    /**
     * @param pos Position ou doit etre construit le Stoner
     */
    public Stoner(Position pos)
    {
	super(pos,"stoner");
    }

    public String toString()
    {
	if(this.isPetrified) return "x";
	return "X";
    }

    
    //Methode de Meetable

    /**
     * @param s Steerable dont l'etat de petrification va etre modifie
     */
    public void collideWith(Steerable s)
    {
	super.collideWith(s);

	NPC n = (NPC)(s);
	petrifiedModificator(n);
    }

    /**
     * @param petrified NPC qui est petrifie par le Stoner de l'instance courante
     */
    public void petrifiedModificator(NPC petrified)
    {
	petrified.setIsPetrified(true);
    }

   



    
}
