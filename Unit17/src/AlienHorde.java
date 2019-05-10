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

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		for (int i = 0; i < size; i++) {
			aliens.add(new Alien(50 + (70 * i), 100, 50,50, 5));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		int rand = (int)(Math.random() * 2) + 1;
		for (Alien a : aliens) {
			if (rand == 1) {
				a.move("left");
			}
			else if (rand == 2) {
				a.move("right");
			}
			else if (rand == 3) {
				a.move("down");
			}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
	}

	public String toString()
	{
		return "";
	}
}
