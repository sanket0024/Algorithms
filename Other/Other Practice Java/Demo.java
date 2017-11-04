import java.awt.*;
import java.applet.*;
public class Demo extends Applet
{
	public void init()
	{
		Label l=new Label("Enter name: ");
		add (l);
		TextField t=new TextField(10);
		add(t);
		Button b=new Button("Click");
		add (b);
	}
}