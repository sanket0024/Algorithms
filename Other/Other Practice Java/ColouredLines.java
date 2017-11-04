import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class ColouredLines extends Applet implements MouseMotionListener
{
	Frame f;
	int x,y;
	public ColouredLines()
	{
		f=new Frame();
		f.setSize(400,400);
		f.addMouseMotionListener(this);
		f.setVisible(true);
		System.out.print("CONS");
	}
	public void mouseMoved(MouseEvent e)
	{
		System.out.print("Event");
		x=e.getX();
		y=e.getY();
		System.out.print(x+" "+y);
	}
	public void mouseDragged(MouseEvent e1)
	{
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawLine(0,0,x,y);
		g.setColor(Color.blue);
		g.drawLine(0,400,x,y);
		g.setColor(Color.green);
		g.drawLine(400,0,x,y);
		g.setColor(Color.yellow);
		g.drawLine(400,400,x,y);
		
	}
	public void init()
	{
		ColouredLines cl=new ColouredLines();
	}
}