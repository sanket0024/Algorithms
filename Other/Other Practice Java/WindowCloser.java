import java.awt.*;
import java.awt.event.*;
public class WindowCloser extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		Window w=e.getWindow();
		w.setVisible(false);
		w.dispose();
		System.exit(1);
	}
}