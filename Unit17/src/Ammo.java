//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
	private Image image;
	private Color col;
	private boolean deleted;
	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x,y,3);
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y,10,10);
		speed = s;
		col = Color.yellow;
		deleted = false;
		
	}
	public void delete() {
		deleted = true;
		
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	public void draw(Graphics window, Color c) {
		window.setColor(c);
		window.fillRect(getX(), getY(), getWidth(), getHeight());	
	}
	public void draw( Graphics window )
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());	
	}
	
	public void moveAndDraw(Graphics window) {
		draw(window, Color.black);
		move("up");
		draw(window);
	}
	
	public void move( String direction )
	{
			setY(getY() - getSpeed());
	}

	public String toString()
	{
		return "";
	}
}
