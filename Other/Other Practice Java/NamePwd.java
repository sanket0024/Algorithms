import java.awt.*;
class NamePwd
{
	public static void main(String args[])
	{
		Frame f=new Frame();
		f.setLayout(new GridBagLayout());
		f.setSize(400,400);
		Label l1=new Label("Name");
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		Insets i=new Insets(6,9,10,10);
		gbc.insets=i;
		//gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.ipadx=2;
		gbc.ipady=2;
		gbc.weightx=2;
		gbc.weighty=2;
		f.add(l1,gbc);
		TextField t1=new TextField(10);
		gbc.gridx=1;
		gbc.gridy=0;
		Insets i1=new Insets(10,10,10,10);
		gbc.insets=i1;
		gbc.weightx=2;
		gbc.weighty=1;
		f.add(t1,gbc);
		Label l2=new Label("Password");
		gbc.gridx=0;
		gbc.gridy=1;
		Insets i2=new Insets(10,10,10,10);
		gbc.insets=i2;
		gbc.weightx=2;
		gbc.weighty=1;
		f.add(l2,gbc);
		TextField t2=new TextField(10);
		gbc.gridx=1;
		gbc.gridy=1;
		Insets i3=new Insets(10,10,10,10);
		gbc.insets=i3;
		f.add(t2,gbc);
		Button b1=new Button("OK");
		gbc.anchor=GridBagConstraints.EAST;
		gbc.gridx=0;
		gbc.gridy=2;
		f.add(b1,gbc);
		f.setVisible(true);
	}
}