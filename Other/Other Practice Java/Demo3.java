import java.awt.*;
import java.awt.event.*;
class Demo3 implements AdjustmentListener
{
	Frame f;
	Scrollbar sb;
	TextField t;
	Label l;
	Panel p;
	public Demo3()
	{
		f=new Frame();
		f.setSize(400,400);
		sb=new Scrollbar(Scrollbar.VERTICAL,0,5,0,30);
		sb.addAdjustmentListener(this);
		p=new Panel();
		l=new Label("Value");
		t=new TextField(5);
		p.add(l);
		p.add(t);
		f.add(p,"South");
		f.add(sb,"East");
		f.setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		int no=sb.getValue();
		t.setText(no+"");
	}
	public static void main(String args[])
	{
		Demo3 d=new Demo3();
	}
}