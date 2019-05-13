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
			aliens.add(new Alien(50 + (70 * i), 100, 50,50, 1));
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
			if (a.getY() % 20 == 0 && a.getX() <= 790 ) {
				a.move("right");
			}
			else if (a.getY() % 10 == 0 && a.getX() >= 10) {
				a.move("left");
			}
			if (a.getX() <= 10 || a.getX() >= 790) {
				a.move("down");
			}
		}
	}

	public void removeDeadOnes()
	{	
		List<Alien> deadAliens = new ArrayList<Alien>();
		for (Alien a : aliens ) {
			if (a.getHealth() == 0) {
				deadAliens.add(a);
			}
		}
		if (!deadAliens.isEmpty())
			aliens.removeAll(deadAliens);
	}
	public List<Alien> getAliens(){
		return aliens;
	}
	public String toString()
	{
		return "";
	}
}
