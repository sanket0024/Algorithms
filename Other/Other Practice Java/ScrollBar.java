import java.awt.*;
import java.awt.event.*;
class ScrollBar
{
	public static void main(String args[])
	{
		Frame f=new Frame();
		f.setSize(400,400);
		f.setLayout(new BorderLayout());
		Panel p1=new Panel();
		p1.setLayout(new GridLayout(1,3));
		p1.add(new Scrollbar());
		p1.add(new Scrollbar());
		p1.add(new Scrollbar());
		f.add(p1,"East");
		f.setVisible(true);
	}
}