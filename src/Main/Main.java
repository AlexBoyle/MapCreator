package Main;
import java.awt.Color;
import javax.swing.JFrame;
import Main.Map.Map;
import Main.Sheet.ImgCon;
import Main.Sheet.Sheet;

/**
 * 
 * @author Alex Boyle
 * @version 0.0.1
 * @Modifyed 6/25/2015
 *   
 */
public class Main 
{
	//vars
	private final int SIZE = 30;
	private long oldMs = 0;
	private final int TICK = 100;
	
	//windows
	private JFrame map = new JFrame();
	private JFrame sheet = new JFrame();
	
	//frames
	private Sheet img = new Sheet(SIZE);
	private Map out = new Map(SIZE);
	
	//Img stuff
	private ImgCon sprite = new ImgCon();
	
	/*
	 * This constructor sets up the two JFrames and starts the update loop
	 */
	public Main()
	{
		
		//map window set up
		out.setImg(sprite);
		map.setTitle("Map");
		map.setUndecorated(false);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setResizable(true);
		map.setSize(1024, 800);
		map.setLocationRelativeTo(null);
		map.setVisible(true);
		map.setBackground(Color.BLUE);
		map.getContentPane().add(out);
		map.addMouseMotionListener(out.getInput());
		map.addMouseListener(out.getInput());
		map.addKeyListener(out.getInput());
		map.validate();
		//sheet window set up
		img.setImg(sprite);
		sheet.setAlwaysOnTop(true);
		sheet.setTitle("Sheet");
		sheet.setUndecorated(false);
		sheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sheet.setResizable(true);
		sheet.setSize(300, 400);
		sheet.setLocationRelativeTo(null);
		sheet.setVisible(true);
		sheet.setBackground(Color.BLUE);
		sheet.getContentPane().add(img);
		sheet.addMouseMotionListener(img.getInput());
		sheet.addMouseListener(img.getInput());
		sheet.validate();
		
    
		//start of loop
		Run();
	}
	
	
	/*
	 * This is the update loop that ticks every tick miliseconds
	 */
	public void Run() 
	{
		
		//a tick system
		oldMs=System.currentTimeMillis();
		while(true)
		{	
			//if TICK milliseconds have passed do the thing in the statement
			//this is bad i know
			if (oldMs+TICK < System.currentTimeMillis() )
			{
				oldMs = System.currentTimeMillis();	
				
				//updates the tow windows and passes the selected box of the sheet to the map
				out.up(img.up());
			}
		}
	}
	
	
	/*
	 * Start of the program
	 */
	public static void main(String[] args)
	{
		
		new Main();
	}
}
