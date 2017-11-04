import java.awt.*;
class Demo2
{
	public static void main(String args[])
	{
		Frame f=new Frame();
		f.setSize(400,400);
		f.setLayout(new FlowLayout());
		Panel p1=new Panel();
		p1.setBackground(Color.red);
		Panel p2=new Panel();
		p2.setBackground(Color.green);
		Label l=new Label("name");
		TextField t=new TextField(20);
		Button b1=new Button("OK");
		Button b2=new Button("Cancel");
		p1.add(l);
		p2.add(b1);
		p1.add(t);
		p2.add(b2);
		f.add(p1);
		f.add(p2);
		f.setVisible(true);
	}
}