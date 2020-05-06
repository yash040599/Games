import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class ttt extends Frame implements ActionListener, WindowListener
{
	JButton b[] = new JButton[9];
	Label info;
	Button r;
	int f=1,c=0,win=0;
	Panel pb;

	public ttt()
	{
		setLayout(new BorderLayout());

		Label head=new Label("Tic-Tac-Toe", Label.CENTER);
		add(head,BorderLayout.NORTH);
 		head.setBackground(Color.black);
  		head.setForeground(Color.white);
  		head.setFont(new Font("Serif", Font.BOLD, 50));
		
		pb=new Panel();
		
		info=new Label("A's turn", Label.CENTER);
  		info.setForeground(Color.red);
		info.setBackground(Color.white);
  		info.setFont(new Font("Serif", Font.BOLD, 30));

		r=new Button("Reset");
		r.setBackground(Color.white);
  		r.setForeground(Color.black);
  		r.setFont(new Font("Serif", Font.BOLD, 30));
		r.addActionListener(this);

		pb.add(info);pb.add(r);
		add(pb,BorderLayout.SOUTH);
		pb.setBackground(Color.white);
		
		Panel p=new Panel();
		p.setLayout(new GridLayout(3,3));

		for(int i=0;i<9;i++)
		{
			b[i] = new JButton();
			b[i].addActionListener(this);
			b[i].setBackground(Color.white);
  			b[i].setForeground(Color.black);
			b[i].setFont(new Font("Serif", Font.BOLD, 1));
			b[i].setBorder(new LineBorder(Color.BLACK));
			p.add(b[i]);
		}
		b[0].setLabel("1");
		b[1].setLabel("2");
		b[2].setLabel("3");
		b[3].setLabel("4");
		b[4].setLabel("5");
		b[5].setLabel("6");
		b[6].setLabel("7");
		b[7].setLabel("8");
		b[8].setLabel("9");

		add(p,BorderLayout.CENTER);
		p.setBackground(Color.white);

		addWindowListener(this);

		setTitle("Tic-Tac-Toe");
		setSize(300,300);
		setVisible(true);
		setResizable(false);
	}
	private void gameover()
	{
		System.out.println("GameOver");
		
		for(int i=0;i<9;i++)
		{
			b[i].setEnabled(false);
		}
		if(f==1 && win==1)
		{
			pb.setBackground(Color.blue);
			info.setBackground(Color.blue);
			info.setText("B WINS");
			info.setForeground(Color.white);
		}
		else if(f==2 && win==1)
		{
			pb.setBackground(Color.red);
			info.setBackground(Color.red);
			info.setText("A WINS");
			info.setForeground(Color.white);
		}
		else if(c==9)
		{
			System.out.println("draw case");
			pb.setBackground(Color.black);
			info.setBackground(Color.black);
			info.setText("DRAW");
			info.setForeground(Color.white);
		}	
	}
	private void checkWin()
	{
		int i=0,j=0;
		win=0;
		while(i<7 && j<3)	
		{
			if(b[i].getLabel().equals(b[i+1].getLabel()) && b[i+1].getLabel().equals(b[i+2].getLabel()))
			{
				win=1;break;
			}
			i+=3;
			if(b[j].getLabel().equals(b[j+3].getLabel()) && b[j+3].getLabel().equals(b[j+6].getLabel()))
			{
				win=1;break;
			}
			j+=1;
		}
		if(win==1)
		{
			gameover();
		}
		else if(b[0].getLabel().equals(b[4].getLabel()) && b[4].getLabel().equals(b[8].getLabel()))
		{
			win=1;
			gameover();
		}
		else if(b[2].getLabel().equals(b[4].getLabel()) && b[4].getLabel().equals(b[6].getLabel()))
		{
			win=1;
			gameover();
		}
		else if(c==9)
		{
			gameover();
		}
	}
	public void actionPerformed(ActionEvent ae) 
	{
		String s=ae.getActionCommand();
		if(s.equals("Reset"))
		{
			System.out.println("Reset");
			f=1;c=0;
			pb.setBackground(Color.white);
			info.setForeground(Color.red);
			info.setBackground(Color.white);
			info.setText("A's turn");
			b[0].setLabel("1");
			b[1].setLabel("2");
			b[2].setLabel("3");
			b[3].setLabel("4");
			b[4].setLabel("5");
			b[5].setLabel("6");
			b[6].setLabel("7");
			b[7].setLabel("8");
			b[8].setLabel("9");	
			
			for(int i=0;i<9;i++)
			{
				b[i].setBackground(Color.white);
  				b[i].setForeground(Color.black);
				b[i].setFont(new Font("Serif", Font.BOLD, 1));
				b[i].setEnabled(true);
			}
		}
		if(s.equals("1"))
		{
			if(f==1)
			{
				b[0].setLabel("X");
				b[0].setBackground(Color.red);
				b[0].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[0].setLabel("O");
				b[0].setBackground(Color.blue);
				b[0].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[0].setEnabled(false);
			checkWin();
		}
		if(s.equals("2"))
		{
			if(f==1)
			{
				b[1].setLabel("X");
				b[1].setBackground(Color.red);
				b[1].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[1].setLabel("O");
				b[1].setBackground(Color.blue);
				b[1].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[1].setEnabled(false);
			checkWin();
		}
		if(s.equals("3"))
		{
			if(f==1)
			{
				b[2].setLabel("X");
				b[2].setBackground(Color.red);
				b[2].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[2].setLabel("O");
				b[2].setBackground(Color.blue);
				b[2].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[2].setEnabled(false);
			checkWin();
		}
		if(s.equals("4"))
		{
			if(f==1)
			{
				b[3].setLabel("X");
				b[3].setBackground(Color.red);
				b[3].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[3].setLabel("O");
				b[3].setBackground(Color.blue);
				b[3].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[3].setEnabled(false);
			checkWin();
		}
		if(s.equals("5"))
		{
			if(f==1)
			{
				b[4].setLabel("X");
				b[4].setBackground(Color.red);
				b[4].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[4].setLabel("O");
				b[4].setBackground(Color.blue);
				b[4].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[4].setEnabled(false);
			checkWin();
		}
		if(s.equals("6"))
		{
			if(f==1)
			{
				b[5].setLabel("X");
				b[5].setBackground(Color.red);
				b[5].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[5].setLabel("O");
				b[5].setBackground(Color.blue);
				b[5].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[5].setEnabled(false);
			checkWin();
		}
		if(s.equals("7"))
		{
			if(f==1)
			{
				b[6].setLabel("X");
				b[6].setBackground(Color.red);
				b[6].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[6].setLabel("O");
				b[6].setBackground(Color.blue);
				b[6].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[6].setEnabled(false);
			checkWin();
		}
		if(s.equals("8"))
		{
			if(f==1)
			{
				b[7].setLabel("X");
				b[7].setBackground(Color.red);
				b[7].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[7].setLabel("O");
				b[7].setBackground(Color.blue);
				b[7].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[7].setEnabled(false);
			checkWin();
		}
		if(s.equals("9"))
		{
			if(f==1)
			{
				b[8].setLabel("X");
				b[8].setBackground(Color.red);
				b[8].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.blue);
				info.setText("B's turn");
				f=2;
			}
			else
			{
				b[8].setLabel("O");
				b[8].setBackground(Color.blue);
				b[8].setFont(new Font("Serif", Font.BOLD, 50));
				info.setForeground(Color.red);
				info.setText("A's turn");
				f=1;
			}
			c++;
			b[8].setEnabled(false);
			checkWin();
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
		ttt t=new ttt() ;
	}
}


