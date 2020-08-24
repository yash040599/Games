import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class Client extends Frame implements ActionListener,Runnable
{
       Socket s;
       
	BufferedReader br;
	BufferedWriter bw;

	Label l ;	
	TextField text;
        Button sendBut, exitBut;
        List list;
	public Client(String pcname)
	{
                setSize(430, 300);

                setTitle("Client");
                setLocation(100,100);
                setResizable(false);

                setBackground(new Color(192, 192, 192));
                
                list = new List();
		add(list);

		Panel panel= new Panel();
                sendBut = new Button("Send");
                exitBut = new Button("Exit");

                sendBut.addActionListener(this);
                exitBut.addActionListener(this);

                text = new TextField(25);
		l = new Label("Msg");
		panel.add(l);
                panel.add(text);
                panel.add(sendBut);
                panel.add(exitBut);     

                add(panel,BorderLayout.SOUTH);

                setVisible(true);
		try
		{
			s = new Socket(pcname,1053);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			Thread t =new Thread(this);
			t.start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Exit"))
			System.exit(0);
		else
		{
		    try{
			list.add("Client:"+text.getText());
			bw.write(text.getText());
			bw.newLine();
			bw.flush();

			text.setText(" ");

		     }catch(Exception e){}
		}
	}
	public void run()
	{
		while(true)	
		{
			try{
			  list.add("Server:"+br.readLine());
			}catch(Exception e){}
		}
	}
	public static void main(String args[])
	{
		Client s = new Client(args[0]);
	}
}
