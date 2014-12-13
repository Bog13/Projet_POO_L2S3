/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public interface StoneModificator
{

    /**
     * @param petrified NPC dont l'etat de petrification va etre modifie par le StoneModificator
     */
    abstract void petrifiedModificator(NPC petrified);
}
