import java.util.ArrayList;
import java.util.Scanner;

public class StonersLauncher
{

    public static boolean askQuestion(String q)
    {
	Scanner sc = new Scanner(System.in);
	char answer = ' ';

	System.out.println(q + " (o/n)");
	answer = sc.nextLine().charAt(0);

	return (answer == 'o' || answer == 'O');
	
    }
    
    public static void main(String[] args)
    {
	
	Game jeu = null;
	
	if( askQuestion("Voulez vous executer le jeu en mode pas-a-pas ?") )
	    {
		jeu=new Game(50,95,true);
	    }
	else
	    {
		jeu = new Game(50,95);
	    }

	jeu.executeTestCollisionNPC();
	



    }
}
