/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Board {

    final private int height;
    final private int width;
    private Tile [][] matTile;
    private Game game;
 
   
    /**
     * @param height int representant la hauteur du plateau a construire
     * @param width int representant la largeur du plateau a construire
     */
    public Board (int height, int width){
	this.height=height;
	this.width=width;

	matTile=new Tile[height][width];
	
	addWall();
	
    }

    /**
     * construit un plateau de 20x20
     */
     public Board(){
	this(20,20);
    }

    

    /**
     * Ajoute des murs autour du plateau et rempli le centre de vide
     */
    private void addWall()
    {
	for(int i=0; i<this.height; i++)
	    {
		for(int j=0; j<this.width; j++)
		    {
			if( i == 0 || i == this.height - 1 || j ==0 || j == this.width - 1)
			    {
				this.matTile[i][j] = new Wall(new Position(j,i));
			    }
			else
			    {
			       this.matTile[i][j] = new Empty(new Position(j,i));
			    }
		    }
	
	    }
    }


	



    public int getHeight(){
	return (this.height);
    }

    public int getWidth(){
	return (this.width);
    }

    public Tile getTile(int x, int y){
	return (matTile[y][x]);
    }

    public Tile getTile(Position pos){
	return getTile(pos.getX(),pos.getY());
    }

    
    /**
     * @param t Tile a ajouter a l'instance courante du plateau
     */
    public void addTile(Tile t)
    {
	if( t != null )
	    {
		this.matTile[t.getPosition().getY()][t.getPosition().getX()] = t;
	    }
    }

    public String toString()
    {
	String res = "";

	for(int i=0; i<this.height; i++)
	    {
		for(int j=0; j<this.width; j++)
		    {
			res += matTile[i][j];
		    }
		res += '\n';
	    }

	return res;
    }
		

}
