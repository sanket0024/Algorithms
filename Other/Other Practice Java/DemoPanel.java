import java.awt.*;
class DemoPanel
{
	public static void main(String args[])
	{
		Frame f=new Frame();
		f.setSize(400,400);
		f.setLayout(new GridLayout(2,2));
		Panel p1=new Panel();
		p1.setLayout(new GridLayout(2,1));
		Panel p2=new Panel();
		p2.setLayout(new GridLayout(1,3));
		Panel p3=new Panel();
		p3.setLayout(new GridLayout(1,2));
		Panel p4=new Panel();
		p4.setLayout(new GridLayout(2,1));
		Button b1=new Button("1");
		Button b2=new Button("2");
		Button b3=new Button("3");
		Button b4=new Button("4");
		Button b5=new Button("5");
		Button b6=new Button("6");
		Button b7=new Button("7");
		Button b8=new Button("8");
		Button b9=new Button("9");
		Button b10=new Button("10");
		Button b11=new Button("11");
		Button b12=new Button("12");
		Button b13=new Button("13");
		Button b14=new Button("14");
		Button b15=new Button("15");
		Button b16=new Button("16");
		Button b17=new Button("17");
		p1.add(b1);
		p1.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		f.add(p1);
		f.add(p2);
		Panel p5=new Panel();
		p5.setLayout(new GridLayout(2,1));
		p5.add(b6);
		p5.add(b7);
		p3.add(p5);
		Panel p6=new Panel();
		p6.setLayout(new GridLayout(3,1));
		p6.add(b8);
		p6.add(b9);
		p6.add(b10);
		p3.add(p6);
		f.add(p3);
		Panel p7=new Panel();
		p7.setLayout(new GridLayout(1,2));
		p7.add(b11);
		p7.add(b12);
		p4.add(p7);
		Panel p8=new Panel();
		p8.setLayout(new GridLayout(1,3));
		p8.add(b13);
		p8.add(b14);
		p8.add(b15);
		p4.add(p8);
		f.add(p4);
		f.setVisible(true);
	}
}