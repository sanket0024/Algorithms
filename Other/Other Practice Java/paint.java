import java.awt.*;
import java.awt.event.*;

class paint implements MouseMotionListener
{
	Frame f;
	int a,b;
	int x,y;
	Graphics g;
	public paint()
	{
	f=new Frame();
	f.setSize(400,400);
	f.addMouseMotionListener(this);

	f.setVisible(true);
	g=f.getGraphics();
	WindowCloser wc=new WindowCloser();
	f.addWindowListener(wc);
	}
	public void mouseDragged(MouseEvent e1)
	{
	                  
	x=e1.getX();	y=e1.getY();
	if(!(a==0&&b==0))
	{
	g.drawLine(x,y,a,b);
	}
	a=x;
	b=y;
	}
	
	public void mouseMoved(MouseEvent e2) 
	{
	a=0;
	b=0;
	}
	public static void main(String Args[])
	{
	paint  p1=new paint();
	}
}