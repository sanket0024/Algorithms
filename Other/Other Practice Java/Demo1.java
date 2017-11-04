import java.awt.*;
import java.awt.event.*;
class Demo1 extends MouseAdapter
{
	Frame f;
	Label l;
	Button b1,b2;
	TextField t;
	public Demo1()
	{
		f=new Frame();
		f.setSize(400,300);
		f.setLayout(new FlowLayout());
		l=new Label("Enter name");
		l.addMouseListener(this);
		f.add(l);
		t=new TextField(20);
		f.add(t);
		b1=new Button("OK");
		b1.addMouseListener(this);
		f.add(b1);
		b2=new Button("Cancel");
		b2.addMouseListener(this);
		f.add(b2);
		f.setVisible(true);
	}
	public void mouseEntered(MouseEvent e)
	{
		System.out.println("Entered");
		if(e.getSource()==l)
		{
			t.setText("Label");	
		}
		else if(e.getSource()==b1)
		{
			t.setText("OK");
		}
		else if(e.getSource()==b2)
		{
			t.setText("Cancel");
		}
		else
		{
			t.setText("Nothing");
		}
	}
	public static void main(String args[])
	{
		Demo1 d1=new Demo1();
	}
}