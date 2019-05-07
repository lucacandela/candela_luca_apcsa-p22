//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private List<List<Tile>> currentTiles, levelOneTiles, levelTwoTiles, levelThreeTiles;
	private boolean[] keys;
	private BufferedImage back;
	private int tileCount = 0;
	private int tilesDestroyed = 0;
	private int level;

	public Breakout()
	{
		//set up all variables related to the game
		ball = new Ball(400,275-50,10,10,20,-1);		
		
		//instantiate player paddle
		paddle = new Paddle(400-20,275+20,40,40, Color.blue);
		
		keys = new boolean[5];
		
		setLevelOneTiles();
    	setBackground(Color.WHITE);
		setVisible(true);
		level = 0;
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }
   public void setLevelOneTiles() {
	  
	   level = 1;
	   tileCount = 0;
	   levelOneTiles = new ArrayList<List<Tile>>();
	   List<Tile> temp = new ArrayList<Tile>();
	   for (int col = 0; col < 7; col++) {
		   for (int row = 0; row < 2; row++) {
			   temp.add(new Tile(101+(80 * col) + (2 * col), 20 + (65 * row), 80, 30, Color.black));
			   tileCount++;
		   }
	   }
	   levelOneTiles.add(temp);
	   temp = new ArrayList<Tile>();
	   for (int col = 0; col < 7; col++) {
		   for (int row = 0; row < 2; row++) {
			   temp.add(new Tile(101 +(80 * col) + (2 * col), 550-40 - (65 * row), 80, 30, Color.black));
			   tileCount++;
		   }
	   }
	   levelOneTiles.add(temp);
	   temp = new ArrayList<Tile>();
	   for (int col = 0; col < 2; col++) {
		   for (int row = 0; row < 6; row++){
			   temp.add(new Tile(20 + (35 * col) + (2 * col),20 + (90 * row), 30,80, Color.BLACK));
			   tileCount++;
		   }
	   }
	   levelOneTiles.add(temp);
	   currentTiles = levelOneTiles;
	   /*(for( List<Tile> tileList : tileListList) {
			for (int col = 0; col < 6; col++) {
				for (int row = 0; row < 2; row++) {
				tileList.add(new Tile(20 + (80 *col) + (5*col), 20 + (35 * ) , 80,30, Color.black));
				}
			}
			if (count)
			count++;
		}*/
   }
   
   public void setLevelTwoTiles() {
	   level = 2;
	   tileCount = 0;
	   levelTwoTiles = new ArrayList<List<Tile>>();
	   List<Tile> temp = new ArrayList<Tile>();
	   for (int col = 0; col < 7; col++) {
		   for (int row = 0; row < 2; row++) {
			   temp.add(new Tile(101+(80 * col) + (2 * col), 20 + (65 * row), 80, 30, Color.black));
			   tileCount++;
		   }
	   }
	   levelTwoTiles.add(temp);
	   temp = new ArrayList<Tile>();
	   for (int col = 0; col < 7; col++) {
		   for (int row = 0; row < 2; row++) {
			   temp.add(new Tile(101 +(80 * col) + (2 * col), 550-40 - (65 * row), 80, 30, Color.black));
			   tileCount++;
		   }
	   }
	   levelOneTiles.add(temp);
	   currentTiles = levelOneTiles;
   }
   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		for(List<Tile> tileList: currentTiles) {
			for(Tile t : tileList) {
				if (t.isDestroyed() != true)
					t.draw(graphToBack);
			}
		}
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);

		//see if ball hits left wall or right wall
		if(ball.didCollideLRWall())
		{
			ball.setXSpeed(-1 * ball.getXSpeed());
		}
		
		if(ball.didCollideTBWall()) {
			ball.setYSpeed(-1 * ball.getYSpeed());
		}

		


		//see if the ball hits the paddle on the paddle's left side
		if(ball.didCollideLeft(paddle) || ball.didCollideRight(paddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		else if(ball.didCollideBottom(paddle) || ball.didCollideTop(paddle)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		else {}
		
		if (tilesDestroyed == tileCount) {
			
			tilesDestroyed = 0;
			if (level == 1) {
				setLevelTwoTiles();
				ball.resetToStart(graphToBack, 400, 275);
				
			}
		}
		System.out.print("Total: " + tileCount + ", ");
		System.out.println("Destroyed: " + tilesDestroyed);
		
		for (List<Tile> tileList : currentTiles) {
			for (Tile t : tileList) {
				if (t.isDestroyed() != true && (ball.didCollideBottom(t) || ball.didCollideTop(t))) {
					ball.setYSpeed(-ball.getYSpeed());
					t.destroy();
					t.draw(graphToBack, Color.white);
					tilesDestroyed++;
				}
				else if (t.isDestroyed() != true &&(ball.didCollideLeft(t) || ball.didCollideRight(t)) ){
					ball.setXSpeed(-ball.getXSpeed());
					t.destroy();
					t.draw(graphToBack, Color.white);
					tilesDestroyed++;
				}
				else {}
			}
		}
		
		
		
		
		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			paddle.moveLeftAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			//move right paddle up
			paddle.moveDownAndDraw(graphToBack);

		}
		if(keys[3] == true)
		{
			//move right paddle down
			paddle.moveRightAndDraw(graphToBack);
		}
		if(keys[4] == true) {
			//reset game?
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}

   public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'A' : keys[1]=true; break;
			case 'S' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
			case 'R' : keys[4]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'A' : keys[1]=false; break;
			case 'S' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
			case 'R' : keys[4]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}


}