import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
class Editor implements ActionListener
{
	Frame f;
	MenuBar mb;
	Menu m1,m2;  MenuItem nw,opn,sve,sva,ext,fnd,fndare;  
  	TextArea t;
  	String s1,s3;
    public Editor()
   {
   
	
	     f=new Frame();;
	     f.setSize(400,400);
	     mb=new MenuBar();
	     m1=new Menu("File");
	     m2=new Menu("Tool");
	     nw=new MenuItem("New");
	     opn=new MenuItem("Open");
	     sve=new MenuItem("Save");
	     ext=new MenuItem("Exit");
	     sva=new MenuItem("Save As");
	     fnd=new MenuItem("Find");
	     fndare=new MenuItem("Find and Replace");
         t=new TextArea();
	     nw.addActionListener(this);
	     opn.addActionListener(this);
	     m2.add(fnd);
	     m2.add(fndare);
	     m2.addSeparator();
	     m1.add(nw);
	     m1.add(opn);
	     m1.add(sve);
	     m1.add(sva);
	     m1.addSeparator();
	     m1.add(ext);
	     mb.add(m1);
	     mb.add(m2);
	     f.add(t);
	     f.setMenuBar(mb);
	     f.setVisible(true);
   }
	

public void actionPerformed(ActionEvent e)
{
	String str=e.getActionCommand();

	/*if(str.equals("New"))
	   {
	      //t=new TextArea();
	      f.setVisible(false);
	      f.dispose();
	      Editor ed=new Editor();
	      //f.add(t);
	  
	   }*/
  
	if(str.equals("Open"))
	{
		
		/*try
			{
				String s1,s3,str1;   //t=new TextArea();
				FileDialog fd1=new FileDialog(f,"Open",FileDialog.LOAD);
				fd1.setVisible(true);
				System.out.print("bgkvkj");
				FileReader fis=new FileReader(fd1.getFile());
				BufferedReader bis=new BufferedReader(fis);
				while((str1=bis.readLine())!=null)
				{
					System.out.print("\nhi");
					s1=t.getText();
					s3=s1+str1+"\n";
					t.setText(s3);
				}
				//System.out.print("BYE");
				bis.close();
			}
			catch(FileNotFoundException e1)
			{
				
			}
			catch(EOFException ec)
			{
				
			}
			catch(IOException eb)
			{
			}
			catch(NullPointerException ea)
			{
			}*/try
			{
				String str1;
				FileDialog fd=new FileDialog(f,"Open",FileDialog.LOAD);
				fd.setVisible(true);
				FileReader fr=new FileReader(fd.getFile());
				BufferedReader br=new BufferedReader(fr);
				while((str1=br.readLine())!=null)
				{
					s1=t.getText();
					s3=s1+str1+"\n";
					t.setText(s3);
				}
				br.close();
			}
			catch(FileNotFoundException e1)
			{
				System.out.print("No such file in the directory");
			}
			catch(EOFException e2)
			{
				System.out.print("File ended");
			}
			catch(IOException e3)
			{
			}
			catch(NullPointerException e4)
			{
			}
			
		}
}





    public static void main(String args[])
   {   
	     Editor e=new Editor();
   }
}
