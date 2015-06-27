package Main.Sheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 * 
 */
@SuppressWarnings("serial")
public class Sheet  extends JPanel
{
	//things
	ImgCon img ;
	InputSheet input = new InputSheet();
	private int size = 0;
	
	
	/**
	 * 
	 * @param size1 block size for the project
	 */
	public Sheet(int size1)
	{
		setBackground(Color.BLACK);
		input.setSize(size1);
		size = size1;
	}
	
	
	/**
	 * 
	 * @param a pleaz give me the sheet from ImgCon class
	 */
	public void setImg(ImgCon a)
	{
		img = a;
	}
	
	
	/**
	 * This paints to the panel
	 */
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(img.getSheet(), input.getX(), input.getY(), null);
		//box
		
		g.drawLine(input.getX() +(size * input.getBox()[0]),input.getY() + (size * input.getBox()[1]),input.getX() +(size * input.getBox()[0]), input.getY() + (size * input.getBox()[1]) + 30);//top
		g.drawLine(input.getX() +(size * input.getBox()[0])+ 30, input.getY() + (size * input.getBox()[1]), input.getX() +(size * input.getBox()[0])+ 30, input.getY() + (size * input.getBox()[1])+ 30);//bot
		g.drawLine(input.getX() +(size * input.getBox()[0]),input.getY() +  (size * input.getBox()[1]), input.getX() +(size * input.getBox()[0])+ 30,input.getY() +  (size * input.getBox()[1]));//left
		g.drawLine(input.getX() +(size * input.getBox()[0]), input.getY() + (size * input.getBox()[1])+ 30, input.getX() +(size * input.getBox()[0])+ 30,input.getY() +  (size * input.getBox()[1])+ 30);//right
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	
	}
	
	
	
	/**
	 * 
	 * @return the selected box x,y as an int[]
	 */
	public int[] up()
	{
		repaint();
		return input.getBox();
	}
	
	
	/**
	 * 
	 * @return the input file for the Sheet 
	 */
	public InputSheet getInput()
	{
		return input;
	}
	
}
