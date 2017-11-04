import java.awt.*;
import javax.swing.*;
public class SimpleTab extends JFrame
{
	JTabbedPane jtp;
	public SimpleTab()
	{
		setSize(200,200);
		jtp=new JTabbedPane();
		jtp.addTab("Tab1",new JLabel("Hello"));
		jtp.addTab("Tab2",new JTextField(20));
		add(jtp);
		setVisible(true);
	}
	public static void main(String args[])
	{
		SimpleTab=new SimpleTab();
	}
}