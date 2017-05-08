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
public class FinalProject
{
	public static void main(String [] args) throws IOException
	{
    	String [] henlo = {"h","e","n","l","o"," ","d","o","g"};
		String [] second = {"h","e","l","l","o"," ","y","o","u"," ","S","T","I","N","K","Y"," ","D","O","G"};
		String [] third = {"g","o"," ","e","a","t"," ","a"," ","b","o","n","e"," ","u","g","l","y"};
		for(int x = 0;x < henlo.length;x++)
		{
			out.print(henlo[x]);
			pause(80);
		}
		pause(500);
		out.println();
		for(int x = 0;x < second.length;x++)
		{
			out.print(second[x]);
			pause(80);
		}
		pause(500);
		out.println();
		for(int x = 0;x < third.length;x++)
		{
			out.print(third[x]);
			pause(80);
		}
		out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+
					"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+
					"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		
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
   		
//   		Date d = new Date();
//   		long mil = d.getTime();
//   		long save = mil;
//   		while(mil < save + r)
//   		{
//   			d = new Date();
//   			mil = d.getTime();
//   		}  	   
	}
}
class Windows extends Frame
{
	private final static int SCHEIGHT=900,SCWIDTH=1070;
	private String title = "";
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
		this.setVisible(true);
		JOptionPane.showMessageDialog(null,"   Welcome to the game of Life!"+
								  "\nIn this game, you will create a character and"+
								  "\nstart a new life in the halls of 'ol Klein High! You"+
								  "\nwill be able to make your own choices and those"+
								  "\nchoices will affect the outcome of your life."+
								  "\n            Are you ready to play??");
	gameLoop();
	}
	public void gameLoop()
	{
		while(true);
	}
	public void paint(Graphics pen)
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
	public void doubleBuffer(Graphics pen)
	{
 	 	Image background = Toolkit.getDefaultToolkit().getImage("landscape.jpg");
 	 	pen.drawImage(background,-200,-100,this);	                    
		 
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
 