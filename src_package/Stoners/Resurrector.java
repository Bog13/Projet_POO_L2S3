package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Resurrector extends NPC implements StoneModificator
{
     /**
     * @param pos Position ou doit etre construit le Resurrector
     */
    public Resurrector(Position pos)
    {
	super(pos,"resurrector");
    }

    public String toString()
    {
	if(this.isPetrified)return "r";
	return "R";
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
     * @param petrified NPC qui est depetrifie par le Stoner Resurrector de l'instance courante
     */
    public void petrifiedModificator(NPC petrified)
    {
	petrified.setIsPetrified(false);
    }
    
    
}
