import java.util.ArrayList;
import java.util.Scanner;

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
	

	fillNPC(100);
	fillObstacle(50);
    }

    public Game(int width,int height)
    {
	this(width,height,false);
	
    }
    
    private void fillObstacle(int nb)
    {
	//pour ajouter un type d'obstacle, il suffit d'incrémenter nbObstacle et de 
	// rajouter un case au switch
	Obstacle o = null;
	final int nbObstacle = 2;
	int randNum;

	for(int i = 0 ; i<nb; i++)
	    {
		randNum = (int)(Math.random()*nbObstacle); 
		
		switch(randNum)
		    {
		    case 0:
			o = new Spin( getRandomFreePosition() );
			break;

		    case 1:
			o = new Wall( getRandomFreePosition() );
			break;

			
		    }

		if(o != null) this.board.addTile(o);
	    }

	
    }

    
    private void fillNPC(int nb)
    {

	//pour ajouter un type d'obstacle, il suffit d'incrémenter nbObstacle et de 
	// rajouter un case au switch
	NPC n = null;
	final int nbNPC = 3;
	int randNum;

	for(int i = 0 ; i<nb; i++)
	    {
		randNum = (int)(Math.random()*nbNPC); 
		
		switch(randNum)
		    {
		    case 0:
			n = new Walker( getRandomFreePosition() );
			break;

		    case 1:
			n = new Resurrector( getRandomFreePosition() );
			break;
			
		    case 2:
			n = new Stoner( getRandomFreePosition() );
			break;

			
		    }

		if(n != null) this.addSteerable(n);
	    }

	
    
    }
    
    public Board getBoard()
    {
	return this.board;
    }

    //lance la simualtion
    public void execute()
    {
	Scanner sc = new Scanner(System.in);

	while( true ) // TODO sortie du programme propre
	    {
		System.out.println(this);
		nextStep();
		
		if( this.stepByStep )
		    {
			sc.next();// TODO meilleure saisie clavier
		    }
		else
		    {
			try{
			    
			    Thread.sleep(10);
			}catch(Exception e){e.printStackTrace();}
		    }
	    }
    }

    //calcul le prochain état de la simulation
    private void nextStep()
    {
	for(Steerable s: this.steerable)
	    {
		nextStep(s);
	    }
    }

    //calcul le prochain etat d'un steerable s
    private void nextStep(Steerable s)
    {
	Position nextPos = new Position(
	s.getPosition().getX() + s.getDirection().getDx(),
	s.getPosition().getY() + s.getDirection().getDy()   );
	
	Meetable m = null;
	NPC potentialNPC = null;

	if( isFree(nextPos) )
	    {
		// tout va bien, deplacement
		s.setPosition( nextPos );
	    }
	else
	    {
		// entre en collision
		potentialNPC = NPCat(nextPos);


		if( potentialNPC == null )
		    {
			// avec un obstacle
			m = (Meetable)this.board.getTile(nextPos);
		    } 
		else 
		    {
			// avec un npc
			m = potentialNPC;
		    }

		m.collideWith(s);
		
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
