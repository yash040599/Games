import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class GuessGame extends Frame implements ActionListener, WindowListener
{
	Random rand = new Random();
	int r = rand.nextInt(100);
	int n=0;

	Label nhits, range,result;
	TextField tf;
	public GuessGame()
	{
		setLayout(new BorderLayout());

		Label head=new Label("Guess A Number", Label.CENTER);
		add(head,BorderLayout.NORTH);
 		head.setBackground(Color.black);
  		head.setForeground(Color.white);
  		head.setFont(new Font("Serif", Font.BOLD, 50));
		
		Panel p=new Panel();
		p.setLayout(new GridLayout(3,3));
		Label n= new Label("Guess A Number:", Label.CENTER);
		n.setFont(new Font("Serif", Font.BOLD, 20));
		n.setBackground(Color.yellow);
  		n.setForeground(Color.blue);
		tf = new TextField(10);
		Button go = new Button("Go");
		go.addActionListener(this);

		Label hits= new Label("Hits:", Label.CENTER);
		hits.setFont(new Font("Serif", Font.BOLD, 20));
		hits.setBackground(Color.pink);
  		hits.setForeground(Color.blue);
		nhits= new Label("0",Label.CENTER);
		nhits.setFont(new Font("Serif", Font.BOLD, 20));
		Button reset = new Button("Reset");
		reset.addActionListener(this);

		range = new Label(" ",Label.CENTER);
		range.setFont(new Font("Serif", Font.BOLD, 20));
		Label dev = new Label("Game Developed by Yash",Label.CENTER);
		dev.setFont(new Font("Serif", Font.BOLD, 13));
		dev.setBackground(Color.green);
  		dev.setForeground(Color.black);
		result= new Label("Try", Label.CENTER);
		result.setFont(new Font("Serif", Font.BOLD, 20));

		p.add(n);p.add(tf);p.add(go);p.add(hits);p.add(nhits);p.add(reset);p.add(range);p.add(dev);p.add(result);
		add(p,BorderLayout.CENTER);

		addWindowListener(this);

		setTitle("Guess A Number");
		setSize(500,500);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) 
	{
		String s=ae.getActionCommand();
		if(s.equals("Go"))
		{
			int in = Integer.parseInt(tf.getText());
			tf.setText("");
			n++;
			if(in==r)
			{
				result.setText("Congrats");
				nhits.setText(" " +n);
				range.setText(" " + r);
			}
			else if(in<r)
			{
				range.setText("Small");
				nhits.setText(" " +n);
				result.setText("Try Again");
			}
			else
			{
				range.setText("Large");
				nhits.setText(" " +n);
				result.setText("Try Again");
			}
		}
		else if(s.equals("Reset"))
		{
			n=0;
			nhits.setText(" " +n);
			r = rand.nextInt(100);
			tf.setText("");
			result.setText("Try");
			range.setText(" ");
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
		GuessGame g=new GuessGame() ;
	}
}


