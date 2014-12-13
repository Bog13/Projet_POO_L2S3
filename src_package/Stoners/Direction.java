package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Direction
{
    private int dx;
    private int dy;
    
    /**
     * @param dx int representant la direction de l'instance a construire suivant l'axe des abscisses
     * @param dy int representant la direction de l'instance a construire suivant l'axe des ordonnees 
     */
    public Direction(int dx,int dy)
    {
	this.dx = format(dx);
	this.dy = format(dy);
    }

    /**
     *Construit une direction par defaut
     */
    public Direction()
    {
	this(0,0);
    }


    /**
     * @param d Direction recopiee pour la construction
     */
    public Direction(Direction d)
    {
	this.dx = d.dx;
	this.dy = d.dy;
    }

    /**
     * assure la coherence de dx et dy pour le constructeur
     * @param n int a formater 
     * @return int formate a 0, 1 ou -1 selon le signe de n
     */
    public int format(int n)
    {
	if(n > 0) return 1;
	if(n < 0) return -1;
	return 0;
    }

    /**
     * assure la coherence de la direction en applicant format(int n) sur chacune des composantes de l'instance courante
     */
    public void format()
    {
        this.dx = format(this.dx);
	this.dy = format(this.dy);
    }

    public int getDx()
    {
	return this.dx;
    }

    public int getDy()
    {
	return this.dy;
    }

    public void setDx(int dx)
    {
	this.dx = dx;
    }

    public void setDy(int dy)
    {
	this.dy = dy;
    }
}
