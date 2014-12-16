package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public abstract class Obstacle extends Tile implements Meetable {

    protected Position pos;

    /**
     * @param id Identifiant de l'obstacle a construire
     * @param p Position de l'obstacle a construire
     */
    public Obstacle(String id,Position p){
	super(id,p);
    }

    abstract public String toString ();

    public abstract void collideWith(Steerable s);
    
}

