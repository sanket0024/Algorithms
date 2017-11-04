import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame
{
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(10,12,400,250);
	}
	public static void main(String args[])
	{
		MyFrame f=new MyFrame();
		f.setSize(400,400);
		f.setVisible(true);
	}
}