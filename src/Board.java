public class Board {

	final private int height;
	final private int width;
	private Tile [][] matTile;

	public Board(){
		this(20,20);
	}

	public Board (int width, int height){
		this.height=height;
		this.width=width;
		matTile=new Tile[width][height];
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

	public void addWall(){
	}
		

}
