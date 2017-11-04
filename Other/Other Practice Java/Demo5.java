import java.awt.*;
class MyFrame extends Frame
{
	public void paint(Graphics g)
	{
		g.drawLine(0,0,50,40);
		g.setColor(Color.black);
	}
	public static void main(String args[])
	{
		MyFrame mf=new MyFrame();
		mf.setSize(400,400);
		mf.setVisible(true);
	}
}