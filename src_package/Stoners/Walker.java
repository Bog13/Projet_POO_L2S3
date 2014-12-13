package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Walker extends NPC
{
    /**
     * @param pos Position ou doit etre construit le Walker
     */
    public Walker(Position pos)
    {
	super(pos,"walker");
    }

    public String toString()
    {
	if(this.isPetrified)return "o";
	return "O";
    }


   


    

    
}
