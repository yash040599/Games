//Stop Watch

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class SW extends Frame implements ActionListener, WindowListener, Runnable
{
	Button b,reset,lap;
	int hr,min,sec,ms;
	Label l;
	Thread t;
	List list;

	public SW()
	{
		setLayout(new BorderLayout());
		Panel p=new Panel();

		b=new Button("Start");
		b.addActionListener(this);
		//add(b,BorderLayout.SOUTH);	
		b.setBackground(Color.white);
  		b.setForeground(Color.black);
  		b.setFont(new Font("Serif", Font.BOLD, 55));

		reset=new Button("Reset");
		reset.addActionListener(this);
		//add(reset,BorderLayout.SOUTH);	
		reset.setBackground(Color.white);
  		reset.setForeground(Color.black);
  		reset.setFont(new Font("Serif", Font.BOLD, 55));
		
		lap=new Button("Lap");
		lap.addActionListener(this);
		//add(reset,BorderLayout.SOUTH);	
		lap.setBackground(Color.white);
  		lap.setForeground(Color.black);
  		lap.setFont(new Font("Serif", Font.BOLD, 55));
		
		p.add(b);p.add(reset);p.add(lap);
		add(p,BorderLayout.SOUTH);
		p.setBackground(Color.black);
		
		/*
		Label l1=new Label("STOPWATCH", Label.CENTER);
		add(l1,BorderLayout.NORTH);
 		l1.setBackground(Color.black);
  		l1.setForeground(Color.white);
  		l1.setFont(new Font("Serif", Font.BOLD, 50));
		*/
		
		list =new List();	
		add(list,BorderLayout.CENTER);
		list.setBackground(Color.yellow);
  		list.setForeground(Color.blue);	
		list.setFont(new Font("Serif", Font.BOLD, 40));

		hr=min=sec=ms=0;
		l=new Label(hr + ":" + min + ":" + sec + ":" + ms, Label.CENTER);
		add(l,BorderLayout.NORTH);
 		l.setBackground(Color.black);
  		l.setForeground(Color.white);
  		l.setFont(new Font("Serif", Font.BOLD, 100));

		//t=new Thread(this);
		//t.start();

		addWindowListener(this);

		setTitle("StopWatch");
		setSize(500,500);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) 
	{
		String s=ae.getActionCommand();
		if(s.equals("Start"))
		{
			System.out.println("Started");	
			b.setLabel("Stop");
			t=new Thread(this);
			t.start();
	
		}
		else if(s.equals("Stop"))
		{
			System.out.println("Stoped");
			b.setLabel("Start");
			t.stop();
		}
		else if(s.equals("Reset"))
		{
			t.stop();
			b.setLabel("Start");
			System.out.println("Reset to 0:0:0:0");
			hr=min=sec=ms=0;
			l.setText(hr + ":" + min + ":" + sec + ":" + ms);	
			list.clear();	
		}
		else if(s.equals("Lap"))
		{
			System.out.println("Lap at " + hr + ":" + min + ":" + sec + ":" + ms);
			list.add( hr + ":" + min + ":" + sec + ":" + ms);
		}

	}

	public void run()
	{
		while(true)
		{
			try
			{
				t.sleep(100);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			ms++; 
			if(ms==10){sec++;ms=0;}
			if(sec==60){min++;sec=0;}
			if(min==60){hr++;min=0;}
			l.setText(hr + ":" + min + ":" + sec + ":" + ms);		
		}
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
		SW sw=new SW() ;
	}
}


