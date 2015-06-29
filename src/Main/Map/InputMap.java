package Main.Map;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class InputMap implements MouseMotionListener, MouseListener,KeyListener 
{
	private int size = 0;
	private int x = 20;//x of img
	private int y = 20;//y of img
	private int tx = 0;//temp mouse x
	private int ty = 0;//temp mouse y
	private int sx = 0;//selected mousex x
	private int sy = 0;//selected mouse y
	private boolean set = false;
	private boolean output = false;
	private boolean fill = false;

	public void setSize(int a)
	{
		size = a;
	}
	public boolean setimg()
	{
		if (set)
		{
			set = false;
			return true;
		}
		return false;
	}
	public boolean printimg()
	{
		if (output)
		{
			output = false;
			return true;
		}
		return false;
	}
	public boolean getFill()
	{
		if (fill)
		{
			fill = !fill;
			return !fill;
		}
		return fill;
	}
	@Override
	public void mouseClicked(MouseEvent m) 
	{
		
		sx = m.getX()-x-7;
		set = true;
		sy = m.getY()-y - 30;
		
	}

	@Override
	public void mouseEntered(MouseEvent m) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent m) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) 
	{
		tx = m.getX();
		ty = m.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent m) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent m) 
	{
		x -= (tx - m.getX());
		tx = m.getX();
		y -= (ty - m.getY());
		ty = m.getY();
	}

	@Override
	public void mouseMoved(MouseEvent m) 
	{
		
		
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int[] getBox()
	{
		
		if (sx < 0 || sy < 0)
			return new int[] {0,0};
		int[] temp = {(sx/size),(sy/size)};
		
		return temp;
	}
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		
		if (key == 80)//p
		{
			output = true;
		}
		else if (key == 70)
		{
			fill = true;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent k) {

		
	}

}
