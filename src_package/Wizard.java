package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Berenger OSSETE GOMBE
 */
public class Wizard extends NPC implements StoneModificator
{
     /**
     * @param pos Position ou doit etre construit le Wizard
     */
    public Wizard(Position pos)
    {
	super(pos,"wizard");
    }

    public String toString()
    {
	if(this.isPetrified)return "w";
	return "W";
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
     * @param petrified NPC qui est petrifie ou depetrifie par le Wizard de l'instance courante
     */
    public void petrifiedModificator(NPC petrified)
    {   
        if(petrified instanceof Stoner)
	    {
		petrified.setIsPetrified(true);
	    } else petrified.setIsPetrified(false);
    }
    
    
}

