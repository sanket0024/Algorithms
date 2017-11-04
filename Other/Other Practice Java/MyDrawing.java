import java.awt.*;
import java.awt.event.*;
class MyDrawing extends MouseMotionAdapter
{
	Graphics g;
	Frame f;
	int x,y,a,b;
	public MyDrawing()
	{
		f=new Frame();
		f.setSize(400,400);
		f.addMouseMotionListener(this);
		f.setVisible(true);
		g=f.getGraphics();
		WindowCloser wc=new WindowCloser();
		f.addWindowListener(wc);
	}
	public void mouseMoved(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		g.setColor(Color.blue);
		g.drawLine(x,y,a,b);
		a=x;
		b=y;
	}
	public static void main(String args[])
	{
		MyDrawing md=new MyDrawing();
	}
}