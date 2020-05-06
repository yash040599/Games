import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Snake extends Frame implements KeyListener, WindowListener, Runnable
{
	Thread t;
	int x=200,y=200,c=0,p=0,i=1,speed=50;
	Boolean run=true;
	Random rand = new Random();
	int x1 = rand.nextInt(448);
	int y1 = rand.nextInt(394);
	Label l1,l2,l3;

	public Snake()
	{	
		Panel pan=new Panel(); 

		l1=new Label("Points:", Label.LEFT);
 		l1.setBackground(Color.black);
  		l1.setForeground(Color.white);
  		l1.setFont(new Font("Serif", Font.BOLD, 30));
		
		l2=new Label("0", Label.LEFT);
 		l2.setBackground(Color.black);
  		l2.setForeground(Color.white);
  		l2.setFont(new Font("Serif", Font.BOLD, 30));
	
		l3=new Label("Eat!   (Use arrow keys to control)", Label.CENTER);
 		l3.setBackground(Color.black);
  		l3.setForeground(Color.white);
  		l3.setFont(new Font("Serif", Font.BOLD, 20));
		
		pan.add(l1);pan.add(l2);pan.add(l3);
		add(pan,BorderLayout.SOUTH);
		pan.setBackground(Color.black);	

		addWindowListener(this);
		addKeyListener(this);

		setTitle("Game");
		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}

	public void keyPressed(KeyEvent ke) 
	{
		String s=KeyEvent.getKeyText(ke.getKeyCode());
		if(s.equals("Left"))
		{
			if(run)
			{
				try
				{
					t.stop();
				}
				catch(Exception e){}
				System.out.println("Left");	
				c=1;
				t=new Thread(this);
				t.start();
			}
		}
		else if(s.equals("Up"))
		{
			if(run)
			{
				try
				{
					t.stop();
				}
				catch(Exception e){}
				System.out.println("Up");	
				c=2;
				t=new Thread(this);
				t.start();
			}
		}
		else if(s.equals("Down"))
		{
			if(run)
			{
				try
				{
					t.stop();
				}
				catch(Exception e){}
				System.out.println("Down");	
				c=3;
				t=new Thread(this);
				t.start();
			}
		}
		else if(s.equals("Right"))
		{
			if(run)
			{
				try
				{
					t.stop();
				}
				catch(Exception e){}
				System.out.println("Right");	
				c=4;
				t=new Thread(this);
				t.start();
			}
		}
		else if(s.equals("Enter"))
		{
			if(l3.getText().equals("GameOver! (Press enter to reset)"))
			{
				run=true;
				x=y=200;
				p=0;l2.setText("" + p);
				speed=50;
				x1 = rand.nextInt(448);
				y1 = rand.nextInt(394);
				l3.setText("Eat!   (Use arrow keys to control)");
			}	
		}
		repaint();
	}

	public void keyTyped(KeyEvent ke) 
	{
	}
	public void keyReleased(KeyEvent ke) 
	{
	}
	
	public void run()
	{
		if(p>10*i)
		{
			if(speed>20)
			{
				speed=speed-10;
			}
			else if(speed>1)
			{
				speed =speed-2;
			}
			i++;
		}
		if(c==1)	
		{
			while(true)
			{	
				try
				{
					t.sleep(speed);
				}
				catch(Exception e){}
				x=x-5;
				repaint();
				if(x<=3)
				{
					x=4;
					l3.setText("GameOver! (Press enter to reset)");
					run=false;
					break;	
				}
				if(x>=x1-50 && x<=x1+50 && y>y1-50 && y<y1+50)
				{
					p++;
					l2.setText("" + p);
					x1 = rand.nextInt(448);
					y1 = rand.nextInt(394);
				}
			}
		}
		if(c==2)	
		{
			while(true)
			{	
				try
				{
					t.sleep(speed);
				}
				catch(Exception e){}
				y=y-5;
				repaint();
				if(y<=25)
				{
					y=26;
					l3.setText("GameOver! (Press enter to reset)");
					run=false;
					break;	
				}
				if(x>=x1-50 && x<=x1+50 && y>y1-50 && y<y1+50)
				{
					p++;
					l2.setText("" + p);
					x1 = rand.nextInt(448);
					y1 = rand.nextInt(394);
				}
			}
		}
		if(c==3)	
		{
			while(true)
			{	
				try
				{
					t.sleep(speed);
				}
				catch(Exception e){}
				y=y+5;
				repaint();
				if(y>=394)
				{
					y=393;
					l3.setText("GameOver! (Press enter to reset)");
					run=false;	
					break;	
				}
				if(x>=x1-50 && x<=x1+50 && y>y1-50 && y<y1+50)
				{
					p++;
					l2.setText("" + p);
					x1 = rand.nextInt(448);
					y1 = rand.nextInt(394);
				}
			}
		}
		if(c==4)	
		{
			while(true)
			{	
				try
				{
					t.sleep(speed);
				}
				catch(Exception e){}
				x=x+5;
				repaint();
				if(x>=447)
				{
					x=446;
					l3.setText("GameOver! (Press enter to reset)");
					run=false;
					break;	
				}
				if(x>=x1-50 && x<=x1+50 && y>y1-50 && y<y1+50)
				{
					p++;
					l2.setText("" + p);
					x1 = rand.nextInt(448);
					y1 = rand.nextInt(394);
				}
			}
		}

	}

	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new Color(0, 255, 0));
		g.fillOval(x,y,50,50);
		g.drawOval(x1,y1,50,50);
	}
	
	public void windowOpened(WindowEvent we){}
	public void windowActivated(WindowEvent we){}
	public void windowDeactivated(WindowEvent we){}
	public void windowIconified(WindowEvent we){}
	public void windowDeiconified(WindowEvent we){}
	public void windowClosed(WindowEvent we){}
	public void windowClosing(WindowEvent we)
	{
		System.out.println("Closed");
		System.exit(0);
	}

	public static void main(String args[])
	{
		Snake game=new Snake();
	}
}


