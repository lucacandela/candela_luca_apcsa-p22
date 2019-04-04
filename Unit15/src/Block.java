//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{


	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y) {
		setPos(x,y);
		setDimensions(20,20);
		setColor(new Color(255, 255, 255));
	}
	public Block(int x, int y, int w, int h) {
		setPos(x,y);
		setDimensions(w, h);
		setColor(new Color(255,255,255));
	}
	
	public Block(int x, int y, int w, int h, Color col) {
		setPos(x,y);
		setDimensions(w, h);
		setColor(col);
	}
	
   //add the other set methods
   public void setPos(int x, int y) {
	   setX(x);
	   setY(y);
   }
   public void setX(int x) {
	   xPos = x;
   }
   public void setY(int y) {
	   yPos = y;
   }
   
   public void setDimensions(int w, int h) {
	   setWidth(w);
	   setHeight(h);
   }
   public void setWidth(int w) {
	   width = w;
   }
   public void setHeight(int h) {
	   height = h;
   }
   
   public void setColor(Color col)
   {
	   color = col;
   }
   

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(getColor());
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		Block other = (Block) obj;
		
		if(getY() == other.getY() && getX() == other.getX() &&
				getWidth() == other.getWidth() && getHeight() == other.getHeight()&& getColor() == other.getColor()) {
			return true;
		}

		return false;
	}   

   //add the other get methods
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}
   //add a toString() method  - x , y , width, height, color
	public String toString() {
		String out = "";
		out+= "x = " + getX() + ", y = " + getY() + ", width = " + getWidth() + ", height = " + getHeight() + "color = " + color + "."; 
		return out;
	}
}