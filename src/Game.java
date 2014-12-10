import java.util.ArrayList;

public class Game
{
    private boolean stepByStep;
    private ArrayList<Steerable> steerable;
    private Board board;
    private int nbRemaindTile;

    public Game(int width,int height, boolean sbs)
    {
	this.stepByStep = sbs;
	this.steerable = new ArrayList<Steerable>();
	this.board = new Board(width,height);

	int wallWidth = 1;
	this.nbRemaindTile = (this.board.getWidth()-wallWidth*2) * (this.board.getHeight()-wallWidth*2);
	

	fillObstacle();
    }

    public Game(int width,int height)
    {
	this(width,height,false);
	
    }
    
    private void fillObstacle()
    {
	Obstacle o = new Spin( getRandomFreePosition() );

	for(int i = 0 ; i<50; i++)
	    {
		this.board.addTile(o);
	    }

	
    }
    
    private void fillNPC()
    {
	
    }
    
    public Board getBoard()
    {
	return this.board;
    }

    //lance la simualtion
    public void execute()
    {
    }

    //calcul le prochain état de la simulation
    private void nextStep()
    {
	for(Steerable s: this.steerable)
	    {
		
	    }
    }

    //affiche l'état courant
    public String toString()
    {

        String res = "";
	NPC npc_at;

	for(int i=0; i<this.board.getHeight(); i++)
	    {
		for(int j=0; j<this.board.getWidth(); j++)
		    {
			npc_at = NPCat(new Position(j,i));

			if( npc_at != null )
			    {
				res += npc_at;
			    }
			else
			    {
				res += this.board.getTile(j,i);
			    }
		    }
		res += '\n';
	    }
	
	return res;
	
    }

    //retourne le NPC à la position pos ou null
    public NPC NPCat(Position pos)
    {
	NPC res = null;
	Steerable temp = null;

	int i = 0;
	
	while(temp == null && i < this.steerable.size() && this.steerable.size() !=0 )
	    {

		if( this.steerable.get(i).getPosition().equals(pos) )
		    {
			temp = this.steerable.get(i);
		    }

		i++;
	    }



	res = ((NPC)temp);

	return res; 
    }

    public boolean isValid(Position pos)
    {
	return (pos.getX()>=0 && pos.getX() < this.board.getWidth()
		&& pos.getY()>=0 && pos.getY() < this.board.getHeight());
    }

    public boolean isFree(Position pos)
    {
	return ( isValid(pos) 
		 && NPCat(pos) == null  
		 && this.board.getTile(pos.getX(),pos.getY()) instanceof Empty   );				       
    }

    public Position getRandomFreePosition()
    {
	Position res = new Position(0,0);
	final int it_max = this.nbRemaindTile;
	int it = 0;

	do
	    {
		res.setX(   (int)(Math.random()*this.board.getWidth() )  );
		res.setY(   (int)(Math.random()*this.board.getHeight() )  );
		it++;
	    }
	while( !isFree(res) && it < this.nbRemaindTile);

	return res;
    }

    public void addSteerable(Steerable s)
    {
	if( isFree(s.getPosition()) )
	    {
		this.steerable.add(s);
	    }

    }

    public ArrayList<Steerable> getSteerables()
    {
	return this.steerable;
    }


}
