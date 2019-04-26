public class Tile extends Block implements Collideable{
	private boolean destroyed = false;

	public boolean didCollideLeft(Object obj) {
	return false;
	}

	
	public boolean didCollideRight(Object obj) {
		Ball ball = (Ball) obj;
		if (ball.getX() <= this.getX() ) {
			return true;
		}
		 
		return false;
	}

	
	public boolean didCollideTop(Object obj) {
		return false;
	}

	
	public boolean didCollideBottom(Object obj) {
		return false;
	}
	
	
}