package Main.Sheet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 * 
 */
public class ImgCon 
{
	private JFileChooser fc = new JFileChooser();//class to chosse a file
	private File file = null;//file that will be set by JFC and read
	private BufferedImage img;//image from the file
	
	/**
	 * This constructor prompts the user for an input file
	 */
	public ImgCon()
	{
		
		fc.showOpenDialog(null);
		
			file = fc.getSelectedFile();
		
		
		try
		{
			
			img = ImageIO.read(file);
		}
		catch(IOException e) 
		{
			file = new File("testsheet.png");
		}
		catch(IllegalArgumentException e)
		{
			file = new File("testsheet.png");
		}
	}
	/**
	 * @return the main img sheet being used
	 */
	public BufferedImage getSheet()
	{
		return img;
	}
}
