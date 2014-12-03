import java.util.ArrayList;

public class test
{
    public static void main(String[] args)
    {
	ArrayList<NPC> al = new ArrayList<NPC>();
	al.add(new Walker(new Position(0,0)));
	al.add(new Resurrector(new Position(0,0)));
	al.add(new Stoner(new Position(0,0)));
	al.add(new Walker(new Position(0,0)));
	al.add(new Stoner(new Position(0,0)));
	al.add(new Walker(new Position(0,0)));


	for(NPC npc: al)
	    {
		System.out.print(npc + " ");
	    }


	System.out.println();
    }
}
