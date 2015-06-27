package Main.Sheet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 * 
 */
public class InputSheet implements MouseMotionListener, MouseListener 
{
	private int size = 0;//size of 
	private int x = 0;//x of img
	private int y = 0;//y of img
	private int tx = 0;//temp mouse x
	private int ty = 0;//temp mouse y
	private int sx = 0;//selected mousex x
	private int sy = 0;//selected mouse y

	/**
	 * this method says to set the selected area to the place the mouse is "clicked"
	 */
	public void mouseClicked(MouseEvent m) 
	{
		sx = m.getX()-x-7;
		sy = m.getY()-y - 30;
	}

	/**
	 * when the mouse is pressed it sets up the location of the mouse for the image being draged
	 * see: MouseDragged
	 */
	public void mousePressed(MouseEvent m) 
	{
		tx = m.getX();
		ty = m.getY();
	}


	/**
	 * Every time the mouse is draged across the screen, this changes the x and y for the whole image
	 */
	public void mouseDragged(MouseEvent m) 
	{
		x -= (tx - m.getX());
		tx = m.getX();
		y -= (ty - m.getY());
		ty = m.getY();
	}

	
	/**
	 * 
	 * @return the x position of the selection box
	 */
	public int getX()
	{
		return x;
	}
	
	
	/**
	 * 
	 * @return the y position of the selection box
	 */
	public int getY()
	{
		return y;
	}
	
	
	/**
	 * 
	 * @param s set the selection box size
	 */
	public void setSize(int s)
	{
		size = s;
	}
	
	
	/**
	 * 
	 * @return the selected box location; in a 2d array
	 */
	public int[] getBox()
	{
		
		if (sx < 0 || sy < 0)
			return new int[] {0,0};
		int[] temp = {(sx/size),(sy/size)};
		
		return temp;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	//Unused stuff that i need to define
	@Override
	public void mouseMoved(MouseEvent m) 
	{
		
	}
	@Override
	public void mouseEntered(MouseEvent m) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent m) 
	{

	}
	@Override
	public void mouseReleased(MouseEvent m) 
	{
		
	}

}
