public class Direction
{
    private int dx;
    private int dy;

    public Direction(int dx,int dy)
    {
	this.dx = format(dx);
	this.dy = format(dy);
    }

    public Direction()
    {
	this(0,0);
    }

    //constructeur de "recopie"
    public Direction(Direction d)
    {
	this.dx = d.dx;
	this.dy = d.dy;
    }

    //assure la cohérence de dx et dy pour le constructeur
    public int format(int n)
    {
	if(n > 0) return 1;
	if(n < 0) return -1;
	return 0;
    }

    //assure la cohérence de la direction
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
