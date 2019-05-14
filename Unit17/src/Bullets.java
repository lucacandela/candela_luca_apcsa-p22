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
	private int ammoSize;
	public Bullets() {
		this(100);
	}
	public Bullets(int s)
	{
		ammo = new ArrayList<Ammo>();
		ammoSize = s;
	}
	
	public int getSize() {
		return ammoSize;
	}
	public void setSize(int s) {
		ammoSize = s;
	}
	public void addBullet(Ammo al)
	{
		ammo.add(al);
		setSize(getSize() -1);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for (Ammo bullet : ammo) {
			if (!bullet.isDeleted())
				bullet.draw(window);
			}
	}

	public void moveEmAll()
	{
		for (Ammo bullet : ammo) {
			bullet.move("up");
		}
	}

	public void cleanEmUp( Graphics window)
	{
		List<Ammo> deletedBullets = new ArrayList<Ammo>();
		for (Ammo bullet : ammo) {
			if (bullet.getY() <= 0) {
				deletedBullets.add(bullet);
			}
		}
		deleteBullets(deletedBullets);
	}
	
	public boolean hitObject(Object obj) {
		List<Ammo> deadBullets = new ArrayList<Ammo>();
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
				deadBullets.add(bullet);
			}
		}
		if (!deadBullets.isEmpty()) {
			deleteBullets(deadBullets);
			return true;
		}
		
		return false;
	}
	
	public void deleteBullets(List<Ammo> bullets) {
		ammo.removeAll(bullets);
		
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
