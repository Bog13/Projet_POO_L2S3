package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public interface Meetable
{
    /**
     * @param s Steerable entrant en collision avec l'instance courante
     */
    abstract public void  collideWith(Steerable s);
}
