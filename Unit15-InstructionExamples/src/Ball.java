//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
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
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location


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
	
	
   //add a toString() method
	public String toString() {
		String out = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + "  " +  getXSpeed() + " " + getYSpeed();
		
		return out;
	}
}