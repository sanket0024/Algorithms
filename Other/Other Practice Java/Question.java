import java.awt.*;
class Question
{
	public static void main(String args[])
	{
		CompleteFrame cf=new CompleteFrame();
		f.setSize(400,400);
		BorderLayout b1=new BorderLayout();
		f.setLayout(b1);
		Label l=new Label("Question: Capital of India?");
		f.add(l,"North");
		f.add(getChoices(),"West");
		f.add(getOptions(),"Center");
		f.setVisible(true);
	}
	static Frame getChoices()
	{
		Frame f=new Frame();
		f.setLayout(new GridLayout(4,1));
		Label l1=new Label("A");
		Label l2=new Label("B");
		Label l3=new Label("C");
		Label l4=new Label("D");
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		return f;
	}
	static Frame getOptions()
	{
		Frame f=new Frame();
		f.setLayout(new GridLayout(4,1));
		f.add(new Checkbox("Jaipur"));
		f.add(new Checkbox("Kolkata"));
		f.add(new Checkbox("Mumbai"));
		f.add(new Checkbox("Delhi"));
		return f;
	}
		/*Frame f=new Frame();
		f.setSize(400,400);
		BorderLayout b1=new BorderLayout();
		f.setLayout(b1);
		Label l=new Label("Question: Capital of India?");
		f.add(l,"North");
		f.add(getChoices(),"West");
		f.add(getOptions(),"Center");
		Label l1=new Label("A");
		Label l2=new Label("B");
		Label l3=new Label("C");
		Label l4=new Label("D");
		f.add(l1,"West");
		f.add(l2,"West");
		f.add(l3,"West");
		f.add(l4,"West");
		f.add(new Checkbox("Jaipur"),"Center");
		f.add(new Checkbox("Kolkata"),"Center");
		f.add(new Checkbox("Mumbai"),"Center");
		f.add(new Checkbox("Delhi"),"Center");*/
		
	
}