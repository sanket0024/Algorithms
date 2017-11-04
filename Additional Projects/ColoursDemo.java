import java.awt.*;
import java.awt.event.*;
class ColoursDemo implements AdjustmentListener
{
	int a,b,c;
	Frame f;
	TextField t1,t2,t3;
	Label l1,l2,l3;
	Panel p1,p2,p3;
	Scrollbar s1,s2,s3;
	Color col;
	public ColoursDemo()
	{
		f=new Frame();
		f.setLayout(new BorderLayout());
		f.setSize(400,400);
		p1=new Panel();
		p1.setLayout(new GridLayout(1,3));
		s1=new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		s1.addAdjustmentListener(this);
		s2=new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		s2.addAdjustmentListener(this);
		s3=new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		s3.addAdjustmentListener(this);
		p1.add(s1);
		p1.add(s2);
		p1.add(s3);
		f.add(p1,"East");
		p2=new Panel();
		l1=new Label("RED");
		t1=new TextField(5);
		l2=new Label("GREEN");
		t2=new TextField(5);
		l3=new Label("BLUE");
		t3=new TextField(5);
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		p2.add(l3);
		p2.add(t3);
		f.add(p2,"South");
		p3=new Panel();
		f.add(p3,"Center");
		f.setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		a=s1.getValue();
		b=s2.getValue();
		c=s3.getValue();
		t1.setText(a+"");
		t2.setText(b+"");
		t3.setText(c+"");
		col=new Color(a,b,c);
		p3.setBackground(col);
	}
	public static void main(String args[])
	{
		ColoursDemo cd=new ColoursDemo();
	}
}