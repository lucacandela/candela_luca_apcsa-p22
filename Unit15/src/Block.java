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
		setPos(100,150);
		setWidth(10);
		setHeight(10);
		setColor(Color.black);
	}
	
	public Block(int x, int y) {
		setPos(x,y);
		setWidth(10);
		setHeight(10);
		setColor(Color.black);
	}
	public Block(int x, int y,int w, int h) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
		setColor(Color.black);
	}
	
	public Block(int x, int y,int w, int h, Color col) {
		setPos(x,y);
		setWidth(w);
		setHeight(h);
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
   
	public void setWidth(int w){
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
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		if(obj.getClass().getName().equals(this.getClass().getName())) {
			Block other = (Block) obj;
			if(other.getX() == getX() && other.getY() == getY() && other.getWidth() == getWidth()
					&& other.getHeight() == getHeight() && other.getColor().equals(getColor())) {
				return true;
			}
			return false;
		}
		else
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
		String out = "x = " + getX() + ", y = " + getY() + ",\n width = " + getWidth() + ", height = " + getHeight() + ",\n color = " + getColor();
		return out;
	}
}