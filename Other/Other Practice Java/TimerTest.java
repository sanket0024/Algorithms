import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TimerTest extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    static JFrame frame;
    JButton b=new JButton("Start");
    static Timer clock;
    static JLabel timelabel;
    static Timer countdown;
    int time=0;
    public TimerTest()
	{
        setLayout(new FlowLayout());
        add(b);
        timelabel = new JLabel("Time Left = NULL", SwingConstants.CENTER);
        add(timelabel);
        clock = new Timer(1000, this);
        countdown = new Timer(1000, this);
        b.addActionListener(this);
    }
    public static void main(String args[])
    {
        frame = new JFrame();
        TimerTest contentpane = new TimerTest();
        frame.setContentPane(contentpane);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b)
        {
        	countdown.start();
        	timelabel.setText("Starting In: " + time);
        }
    }
}