/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Position
{
    private int x;
    private int y;

    /**
     * @param x int representant l'abscisse de la position a construire 
     * @param y int representant l'ordonnee de la position a construire
     */
    public Position(int x,int y)
    {
	this.x = x;
	this.y = y;
    }


    /**
     * @param pos Position recopiee pour la construction
     */
    public Position(Position pos)
    {
	this.x = pos.x;
	this.y = pos.y;
    }

    public int getX()
    {
	return this.x;
    }

    public int getY()
    {
	return this.y;
    }

    public void setX(int x)
    {
	this.x = x;
    }

    public void setY(int y)
    {
	this.y = y;
    }

    /**
     * @param pos Position a comparer avec l'instance courante
     * @return boolean true si les composantes de pos et de l'instance courante sont egales une a une
     */
    public boolean equals(Position pos)
    {
	return (pos.x == this.x && pos.y == this.y);
    }
}
