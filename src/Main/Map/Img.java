package Main.Map;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 * 
 */
public class Img {
	
	private int[] id = {-1,-1};//defalt id for an object
	private BufferedImage img;
	
	
	/**
	 * 
	 * @param a set the defalt image
	 */
	public Img(BufferedImage a)
	{
		img = a;
	}
	
	
	/**
	 * 
	 * @param a set the modified image here
	 * @param thing id of the image (x,y on the sheet)
	 */
	public void setImg(BufferedImage a, int[] thing)
	{
		img = a;
		id = thing;
	}
	
	
	/**
	 * 
	 * @return the currently set image
	 */
	public BufferedImage getImg()
	{
		
		return img;
		
	}
	
	
	/**
	 * 
	 * @return the id of the image
	 */
	public int[] getId()
	{
		return id;
	}
	
	
	/**
	 * 
	 * @param com other image being compared(this used the id)
	 * @return true if id are similar: otherwise false
	 */
	public boolean compareTo(Img com)
	{
		return (id[0] == com.getId()[0] && id[1] == com.getId()[1]);
	}
}