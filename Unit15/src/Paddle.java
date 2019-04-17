//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int x,int y) {
	   super(x,y);
	   speed = 5;
   }
   
   public Paddle(int x, int y, int s) {
	   super(x,y);
	   speed = s;
   }
   
   public Paddle(int x, int y, int w, int h) {
	   super(x,y,w,h);
	   speed = 5;
   }
   
   public Paddle(int x, int y, int w, int h, int s) {
	   super(x,y,w,h);
	   speed = s;
   }
   
   public Paddle(int x, int y, int w, int h, Color col) {
	   super(x,y,w,h,col);
	   speed = 5;
   }
   
   public Paddle(int x, int y, int w, int h, Color col, int s) {
	   super(x,y,w,h,col);
	   speed = s;
   }

   public boolean equals(Object obj) {
	   Paddle other = (Paddle) obj;
	   if (super.equals(obj) && other.getSpeed() == getSpeed()) {
		   return true;
	   }
	   else
		   return false;
   }






   public void moveUpAndDraw(Graphics window)
   {
	   draw(window,Color.white);
	   setY(getY() - getSpeed());
	   
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window,Color.white);
	   setY(getY() + getSpeed());
	   draw(window);
   }

   //add get methods

   public int getSpeed() {
	   return speed;
   }
   //add a toString() method
   
   public String toString() {
	   String out = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
	   return out;
   }
}