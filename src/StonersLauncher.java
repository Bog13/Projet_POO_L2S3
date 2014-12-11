import java.util.ArrayList;

public class StonersLauncher
{
    public static void main(String[] args)
    {
	Position ptest1 = new Position(1,3);
	Position ptest2 = new Position(3,3);

	Game jeu = new Game(50,95);
	jeu.execute();

	System.out.println(jeu);



    }
}
