//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private int health;
	public Alien()
	{
		this(0,0,30,30,0,5);
	}

	public Alien(int x, int y)
	{
		this(x,y,30,30,0,5);
	}

	public Alien(int x, int y, int s)
	{
		this(x,y,30,30,s,5);
	}
	public Alien(int x, int y, int w, int h, int s) {
		this(x,y,w,h,s,5);
	}
	public Alien(int x, int y, int w, int h, int s, int hp)
	{
		super(x, y, w,h);
		speed=s;
		health = hp;
		try
		{
			URL url = getClass().getResource("images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("error loading images");
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	public void setHealth(int hp) {
		health = hp;
	}
	
	public int getHealth() {
		return health;
	}
	
   public void move(String direction)
	{
	   if (direction.equalsIgnoreCase("left")) {
		   setX(getX() - getSpeed());
	   }

	   if (direction.equalsIgnoreCase("right")) {
		   setX(getX() + getSpeed());
	   }

	   if (direction.equalsIgnoreCase("down")) {
		   setY(getY() + 50);
	   }
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
}
