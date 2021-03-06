package fr.univfcomte.sDumontet_bOsseteGombe.Stoners;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public class Game 
{
    private boolean stepByStep;
    private ArrayList<Steerable> steerable;
    private Board board;
    private int nbRemaindTile;
    private int timer;
    private final int stepMax;
    private int currentStep;


    /**
     *
     *  @param width Largeur du plateau
     *  @param height Hauteur du plateau
     *  @param sbs Etat du mode pas-a-pas
     */
    public Game(int width,int height, boolean sbs)
    {
	this.stepByStep = sbs;
	this.steerable = new ArrayList<Steerable>();
	this.board = new Board(width,height);

	this.stepMax = 500;
	this.currentStep = 0;

	int wallWidth = 1;
	this.nbRemaindTile = (this.board.getWidth()-wallWidth*2) * (this.board.getHeight()-wallWidth*2);
	
	this.timer = 100;//en param ?

	
    }

    /**
     *  @param width Largeur du plateau
     *  @param height Hauteur du plateau
     */
    public Game(int width,int height)
    {
	this(width,height,false);
	
    }


    /**
     * @param n Nombre de NPCs a generer
     * @param o Nombre d'obstacles a generer
     */
    public void initAlea(int n, int o)
    {
	fillObstacle(o);
	fillNPC(n);
    }
    
    /**
     * @param nb Nombre d'obstacle a ajouter au Board
     */
    private void fillObstacle(int nb)
    {
	//pour ajouter un type d'obstacle, il suffit d'incrementer nbObstacle et de 
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

    /**
     * @param nb Nombre de NPC a ajouter
     * 
     */
    private void fillNPC(int nb)
    {

	//pour ajouter un type d'obstacle, il suffit d'incrementer nbObstacle et de 
	// rajouter un case au switch
	NPC n = null;
	final int nbNPC = 5;
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

		    case 3:
			n = new Wizard( getRandomFreePosition() );
			break;

		    case 4:
			n = new Vampire( getRandomFreePosition(), this);
			break;

			
		    }

		if(n != null) this.addSteerable(n);
	    }

	
    
    }
    
    
    public Board getBoard()
    {
	return this.board;
    }


    /**
     * Permet de lancer le jeu avec des parametres par defauts
     * 
     */
    public void executeGame()
    {
	int nbTile = (this.board.getWidth()-2) *( this.board.getHeight() -2);
	initAlea((int)(nbTile * 0.01),(int)(nbTile * 0.01));
	execute();
    }

    /**
     * @param a NPC qui entre en collision avec b
     * @param firstPetrified Defini si a est petrifie 
     * @param b NPC qui entre en collision avec a
     * @param secondPetrified Defini si b est petrifie
     * 
     */
    private void executeTestBeetween(NPC a, boolean firstPetrified, NPC b,boolean secondPetrified)
    {
	
	a.setDirection(new Direction(1,0));
	b.setDirection(new Direction(-1,0));
	a.setIsPetrified(firstPetrified);
	b.setIsPetrified(secondPetrified);
	addSteerable(a);addSteerable(b);
    }
	
    /**
     * @param firstPetrified Defini si la premiere range de test est petrifiee 
     * @param secondPetrified Defini si la seconde range de test est petrifiee
     * @param posY Ordonnee de la premiere ligne de test
     * @param offset Espace entre chaque ligne de test
     * 
     */
    private void executeTestCollisionNPC(boolean firstPetrified, boolean secondPetrified,int posY,int offset)
    {	
	//walker vs walker
	Walker s1 = new Walker(new Position(10,posY));
	Walker s2 = new Walker(new Position(this.board.getWidth()-10,posY));
	executeTestBeetween(s1,firstPetrified,s2,secondPetrified);
	
	posY += offset;
	
	//walker vs stoner
	Walker s3 = new Walker(new Position(10,posY));
	Stoner s4 = new Stoner(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s3,firstPetrified,s4,secondPetrified);

	posY += offset;

	//walker vs ressurector
	Walker s5 = new Walker(new Position(10,posY));
	Resurrector s6 = new Resurrector(new Position(this.board.getWidth()-10,posY));
	executeTestBeetween(s5,firstPetrified,s6,secondPetrified);

	posY += offset;

	//stoner vs stoner
	Stoner s7 = new Stoner(new Position(10,posY));
	Stoner s8 = new Stoner(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s7,firstPetrified,s8,secondPetrified);

	posY += offset;

	//stoner vs ressurector
	Stoner s9 = new Stoner(new Position(10,posY));
        Resurrector s10 = new Resurrector(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s9,firstPetrified,s10,secondPetrified);

	posY += offset;

	//resurrector vs ressurector
	Resurrector s11 = new Resurrector(new Position(10,posY));
        Resurrector s12 = new Resurrector(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s11,firstPetrified,s12,secondPetrified);
	
	posY += offset;

	//wizard vs walker
	Wizard s13 = new Wizard(new Position(10,posY));
        Walker s14 = new Walker(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s13,firstPetrified,s14,secondPetrified);
	posY += offset;
	

	//wizard vs stoner
	Wizard s15 = new Wizard(new Position(10,posY));
        Stoner s16 = new Stoner(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s15,firstPetrified,s16,secondPetrified);
	posY += offset;
	
	//vampire vs stoner
	Vampire s17 = new Vampire(new Position(10,posY),this);
        Stoner s18 = new Stoner(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s17,firstPetrified,s18,secondPetrified);
	posY += offset;

	//vampire vs walker
	Vampire s19 = new Vampire(new Position(10,posY),this);
        Walker s20 = new Walker(new Position(this.board.getWidth()-10,posY));
        executeTestBeetween(s19,firstPetrified,s20,secondPetrified);
	posY += offset;
    }



    /**
     * lance le jeu pour une serie de tests
     * 
     */
    public void executeTestCollisionNPC()
    {
	executeTestCollisionNPC(false,false,1,1);
	executeTestCollisionNPC(false,true,15,1);
	executeTestCollisionNPC(true,false,30,1);
	execute();   
    }
    


    /**
     * Affiche une page de presentation/ instruction avant l'execution du jeu
     * 
     */
    private void infoGame()
    {

	InputStreamReader lecteur=new InputStreamReader(System.in);
	int keyValue = 0;

	for(int i=0; i<100; i++)System.out.println();

	System.out.println("STONERS : Les pétrifieurs\n");
	if(this.stepByStep) 
	    {
		System.out.println("MODE pas-à-pas activ");
		System.out.println("Une fois la simulation lancée,appuyez sur la touche <ENTRÉE> pour passer au PAS SUIVANT");
		System.out.println("Une fois la simulation lancée,appuyez sur la touche <q> pour QUITTER");
	    }
	else System.out.println("MODE pas-à-pas désactivé");

	
	System.out.println("\n\nAppuyez sur <ENTRÉE> pour continuer..");

	for(int i=0; i<40; i++)System.out.println();
	
	while(keyValue == 0)
	    {

		try
		    {
			keyValue = lecteur.read();
			
		    }
		catch(Exception e){keyValue=0;}

	    }
	  
    }


    /**
     * Lance le jeu
     * 
     */
    private void execute()
    {
	Scanner sc = new Scanner(System.in);
	InputStreamReader lecteur=new InputStreamReader(System.in);
	int keyValue = 0;
	boolean running = true;

	//presentation
	infoGame();

	//lancement du jeu
	while( running && this.currentStep < this.stepMax) 
	    {
		System.out.println(this);
		nextStep();

		if( this.stepByStep )
		    {
			
			while(keyValue == 0)
			    {
				try
				    {
					keyValue = lecteur.read();
     
				    }
				catch(Exception e){keyValue=0;}
			    }

			//on lit keyValue
			if(keyValue == (int)('q')) running = false;

			//
			keyValue = 0;
			
		    }
		else
		    {
			try{
			    
			    Thread.sleep(this.timer);
			}catch(Exception e){e.printStackTrace();}
		    }

		this.currentStep ++;

	    }

	//message final
	System.out.println("Fin de jeu, merci d'avoir joué !");
    }

    /**
     * Calcul le prochain etat de la simulation
     * 
     */
    private void nextStep()
    {
	for(Steerable s: this.steerable)
	    {
		nextStep(s);
	    }
    }

    /**
     * Calcul le prochain etat d'un steerable s
     * @param s Steerable dont on veut calculer le prochain etat
     * 
     */
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


    /**
     * Affiche l'etat courant
     * @return String chaine de caractere a afficher
     */
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

    /**
     * retourne le NPC a la position pos ou retourne null
     * @param pos Position a tester
     * @return NPC reference du npc a la position pos
     */
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

    /**
     * @param pos Position a tester
     * @return boolean True si la position est sur le damier
     */
    public boolean isValid(Position pos)
    {
	return (pos.getX()>=0 && pos.getX() < this.board.getWidth()
		&& pos.getY()>=0 && pos.getY() < this.board.getHeight());
    }

    /**
     * @param pos Position a tester
     * @return boolean True si la position n'est pas occuppee par un npc ou un obstacle
     */
    public boolean isFree(Position pos)
    {
	return ( isValid(pos) 
		 && NPCat(pos) == null  
		 && this.board.getTile(pos.getX(),pos.getY()) instanceof Empty   );				       
    }

    /**
     * Retourne une position aleatoire qui est libre
     * @return Position Position aleatoire libre
     */
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


    /**
     *@param s Steerable a ajouter dans le jeu
     */
    public void addSteerable(Steerable s)
    {
	if( isFree(s.getPosition()) )
	    {
		this.steerable.add(s);
	    }
	

    }
    
    /**
     * @return ArrayList<Steerable> Collection de steerable du jeu
     */
    public ArrayList<Steerable> getSteerables()
    {
	return this.steerable;
    }

  


}
