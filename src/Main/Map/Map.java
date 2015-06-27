package Main.Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Main.Sheet.ImgCon;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 * 
 */
@SuppressWarnings("serial")
public class Map  extends JPanel
{
	//objects
	private int coun = 0;
	InputMap input = new InputMap();
	Img[][] img;
	int[] selected = {0,0};
	ImgCon sheet;
	int size;
	BufferedImage m;
	BufferedImage t;
	BufferedImage l;
	BufferedImage r;
	BufferedImage b;
	BufferedImage combined;
	
	public Map(int size1)
	{
		size = size1;
		setBackground(Color.BLACK);
		try
		{
			
			m = ImageIO.read(getClass().getResource("d.png"));
			t = ImageIO.read(getClass().getResource("top.png"));
			l = ImageIO.read(getClass().getResource("left.png"));
			r = ImageIO.read(getClass().getResource("right.png"));
			b = ImageIO.read(getClass().getResource("bot.png"));
		}
		catch(IOException e) 
		{
			System.out.println("ERROR IN SHEET") ;   
		}
		setupArray(size,900,600);
		input.setSize(size);
	}
	public void setImg(ImgCon a)
	{
		sheet = a;
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		for (int i = 0; i < img.length; i ++)
			for (int j = 0; j < img[i].length; j ++)
				g.drawImage(img[i][j].getImg(), (i*size) + input.getX(), (j*size) + input.getY(), null);
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	
	}
	private void setupArray(int size, int width, int height)
	{
		
		
		combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		img = new Img[(width / size)][(height / size)];
	
		for (int i = 0; i < img.length; i ++)
			for (int j = 0; j < img[i].length; j ++)
				if (j == 0)
					img[i][j] = new Img(t);
				else if (j == img[0].length - 1)
					img[i][j] = new Img(b);
				else if ( i == 0)
					img[i][j] = new Img(l);
				else if (i == img.length - 1)
					img[i][j] = new Img(r);
				else 
				img[i][j] = new Img(m);
	}
	private void createImg()
	{
		System.out.println("printing");
		Graphics g = combined.getGraphics();
		for (int i = 0; i < img.length; i ++)
			for (int j = 0; j < img[i].length; j ++)
				g.drawImage(img[i][j].getImg(), (i*size), (j*size), null);
		try {
			ImageIO.write(combined, "PNG", new File("editedMap.png"));
		} catch (IOException e) {
			System.out.println("help");
			e.printStackTrace();
		}
	}
	
	
	
	public void up(int[] box)
	{
		
		repaint();
		selected = box;
		
		if(input.setimg())
		{
			if(input.getFill())
			{
				fill(input.getBox()[0], input.getBox()[1],img[input.getBox()[0]][input.getBox()[1]]);
				
			}
			set(input.getBox()[0], input.getBox()[1]);
		}
		if(input.printimg())
		{
			createImg();
		}
	}
	public InputMap getInput()
	{
		return input;
	}
	
	
	public void set(int x,int y)
	{
		try
		{
			img[x][y].setImg(sheet.getSheet().getSubimage(selected[0] * size, selected[1] * size, size, size), selected); 
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("out of sheet");
		}
		catch(NullPointerException e)
		{
			System.out.println("im sorry you messed it up");
		}
	}
	public void fill(int x, int y, Img id)
	{
		coun ++;
		System.out.println(coun + ", " + x + ", " + y);
		
		if (x < img.length && x > -1 && y -1 < img[0].length && y -1 > -1 && img[x][y -1].compareTo(id))
		{
			y -= 1;
			set(x,y);
			fill(x,y,id);
		}
		
		if (x -1 < img.length && x -1 > -1 && y  < img[0].length && y  > -1 && img[x -1][y ].compareTo(id))
		{
			x -= 1;
			set(x,y);
			fill(x,y,id);
		}
		if (x +1 < img.length && x +1 > -1 && y  < img[0].length && y  > -1 && img[x +1][y ].compareTo(id))
		{
			x += 1;
			set(x,y);
			fill(x,y,id);
		}
		if (x  < img.length && x  > -1 && y + 1 < img[0].length && y +1 > -1 && img[x ][y +1 ].compareTo(id))
		{
			
			y += 1;
			set(x,y);
			//fill(x,y,id);
		}
		
		
		
		
	}
	
	
			
		
	
}