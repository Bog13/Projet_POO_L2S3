/**
 * @author Berenger OSSETE GOMBE
 */
public class Vampire extends NPC implements StoneModificator 
{
    private Game game;
     /**
     * @param pos Position ou doit etre construit le Wizard
     * @param g Game dans lequel le vampire peut se teleporter
     */
    public Vampire(Position pos,Game g)
    {
	super(pos,"vampire");
	this.game = g;
    }

    public String toString()
    {
	if(this.isPetrified)return "v";
	return "V";
    }


   
     //Methode de Meetable

    /**
     * @param s Steerable dont l'etat de petrification va etre modifie
     */
    public void collideWith(Steerable s)
    {
	super.collideWith(s);
	
        NPC n = (NPC)s;
	petrifiedModificator(n);
	this.pos = new Position(this.game.getRandomFreePosition());

    }
    
    /**
     * @param petrified NPC qui est petrifie  par le Vampire de l'instance courante
     */
    public void petrifiedModificator(NPC petrified)
    {   
        
	petrified.setIsPetrified(true);
	
    }
    
    
}

