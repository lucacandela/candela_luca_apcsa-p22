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
	private List<Tile> tiles;
	private boolean[] keys;
	private BufferedImage back;


	public Breakout()
	{
		//set up all variables related to the game
		ball = new Ball();		
		
		//instantiate player paddle
		paddle = new Paddle(30,100,25,100, Color.blue);
		
		tiles = new ArrayList<Tile>();
		
		for(int i = 0; i < 7; i++) {
			tiles.add(new Tile(20 + (80*i),10,80,20,Color.black));
		}
		
		keys = new boolean[4];
		
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
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


		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);

		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack,Color.white);
			if (ball.getX() <= 10) {
				//score for player 2
				System.out.println("Player 2 Scores");
			}
			if( ball.getX() >= 780) {
				//score for player 1
				System.out.println("Player 1 Scores");
			}
			ball = new Ball();
			}

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=10 && ball.getY()<=540))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}



		//see if the ball hits the paddle on the ball's left side
		if(ball.didCollideLeft(paddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		
		//see if ball hits paddle on the ball's right side
		if(ball.didCollideRight(paddle))
			ball.setXSpeed(-ball.getXSpeed());

		for (Tile t : tiles) {
			if (ball.didCollideBottom(t)) {
				System.out.println(0);
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
			paddle.moveUpAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			//move right paddle up
			paddle.moveDownAndDraw(graphToBack);

		}
		if(keys[3] == true)
		{
			//move right paddle down
			paddle.moveDownAndDraw(graphToBack);
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