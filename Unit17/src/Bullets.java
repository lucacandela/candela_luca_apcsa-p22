//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void addBullet(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for (Ammo bullet : ammo) {
			bullet.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Ammo bullet : ammo) {
			bullet.move("up");
		}
	}

	public void cleanEmUp()
	{
		for (Ammo bullet : ammo) {
			if (bullet.getY() <= 0) {
				ammo.remove(bullet);
			}
		}
	}
	
	public boolean hitObject(Object obj) {
		MovingThing other = (MovingThing) obj;
		if (obj.getClass().getName().equals("Alien")) {
			other = (Alien) obj;
		}
		else if (obj.getClass().getName().equals("Ship")) {
			other = (Ship) obj;
		}
		
		else if (obj.getClass().getName().equals("Ammo")) {
			other = (Ammo) obj;
		}
		for (Ammo bullet : ammo) {
			if ((bullet.getY() <= other.getY() + other.getHeight() && bullet.getY() >= other.getY())
			&& (bullet.getX() <= other.getX() + other.getWidth() && bullet.getX() >=other.getX()) ) {
				ammo.remove(bullet);
				return true;
			}
		}
		return false;
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
