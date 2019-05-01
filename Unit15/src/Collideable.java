public interface Collideable {
	boolean didCollideLeft(Object obj);	
	boolean didCollideRight(Object obj);	
	boolean didCollideTop(Object obj);	
	boolean didCollideBottom(Object obj);
	boolean didCollideLRWall();
	boolean didCollideTBWall();
}