import java.awt.Color;

public class Tile extends Block {
	private boolean destroyed = false;

	public Tile()
	{
		super();
	}
	
	public Tile(int x, int y) {
		super(x,y);
	}
	public Tile(int x, int y,int w, int h) {
		super(x,y,w,h);
	}
	
	public Tile(int x, int y,int w, int h, Color col) {
		super(x,y,w,h,col);
	}
	
	public void destroy() {
	}
	
	
	
}