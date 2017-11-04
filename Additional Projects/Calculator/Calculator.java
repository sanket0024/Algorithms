import java.awt.*;
import java.awt.event.*;
class Calculator implements ActionListener
{
	long x;
	int count=0,oo=0,dcount=0,l=0;;
	float y;
	String s1,s2,s3,s4,s5,s6="0";
	Frame f;
	Panel p1,p2;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	TextField t;
	public Calculator()
	{
		f=new Frame();
		f.setSize(200,300);
		f.setLayout(new BorderLayout());
		t=new TextField("0");
		f.add(t,"North");
		p1=new Panel();
		p1.setLayout(new GridLayout(4,4));
		Button b1=new Button("1");
		b1.addActionListener(this);
	    Button b2=new Button("2");
	    b2.addActionListener(this);
	 	Button b3=new Button("3");
	 	b3.addActionListener(this);
	 	Button b4=new Button("+");
	 	b4.addActionListener(this);
	 	Button b5=new Button("4");
	 	b5.addActionListener(this);
	 	Button b6=new Button("5");
	 	b6.addActionListener(this);
	    Button b7=new Button("6");
	    b7.addActionListener(this);
	    Button b8=new Button("-");
	    b8.addActionListener(this);
	 	Button b9=new Button("7");
	 	b9.addActionListener(this);
	 	Button b10=new Button("8");
	 	b10.addActionListener(this);
	 	Button b11=new Button("9");
	 	b11.addActionListener(this);
	 	Button b12=new Button("*");
	 	b12.addActionListener(this);
	 	Button b13=new Button("A/C");
	 	b13.addActionListener(this);	
	    Button b14=new Button("0");
	    b14.addActionListener(this);
	 	Button b15=new Button("/");
	 	b15.addActionListener(this);
	 	Button b16=new Button("=");
	 	b16.addActionListener(this);
	 	p1.add(b1);
	 	p1.add(b2);
	 	p1.add(b3);
	 	p1.add(b4);
	 	p1.add(b5);
	 	p1.add(b6);
	    p1.add(b7);
 		p1.add(b8);
        p1.add(b9);	
	 	p1.add(b10);
	 	p1.add(b11);
	 	p1.add(b12);
	 	p1.add(b13);
	 	p1.add(b14);
        p1.add(b15);
 		p1.add(b16);
        f.add(p1);
 		f.setVisible(true);	
 		//WindowCloser wc=new WindowCloser();
 		//f.addWindowListener(wc);
	}
	public void actionPerformed(ActionEvent e) throws NullPointerException
	{
		/*if(l==2)
		{
			System.out.print("hi");
			l=0;
			return;
		}*/
		if(e.getActionCommand()=="1")
		{
			s1=t.getText();
			s2="1";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}	
		if(e.getActionCommand()=="2")
		{
			s1=t.getText();
			s2="2";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="3")
		{
			s1=t.getText();
			s2="3";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="4")
		{
			s1=t.getText();
			s2="4";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="5")
		{
			s1=t.getText();
			s2="5";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="6")
		{
			s1=t.getText();
			s2="6";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="7")
		{
			s1=t.getText();
			s2="7";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="8")
		{
			s1=t.getText();
			s2="8";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="9")
		{
			s1=t.getText();
			s2="9";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;
		}
		if(e.getActionCommand()=="0")
		{
			s1=t.getText();
			s2="0";
			if(s1.equals("0") || s1.equals("") || oo>0)
			{
				s3=s2;
			}
			else
			{
				s3=s1+s2;
			}
			oo=0;
			t.setText(s3);
			l=0;	
		}
		if(e.getActionCommand()=="A/C")
		{
			t.setText("0");
			count=0;
			oo=0;
			l=0;
		}

		if(e.getActionCommand()=="+" || e.getActionCommand()=="=")
		{
			
			oo++;
			if(l==0)
			{
				count++;
			s4=t.getText();
			s5=t.getText();
			t.setText("");
			if(x==0)
			{
				if(count>2)
				{
					y=y+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				 {
					t.setText("");
				}
			}
			if(x==1)
			{	
				if(count>2)
				{
					y=y-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==2)
			{
				if(count>2)
				{
					y=y*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==3)
			{
				if(count>2)
				{
					y=y/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Float.parseFloat(s6)/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}}
			s6=s4;
			x=0;
			l++;
			dcount=count;
		}
		if(e.getActionCommand()=="-" || e.getActionCommand()=="=")
		{
			
			oo++;
			if(l==0)
			{
				count++;
			s4=t.getText();
			s5=t.getText();
			t.setText("");
			if(x==0)
			{
				if(count>2)
				{
					y=y+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==1)
			{	
				if(count>2)
				{
					y=y-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==2)
			{
				if(count>2)
				{
					y=y*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==3)
			{
				if(count>2)
				{
					y=y/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Float.parseFloat(s6)/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}}
			s6=s4;
			x=1;
			dcount=count;
			l++;
		}
		if(e.getActionCommand()=="*" || e.getActionCommand()=="=")
		{
			
			oo++;
			if(l==0)
			{
				count++;
			s4=t.getText();
			s5=t.getText();
			t.setText("");
			if(x==0)
			{
				if(count>2)
				{
					y=y+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==1)
			{	
				if(count>2)
				{
					y=y-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==2)
			{
				if(count>2)
				{
					y=y*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==3)
			{
				if(count>2)
				{
					y=y/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Float.parseFloat(s6)/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}}
			s6=s4;
			x=2;
			dcount=count;
			l++;
		}
		if(e.getActionCommand()=="/" || e.getActionCommand()=="=")
		{
			
			oo++;
			if(l==0)
			{
				count++;
			s4=t.getText();
			s5=t.getText();
			t.setText("");
			if(x==0)
			{
				if(count>2)
				{
					y=y+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==1)
			{	
				if(count>2)
				{
					y=y-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==2)
			{
				if(count>2)
				{
					y=y*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Long.parseLong(s6)*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}
			if(x==3)
			{
				if(count>2)
				{
					y=y/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else if(count==2)
				{
					y=Float.parseFloat(s6)/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
				else
				{
					t.setText("");
				}
			}}
			s6=s4;
			x=3;
			dcount=count;
			l++;
		}
		/*if(e.getActionCommand()=="=")
		{
			count=0;
			oo=0;
			s5=t.getText();
			if(dcount>1)
			{
				if(x==0)
				{
					y=Long.parseLong(s4)+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==1)
				{
					y=Long.parseLong(s4)-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==2)
				{
					y=Long.parseLong(s4)*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==3)
				{
					y=Float.parseFloat(s4)/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
			}
			else
			{
				if(x==0)
				{
					y=y+Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==1)
				{
					y=y-Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==2)
				{
					y=y*Long.parseLong(s5);
					t.setText(String.valueOf(y));
				}
				if(x==3)
				{
					y=y/Float.parseFloat(s5);
					t.setText(String.valueOf(y));
				}
			}
		}*/
	}
	public static void main(String args[])
	{
		Calculator cl=new Calculator();
	}
}
