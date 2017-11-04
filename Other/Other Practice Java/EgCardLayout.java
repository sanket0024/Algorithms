import java.awt.*;
import java.awt.event.*;
class EgCardLayout implements ActionListener
{
	Frame f;
	Button b1,b2;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
	Panel p1,p2,p3,p4,p5,p6,p;
	CardLayout cl=new CardLayout(5,5);
	public EgCardLayout()
	{
		p2=new Panel();
		p2.setLayout(cl);
		f=new Frame();
		f.setLayout(new BorderLayout());
		f.setSize(400,400);
		b1=new Button("Next");
		b1.addActionListener(this);
		b2=new Button("Previous");
		b2.addActionListener(this);
		p1=new Panel();
		p1.add(b1);
		p1.add(b2);
		f.add(p1,"South");
		p3=new Panel();
		p3.setLayout(new GridLayout(4,4));
		l1=new Label("Name");
		t1=new TextField(10);
		l2=new Label("Surname");
		t2=new TextField(10);
		l3=new Label("Age");
		t3=new TextField(10);
		l4=new Label("Qualification");
		t4=new TextField(10);
		p3.add(l1);
		p3.add(t1);
		p3.add(l2);
		p3.add(t2);
		p3.add(l3);
		p3.add(t3);
		p3.add(l4);
		p3.add(t4);
		//f.add(p3,"Center");
		p4=new Panel();
		p4.setLayout(new GridLayout(4,4));
		l5=new Label("House Number");
		t5=new TextField(10);
		l6=new Label("Street");
		t6=new TextField(10);
		l7=new Label("City");
		t7=new TextField(10);
		l8=new Label("State");
		t8=new TextField(10);
		p4.add(l5);
		p4.add(t5);
		p4.add(l6);
		p4.add(t6);
		p4.add(l7);
		p4.add(t7);
		p4.add(l8);
		p4.add(t8);
		//f.add(p4,"Center");
		p5=new Panel();
		p5.setLayout(new GridLayout(4,4));
		l9=new Label("Phone");
		t9=new TextField(10);
		l10=new Label("Mobile");
		t10=new TextField(10);
		l11=new Label("E-mail");
		t11=new TextField(10);
		l12=new Label("Fax");
		t12=new TextField(10);
		p5.add(l9);
		p5.add(t9);
		p5.add(l10);
		p5.add(t10);
		p5.add(l11);
		p5.add(t11);
		p5.add(l12);
		p5.add(t12);
		//f.add(p5,"Center");
		p6=new Panel();
		p6.setLayout(new GridLayout(4,4));
		l13=new Label("Salary");
		t13=new TextField(10);
		l14=new Label("HRA");
		t14=new TextField(10);
		l15=new Label("DA");
		t15=new TextField(10);
		l16=new Label("Total");
		t16=new TextField(10);
		p6.add(l13);
		p6.add(t13);
		p6.add(l14);
		p6.add(t14);
		p6.add(l15);
		p6.add(t15);
		p6.add(l16);
		p6.add(t16);
		//f.add(p6,"Center");
		for(int i=0;i<10;i++)
		{
			p=new Panel();
			p.setLayout(new GridLayout(4,4));
			l9=new Label("Phone");
			t9=new TextField(10);
			l10=new Label("Mobile");
			t10=new TextField(10);
			l11=new Label("E-mail");
			t11=new TextField(10);
			l12=new Label("Fax");
			t12=new TextField(10);
			p.add(l9);
			p.add(t9);
			p.add(l10);
			p.add(t10);
			p.add(l11);
			p.add(t11);
			p.add(l12);
			p.add(t12);
			p2.add(p,"Contact");
			//f.add(p5,"Center");
		}
		
		p2.add(p3,"Name");
		p2.add(p4,"Address");
		p2.add(p5,"Contact");
		p2.add(p6,"Salary");
		f.add(p2,"Center");
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		if(str.equals("Next"))
		{
			cl.next(p2);
			//cl.show(p2,str);
		}
		else
		{
			cl.previous(p2);
			//cl.show(p2,str);
		}
	}
	public static void main(String args[])
	{
		EgCardLayout ecl=new EgCardLayout();
	}
}