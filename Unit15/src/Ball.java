//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collideable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y) {
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h) {
		super(x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color col) {
		super(x,y,w,h,col);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color col, int xs, int ys) {
		super(x,y,w,h,col);
		xSpeed = xs;
		ySpeed = ys;
	}
	
	public Ball(int x, int y, int w, int h, int xs, int ys) {
		super(x,y,w,h);
		xSpeed = xs;
		ySpeed = ys;
	}
	//add the other Ball constructors
	
	
	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
	public void setXSpeed(int s) {
		xSpeed = s;
	}
	public void setYSpeed(int s) {
		ySpeed = s;
	}
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window, Color.white);

      setX(getX()+xSpeed);
      setY(getY() + ySpeed);//setY
      
      draw(window);
		//draw the ball at its new location
   }
   
	public boolean equals(Object obj) {
		Ball other = (Ball) obj;
		if (super.equals(obj) && other.getXSpeed() == getXSpeed() && other.getYSpeed() == getYSpeed()) {
			return true;
		}
		return false;
	}

   //add the get methods
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
	@Override
	public boolean didCollideLeft(Object obj) {
		Block other = (Block) obj;
		if (obj.getClass().getSimpleName().equals("Paddle")) {
			
			 other = (Paddle) obj;
			
		
		}
		else if (obj.getClass().getSimpleName().equals("Tile")) {
			 other = (Tile) obj;
			
		}
		if((this.getX() >= other.getX()  && this.getX() <= other.getX() + Math.abs(this.getXSpeed())) &&
				(this.getY() <= other.getY() + other.getHeight() && this.getY() >= other.getY()
					|| this.getY() >= other.getY() && this.getY() + this.getHeight()
					<= other.getY() + other.getHeight())) {
			System.out.println("didCollideLeft with " + obj.getClass().getName());
			return true;
		}
		return false;

	}

	@Override
	public boolean didCollideRight(Object obj) {
		Block other = (Block) obj;
		if (obj.getClass().getSimpleName().equals("Paddle")) {
			
			 other = (Paddle) obj;
			
		
		}
		else if (obj.getClass().getSimpleName().equals("Tile")) {
			 other = (Tile) obj;
			
		}
		if((this.getX() <= other.getX() + other.getWidth() && this.getX() >= other.getX() + other.getWidth() - Math.abs(this.getXSpeed()))
				&& (this.getY() >= other.getY() && this.getY() <= other.getY() +other.getHeight()
						|| this.getY() + this.getHeight() >= other.getY() && this.getY() + this.getHeight()
						< other.getY() + other.getHeight())) {
			System.out.println("didCollideRight with " + obj.getClass().getName());
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean didCollideTop(Object obj) {
		Block other = (Block) obj;
		if (obj.getClass().getSimpleName().equals("Paddle")) {
			
			 other = (Paddle) obj;
			
		
		}
		else if (obj.getClass().getSimpleName().equals("Tile")) {
			 other = (Tile) obj;
			
		}
		if((this.getY() >= other.getY() && this.getY() <= other.getY() + other.getHeight())
				&& (this.getX() >= other.getX() && this.getX() <= other.getX() +other.getWidth()
						|| this.getX() + this.getWidth() >= other.getX() && this.getX() + this.getWidth()
						< other.getX() + other.getWidth())) {
			System.out.println("didCollideTop with " + obj.getClass().getName());
			return true;
		}
		return false;

	}

	@Override
	public boolean didCollideBottom(Object obj) {
		if((getY()>=590)) {
			System.out.println("ball hit bottom");
			return true;
		}
		return false;
	}	
	public boolean didCollideLRWall() {
		//	Left Wall				Right Wall
		if(!(this.getX()>=10 && this.getX()<=780))
		{
			return true;
		}
		return false;
	}
	public boolean didCollideTBWall() {
		//	Top Wall			Bottom Wall
		if(!(this.getY()>=10 && this.getY()<=540))
		{
			return true;
		}
		return false;
	}
	
   //add a toString() method
	public String toString() {
		String out = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + "  " +  getXSpeed() + " " + getYSpeed();
		
		return out;
	}
}