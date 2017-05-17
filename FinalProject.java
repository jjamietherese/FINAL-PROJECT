import static java.lang.System.*;
import static java.lang.Math.*;
import javax.swing.JOptionPane; 
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Frame;
import java.applet.*;
import sun.audio.*;
import java.awt.Toolkit;
import java.awt.Image;	
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class FinalProject
{
	public static void main(String [] args) throws IOException
	{
//    	String [] henlo = {"h","e","n","l","o"," ","d","o","g"};
//		String [] second = {"h","e","l","l","o"," ","y","o","u"," ","S","T","I","N","K","Y"," ","D","O","G"};
//		String [] third = {"g","o"," ","e","a","t"," ","a"," ","b","o","n","e"," ","u","g","l","y"};
//		for(int x = 0;x < henlo.length;x++)
//		{
//			out.print(henlo[x]);
//			pause(80);
//		}
//		pause(500);
//		out.println();
//		for(int x = 0;x < second.length;x++)
//		{
//			out.print(second[x]);
//			pause(80);
//		}
//		pause(500);
//		out.println();
//		for(int x = 0;x < third.length;x++)
//		{
//			out.print(third[x]);
//			pause(80);
//		}
//		out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+
//					"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+
//					"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		
		new Windows();
    	
	}
	public static void pause (long r)
	{
   		try
   		{
      		Thread.sleep(r);
   		}
   		catch (Exception e) 
   		{
      		out.println(" sleep error " + e);
   		} 	   
	}
}
class Windows extends Frame implements KeyListener, MouseListener, ActionListener
{
	private final static int SCHEIGHT=900,SCWIDTH=1070;
	private String title = "";
	private String name, greeting,screenName;
	private String elective1,elective2,elective3;
	private Image introScreen;
	private Image myScreen;
	private boolean openScreen = false;
	private boolean intro = false;
	private boolean welcome = false;
	private boolean otherScreen = false;
	private int screen;
	private ArrayList <Room> room;
	public Windows()
	{
		setSize(SCWIDTH,SCHEIGHT);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		
		room = new ArrayList<Room>();
		room.add(new Room("Klein High School","klein.jpg"));
		room.add(new Room("Art Studio","art room.jpg"));
		room.add(new Room("Cafeteria","cafeteria.jpg"));
		room.add(new Room("English","english room.jpg"));
		room.add(new Room("Gym","gym room.jpg"));
		room.add(new Room("Health","health room.jpg"));
		room.add(new Room("History","history room.jpg"));
		room.add(new Room("Music Hall","music room.jpg"));
		room.add(new Room("Science Lab","science room.jpg"));
		
		openScreen = true;
		
		this.setVisible(true);
		//***** THIS WORKS *****
		JOptionPane.showMessageDialog(null,"   Welcome to the game of Life!"+
								  "\nIn this game, you will create a character and"+
								  "\nstart a new life in the halls of 'ol Klein High! You"+
								  "\nwill be able to make your own choices and those"+
								  "\nchoices will affect the outcome of your life."+
								  "\n            Are you ready to play??");
								  
		//***** THIS WORKS *****
		name = JOptionPane.showInputDialog(null,"Enter your first name only.");
		elective1 = JOptionPane.showInputDialog(null,"Enter your first elective.");
		elective2 = JOptionPane.showInputDialog(null,"Enter your second elective.");
		elective3 = JOptionPane.showInputDialog(null,"Enter your third elective.");
		
		intro = true;
		
//		otherScreen = true;
		//***** IN PROGRESS *****
//		JPanel panel = new JPanel();
//		JRadioButton button1 = new JRadioButton("Hello");
//		JRadioButton button2 = new JRadioButton("Goodbye");
//		panel.add(button1);
//		panel.add(button2);
//		JOptionPane.showMessageDialog(null, panel);
//		if(button1.isSelected())
//			screen = 1;


		this.addKeyListener(this);
		gameLoop();
	}
	public void gameLoop()
	{
		while(true);
	}
	public void paint(Graphics pen)
	{
		if(openScreen)
		{
			title = "Life";
			setTitle(title);
			doubleBuffer(pen);
			pen.setColor(Color.white);
			pen.setFont(new Font("Timesroman",Font.BOLD,250));
			pen.drawString("L I F E",150,400);
			pen.setFont(new Font("Timesroman",Font.PLAIN,50));
			pen.drawString("Michelle Chu",360,600);
			pen.drawString("Jamie Nillas",370,650);
		}
		if(intro)
		{
			myScreen = createImage(getSize().width,getSize().height);
	        Graphics o = myScreen.getGraphics();
	        doubleBuffer(o);
	        pen.drawImage(myScreen,0,0,null);
		}
	}
	public void doubleBuffer(Graphics pen)
	{
		if(openScreen)
		{
 	 		Image background = Toolkit.getDefaultToolkit().getImage("landscape.jpg");
 	 		pen.drawImage(background,-200,-100,this);
		}
		if(intro)
		{                
			introScreen = Toolkit.getDefaultToolkit().getImage("klein.jpg");
			pen.drawImage(introScreen,-300,-100,this);
			makePrompt(0,0,0,Color.yellow,Color.black,pen);
			welcome = true;
		}
		if(otherScreen)
		{
			screenName = room.get(screen).getPicName();
			Image whichScreen = Toolkit.getDefaultToolkit().getImage(screenName);
			pen.drawImage(whichScreen,-100,-100,this);
  		}
  	}
  	public void makePrompt(int x,int y,int font,Color box,Color text,Graphics g)
  	{
  		g.setColor(box);
  		g.fillRect(0,SCHEIGHT-150,SCWIDTH,SCHEIGHT-25);
  		g.setColor(text);
  		g.setFont(new Font("Timesroman",0,20));
  		if(welcome)
  		{	
  			greeting = "Hello, "+name+"! Welcome to your first day at Klein High! This is your schedule.";
  			g.drawString(greeting,100,SCHEIGHT-100);
  			JOptionPane.showMessageDialog(null,"	SCHEDULE	"+
  										 "\n   Period      Class"+
  										 "\n      1         Science"+
  										 "\n      2         "+elective1+
  										 "\n      3         English"+
  										 "\n      4         "+elective2+
  										 "\n    ---- Lunch ----"+
  										 "\n      5          Math"+
  										 "\n      6         History"+
  										 "\n      7         "+elective3);
  		}
  		
  	}
  	public void keyPressed(KeyEvent e) {}
  	public void actionPerformed(ActionEvent b) {}
  	public void mouseClicked(MouseEvent m) {}
  	public void mouseEntered(MouseEvent m) {}
  	public void mouseExited(MouseEvent m) {}
  	public void mousePressed(MouseEvent m) {}
  	public void mouseReleased(MouseEvent m) {}
  	
  	public void keyReleased(KeyEvent e) {}
  	public void keyTyped(KeyEvent e) {}
  	
  	public void update(Graphics G)
  	{
  		paint(G);
  	}
}
class Room
{
	private Image room;
	private String description;
	private String nameOfPic;
	public Room()
	{
		description = "A normal room";
	}
	public Room(String picName)
	{
		nameOfPic = picName;
		room = Toolkit.getDefaultToolkit().getImage(picName);
	}
	public Room(String d,String picName)
	{
		description = d;
		room = Toolkit.getDefaultToolkit().getImage(picName);
		nameOfPic = picName;
	}
	public String getPicName()
	{
		return nameOfPic;
	}
  	public Image getRoomPic()
  	{
  		return room;
  	}
	public String getDescription()
	{
		return description;
	}
	public String toString()
	{
		String s = description;
		return s;
	}
}		

/* AUDIO
 *
 * AudioClip ac = getAudioClip(getCodeBase(), soundFile);
 * ac.play();
 * ac.stop();
 * ac.loop();
 *
 *
 * InputStream in = new FileInputStream(Filename);
 * AudioStream as = new AudioStream(in);
 * AudioPlayer.player.start(as);
 * AudioPlayer.player.stop(as);
 */
 
