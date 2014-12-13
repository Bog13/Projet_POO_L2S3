import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    private boolean stepByStep;
    private ArrayList<Steerable> steerable;
    private Board board;
    private int nbRemaindTile;
    private int timer;

    public Game(int width,int height, boolean sbs)
    {
	this.stepByStep = sbs;
	this.steerable = new ArrayList<Steerable>();
	this.board = new Board(width,height);

	int wallWidth = 1;
	this.nbRemaindTile = (this.board.getWidth()-wallWidth*2) * (this.board.getHeight()-wallWidth*2);
	
	this.timer = 100;//en param ?
    }

    public Game(int width,int height)
    {
	this(width,height,false);
	
    }

    public void initAlea(int n, int o)
    {
	fillObstacle(o);
	fillNPC(n);
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

    public void executeGame()
    {
	initAlea(50,30);
	execute();
    }

    private void executeTestCollisionNPC(boolean firstPetrified, boolean secondPetrified,int posY,int offset)
    {	
	//walker vs walker
	Walker s1 = new Walker(new Position(10,posY));
	Walker s2 = new Walker(new Position(this.board.getWidth()-10,posY));
	s1.setDirection(new Direction(1,0));
	s2.setDirection(new Direction(-1,0));
	s1.setIsPetrified(firstPetrified);
	s2.setIsPetrified(secondPetrified);
	addSteerable(s1);addSteerable(s2);
	
	posY += offset;
	
	//walker vs stoner
	Walker s3 = new Walker(new Position(10,posY));
	Stoner s4 = new Stoner(new Position(this.board.getWidth()-10,posY));
	s3.setDirection(new Direction(1,0));
	s4.setDirection(new Direction(-1,0));
	s3.setIsPetrified(firstPetrified);
	s4.setIsPetrified(secondPetrified);
	addSteerable(s3);addSteerable(s4);

	posY += offset;

	//walker vs ressurector
	Walker s5 = new Walker(new Position(10,posY));
	Resurrector s6 = new Resurrector(new Position(this.board.getWidth()-10,posY));
	s5.setDirection(new Direction(1,0));
	s6.setDirection(new Direction(-1,0));
	s5.setIsPetrified(firstPetrified);
	s6.setIsPetrified(secondPetrified);
	addSteerable(s5);addSteerable(s6);

	posY += offset;

	//stoner vs stoner
	Stoner s7 = new Stoner(new Position(10,posY));
	Stoner s8 = new Stoner(new Position(this.board.getWidth()-10,posY));
	s7.setDirection(new Direction(1,0));
	s8.setDirection(new Direction(-1,0));
	s7.setIsPetrified(firstPetrified);
	s8.setIsPetrified(secondPetrified);
	addSteerable(s7);addSteerable(s8);

	posY += offset;

	//stoner vs ressurector
	Stoner s9 = new Stoner(new Position(10,posY));
        Resurrector s10 = new Resurrector(new Position(this.board.getWidth()-10,posY));
	s9.setDirection(new Direction(1,0));
	s10.setDirection(new Direction(-1,0));
	s9.setIsPetrified(firstPetrified);
	s10.setIsPetrified(secondPetrified);
	addSteerable(s9);addSteerable(s10);

	posY += offset;

	//resurrector vs ressurector
	Resurrector s11 = new Resurrector(new Position(10,posY));
        Resurrector s12 = new Resurrector(new Position(this.board.getWidth()-10,posY));
	s11.setDirection(new Direction(1,0));
	s12.setDirection(new Direction(-1,0));
	s11.setIsPetrified(firstPetrified);
	s12.setIsPetrified(secondPetrified);
	addSteerable(s11);addSteerable(s12);

	posY += offset;

	
    }

    public void executeTestCollisionNPC()
    {
	executeTestCollisionNPC(false,false,1,2);
	executeTestCollisionNPC(false,true,15,2);
	executeTestCollisionNPC(true,false,30,2);
	execute();   
    }

    //lance la simualtion
    private void execute()
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
			    
			    Thread.sleep(this.timer);
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
	NPC currentNPC = (NPC)s;

	
	
	if( isFree(nextPos) )
	    {
		// tout va bien, deplacement
		if(!currentNPC.getIsPetrified()) s.setPosition( nextPos );
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
	else System.out.println("Impossible d'ajouter un steerable !"); // TODO exception ?

    }

    public ArrayList<Steerable> getSteerables()
    {
	return this.steerable;
    }


}
