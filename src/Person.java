//Name -

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Person 
{
	private ArrayList<Image> list;	
	private int x, y, current;
	
	public Person(int x, int y) throws IOException
	{
		this.x=x;
		this.y=y;
		current = 0;
		
		//point the array list at a new ArrayList
		list = new ArrayList<>();
		
		//add all images to the list
		Image front = ImageIO.read(new File("dude.gif"));
		list.add(front);
		Image left = ImageIO.read(new File("dudeL.gif"));
		list.add(left);
		Image right = ImageIO.read(new File("dudeR.gif"));
		list.add(right);
		Image back = ImageIO.read(new File("dudeU.gif"));
		list.add(back);
	}
	
	// will return true if person collides with another object
	public boolean collide(int x, int y)
	{
		Rectangle a = new Rectangle(this.x, this.y, 50, 50);
		Rectangle b = new Rectangle(x, y, 50, 50);
		return a.intersects(b);
	}
	
	public void drawPerson(Graphics2D g)
	{
		//draw the current image on the screen
		g.drawImage(getCurrent(),getX(),getY(),null);
	}
	
	public Image getCurrent()
	{
		//return the current image
		return list.get(current);
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void moveRight()
	{
		//finish
		current = 2;
		x = x + 5;
	}
	
	public void moveLeft()
	{
		//finish
		current = 1;
		x = x - 5;
	}
	
	public void moveUp()
	{
		//finish
		current = 3;
		y = y - 5;
	}
	
	public void moveDown()
	{
		//finish
		current = 0;
		y = y + 5;
	}
}
