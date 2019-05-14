//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private Ammo ammo;
	private boolean isDead;
	public Ship()
	{
		this(10,10,100,100,5);
	}

	public Ship(int x, int y)
	{
	   this(x,y,100,100,5);
	}

	public Ship(int x, int y, int s)
	{
		this(x,y,100,100,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		isDead = false;
		try
		{
			URL url = getClass().getResource("images/ship.jpg");
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
	
	public void killShip() {
		isDead = true;
	}
	public boolean isShipDead() {
		return isDead;
	}
	public void move(String direction)
	{
		if (direction.equalsIgnoreCase("right")) {
			setX(getX() + getSpeed());
			
		}
		if (direction.equalsIgnoreCase("left")) {
			setX(getX() - getSpeed());
		}
		if (direction.equalsIgnoreCase("up")) {
			setY(getY() - getSpeed());
		}
		if (direction.equalsIgnoreCase("down")) {
			setY(getY() + getSpeed());
		}
	}
	public Ammo blast(Graphics window) {
		ammo = new Ammo((getX() + (getWidth()/2)), (getY()));
		ammo.setX(ammo.getX() - ammo.getWidth()/2);
		return ammo;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
