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
	public AlienHorde() {
		this(3,1);
	}
	public AlienHorde(int size)
	{
		this(size,1);
	}
	
	public AlienHorde(int size, int health) {
		aliens = new ArrayList<Alien>();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < 750/55; col++) {
				aliens.add(new Alien(50 + (55 * col), 50 * row, 50,50, 1,health));
			}
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

	/* hitBox:
	 * {
	 * 		top : obj.getY();
	 * 		bot : obj.getY()+obj.getHeight();
	 * 		left : obj.getX();
	 * 		right : obj.getX() + obj.getWidth();
	 * }
	 * 
	 * They are in contact if
	 * {
	 * 		a.top + s.bot
	 * 		a.left + s.right
	 * 		a.right + s.left
	 * 		a.bot + s.top
	 * }
	*/
	public boolean hitShip(Ship enemy) {
		Ship s = enemy;
		for (Alien a : aliens) {
			int aTop = a.getY();
			int aBot = a.getY() + a.getHeight();
			int aLeft = a.getX();
			int aRight = a.getX() + a.getWidth();
			
			int sTop = s.getY();
			int sBot = s.getY() + s.getHeight();
			int sLeft = s.getX();
			int sRight = s.getX() + s.getWidth();
			
			if (((aTop <= sBot && aTop >=sTop ) || (aBot >= sTop && aBot <= sBot) )&&
					((aRight >= sLeft && aRight <= sRight ) || (aLeft <= sRight && aLeft >= sLeft))) {
				return true;
			}
		}
		return false;
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
