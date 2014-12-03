public class Direction
{
    private int dx;
    private int dy;

    public Direction(int dx,int dy)
    {
	this.dx = dx;
	this.dy = dy;
    }

    //constructeur de "recopie"
    public Direction(Direction d)
    {
	this.dx = d.dx;
	this.dy = d.dy;
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
