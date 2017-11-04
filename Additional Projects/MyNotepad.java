import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
class MyNotepad implements ActionListener
{
	char arr[],arr1[];
	Frame f,f1,f2,f3;
	TextField t1,t2;
	TextArea ta;
	int count=0,x=0,l=0,m=0,y,p=0,q=0,startIndex;
	String str,s1,s2,s3,str2,str3,str4,str6,str9,str11,str12,path,filename;
	MenuBar mb;
	Menu m1,m2;
	MenuItem nw,opn,sav,savs,ext,fnd,fndr;
	public MyNotepad()
	{
		f=new Frame();
		f.setSize(900,600);
		f.setTitle("untitled");
		ta=new TextArea();
		f.add(ta);
		mb=new MenuBar();
		m1=new Menu("File");
		m2=new Menu("Tools");
		nw=new MenuItem("New");
		opn=new MenuItem("Open");
		sav=new MenuItem("Save");
		savs=new MenuItem("Save as");
		ext=new MenuItem("Exit");
		fnd=new MenuItem("Find");
		fndr=new MenuItem("Find and replace");
		nw.addActionListener(this);
		opn.addActionListener(this);
		sav.addActionListener(this);
		savs.addActionListener(this);
		ext.addActionListener(this);
		fnd.addActionListener(this);
		fndr.addActionListener(this);
		m2.add(fnd);
		m2.add(fndr);
		m1.add(nw);
		m1.add(opn);
		m1.add(sav);
		m1.add(savs);
		m1.addSeparator();
		m1.add(ext);
		mb.add(m1);
		mb.add(m2);
		f.setMenuBar(mb);
		//WindowCloser wc=new WindowCloser();
		//f.addWindowListener(wc);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		str=e.getActionCommand();
		if(str=="New")
		{
			String s1;
			s1=f.getTitle();
			str3=ta.getText();
			arr1=str3.toCharArray();
			m=arr1.length;
			try
			{
				if(l!=m)
				{
					f1=new Frame();
					f1.setTitle("Note this pad");
					f1.setSize(500,180);
					Label l=new Label("Do you want to save changes ?");
					f1.add(l,"North");
					Button b1,b2,b3;
					b1=new Button("Save");
					b1.addActionListener(this);
					b2=new Button("Don't save");
					b2.addActionListener(this);
					b3=new Button("Close");
					b3.addActionListener(this);
					Panel p=new Panel();
					p.setLayout(new GridLayout(1,2));
					f1.add(p,"South");
					Panel p1=new Panel();
					p1.setLayout(new GridLayout(1,3));
					p.add(new Label());
					p.add(p1);
					p1.add(b1);
					p1.add(b2);
					p1.add(b3);
					f1.setVisible(true);
					x=2;
				}
				else
				{
					new1();
				}
			}
			catch(NullPointerException e9)
			{
			}
		}
		if(str=="Open")
		{
			String s1;
			s1=f.getTitle();
			str3=ta.getText();
			arr1=str3.toCharArray();
			m=arr1.length;
			try
			{
				if(l!=m)
				{
					f1=new Frame();
					f1.setTitle("MyNotepad");
					f1.setSize(500,180);
					Label l=new Label("Do you want to save changes ?");
					f1.add(l,"North");
					Button b1,b2,b3;
					b1=new Button("Save");
					b1.addActionListener(this);
					b2=new Button("Don't save");
					b2.addActionListener(this);
					b3=new Button("Close");
					b3.addActionListener(this);
					Panel p=new Panel();
					p.setLayout(new GridLayout(1,2));
					f1.add(p,"South");
					Panel p1=new Panel();
					p1.setLayout(new GridLayout(1,3));
					p.add(new Label());
					p.add(p1);
					p1.add(b1);
					p1.add(b2);
					p1.add(b3);
					f1.setVisible(true);
					x=3;
				}
				else
				{
					ta.setText("");
					String str1;
					FileDialog fd=new FileDialog(f,"Open",FileDialog.LOAD);
					fd.setVisible(true);
					path=fd.getDirectory();
					filename=fd.getFile();
					FileReader fr=new FileReader(path+filename);
					BufferedReader br=new BufferedReader(fr);
					while((str1=br.readLine())!=null)
					{
						s1=ta.getText();
						s3=s1+str1+"\n";
						ta.setText(s3);
					}
					br.close();
					f.setTitle(fd.getFile());
				}
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
		if(str=="Save")
		{
			File file=new File(f.getTitle());
			if(count==0)
			{
				try
				{
			 		FileDialog fd=new FileDialog(f,"Save as",FileDialog.SAVE);
			 		fd.setVisible(true);
			 		path=fd.getDirectory();
					filename=fd.getFile();
			 		FileWriter fw=new FileWriter(path+filename);
			 		BufferedWriter bw=new BufferedWriter(fw);
			 		bw.write(ta.getText());
			 		bw.close();
			 		f.setTitle(fd.getFile());
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
				count++;
			}
			else
			{
				try
				{
					
					FileWriter fw=new FileWriter(path+"/"+filename);
					BufferedWriter bw=new BufferedWriter(fw);
					bw.write(ta.getText());
					bw.close();
				}
				catch(IOException e3)
				{
				}
			}
			if(x==1)
			{
				f1.setVisible(false);
				f1.dispose();
			}
			if(x==2)
			{
				ta.setText("");
				count=0;
				x=0;
				f1.setVisible(false);
				f1.dispose();
			}
			if(x==3)
			{
				try
				{
					ta.setText("");
					//f.setTitle("untitled");
					count=0;
					x=0;
					f1.setVisible(false);
					f1.dispose();
					String str1;
					FileDialog fd=new FileDialog(f,"Open",FileDialog.LOAD);
					fd.setVisible(true);
					path=fd.getDirectory();
					filename=fd.getFile();
					FileReader fr=new FileReader(path+filename);
					BufferedReader br=new BufferedReader(fr);
					while((str1=br.readLine())!=null)
					{
						s1=ta.getText();
						s3=s1+str1+"\n";
						ta.setText(s3);
					}
					br.close();
					f.setTitle(fd.getFile());
				}
				catch(FileNotFoundException e1)
				{
					System.out.print("No such file in the directory");
				}
				catch(IOException e2)
				{
				}
			}
			str2=ta.getText();
			arr=str2.toCharArray();
			l=arr.length;
		}
		if(str=="Save as")
		{
			try
			{
		 		FileDialog fd=new FileDialog(f,"Save as",FileDialog.SAVE);
		 		fd.setVisible(true);
		 		path=fd.getDirectory();
				filename=fd.getFile();
			 	FileWriter fw=new FileWriter(path+filename);
		 		BufferedWriter bw=new BufferedWriter(fw);
		 		bw.write(ta.getText());
		 		bw.close();
		 		f.setTitle(fd.getFile());
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
			count++;
			str2=ta.getText();
			arr=str2.toCharArray();
			l=arr.length;
		}
		if(str=="Exit")
		{
			try
			{
				exit();
			}
			catch(NullPointerException e7)
			{
			}
		}
		if(str=="Don't save")
		{
			f1.setVisible(false);
			f1.dispose();
			if(x==2)
			{
				ta.setText("");
				count=0;
				x=0;
			}
			if(x==3)
			{
				try
				{
					ta.setText("");
					//f.setTitle("untitled");
					count=0;
					x=0;
					f1.setVisible(false);
					f1.dispose();
					String str1;
					FileDialog fd=new FileDialog(f,"Open",FileDialog.LOAD);
					fd.setVisible(true);
					path=fd.getDirectory();
					filename=fd.getFile();
					FileReader fr=new FileReader(path+filename);
					BufferedReader br=new BufferedReader(fr);
					while((str1=br.readLine())!=null)
					{
						s1=ta.getText();
						s3=s1+str1+"\n";
						ta.setText(s3);
					}
					br.close();
					f.setTitle(fd.getFile());
				}
				catch(FileNotFoundException e1)
				{
					System.out.print("No such file in the directory");
				}
				catch(IOException e2)
				{
				}
			}
			if(x==1)
			{	
				f.setVisible(false);
				f.dispose();
			}
		}
		if(str=="Cancel")
		{
			if(y==1)
			{
				f3.setVisible(false);
				f3.dispose();
			}
			else
			{
				f2.setVisible(false);
				f2.dispose();
			}
			p=0;
			q=0;
		}
		if(str=="Close")
		{
			f1.setVisible(false);
			f1.dispose();
		}
		if(str=="Find")
		{
			try
			{
				find();
			}
			catch(NullPointerException e8)
			{
			}
		}
		if(str=="Find Next")
		{
			str4=ta.getText();
			str11=t1.getText();
			q=str11.length();
			p=str4.indexOf(str11,startIndex);
			int count=0;
			for(int i=0;i<p;i++)
			{
				if(str4.charAt(i)=='\n')
				{
					count++;
				}
			}
			if(p!=-1)
			{
				ta.requestFocus();
				if(str4.indexOf('\r',0)==-1)
				{
					ta.select(p,p+q);
				}
				else
				{
					ta.select(p-count,p-count+q);
				}
				startIndex=p+q;
			}
			else
			{
				startIndex=0;
			}		
		}
		if(str=="Find and replace")
		{
			find_repl();
		}
		if(str=="Replace")
		{
			str6=ta.getText();
			Pattern p=Pattern.compile(t1.getText());
			Matcher m=p.matcher(ta.getText());
			str6=m.replaceFirst(t2.getText());
			ta.setText(str6);/*
			str6=ta.getText();
			Pattern p=Pattern.compile(ta.getSelectedText());
			Matcher m=p.matcher(str6);
			str6=m.replaceFirst(t2.getText());
			ta.setText(str6);*/
		}
		if(str=="Replace All")
		{
			str9=ta.getText();
			Pattern p=Pattern.compile(t1.getText());
			Matcher m=p.matcher(str9);
			str9=m.replaceAll(t2.getText());
			ta.setText(str9);
		}
	}
	public void new1()
	{
		ta.setText("");
		f.setTitle("untitled");
		count=0;
		x=0;
	}
	public void exit()
	{
		String s1;
		s1=f.getTitle();
		str3=ta.getText();
		arr1=str3.toCharArray();
		m=arr1.length;
		try
		{
			if(s1=="untitled" || l!=m)
			{
				f1=new Frame();
				f1.setTitle("Note this pad");
				f1.setSize(500,180);
				Label l=new Label("Do you want to save changes ?");
				f1.add(l,"North");
				Button b1,b2,b3;
				b1=new Button("Save");
				b1.addActionListener(this);
				b2=new Button("Don't save");
				b2.addActionListener(this);
				b3=new Button("Close");
				b3.addActionListener(this);
				Panel p=new Panel();
				p.setLayout(new GridLayout(1,2));
				f1.add(p,"South");
				Panel p1=new Panel();
				p1.setLayout(new GridLayout(1,3));
				p.add(new Label());
				p.add(p1);
				p1.add(b1);
				p1.add(b2);
				p1.add(b3);
				f1.setVisible(true);
				x=1;
			}
			else
			{
				f.setVisible(false);
				f.dispose();
			}
		}
		catch(NullPointerException e9)
		{
		}
	}
	void find()
	{
		f2=new Frame();
		f2.setSize(300,100);
		f2.setTitle("yes..??");
		Label l=new Label("Find what:");
		t1=new TextField(20);
		Panel p=new Panel();
		p.add(l);
		p.add(t1);
		f2.add(p,"North");
		Button b1=new Button("Find Next");
		b1.addActionListener(this);
		Button b2=new Button("Cancel");
		b2.addActionListener(this);
		Panel p1=new Panel();
		p1.setLayout(new GridLayout(1,2));
		f2.add(p1,"South");
		Panel p2=new Panel();
		p2.setLayout(new GridLayout(1,2));
		Label l1=new Label();
		p1.add(l1);
		p2.add(b1);
		p2.add(b2);
		p1.add(p2);
		f2.setVisible(true);
	}
	public void find_repl()
	{
		y=1;
		f3=new Frame();
		f3.setSize(500,150);
		f3.setTitle("Find & Replace");
		Panel p1=new Panel();
		p1.setLayout(new GridLayout(2,1));
		Panel p2=new Panel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,14,5));
		Panel p3=new Panel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		p1.add(p2);
		p1.add(p3);
		Label l1=new Label("Find What:");
		t1=new TextField(20);
		p2.add(l1);
		p2.add(t1);
		Label l2=new Label("Replace With:");
		t2=new TextField(20);
		p3.add(l2);
		p3.add(t2);
		f3.add(p1,"Center");
		Button b1=new Button("Replace");
		b1.addActionListener(this);
		Button b2=new Button("Replace All");
		b2.addActionListener(this);
		Button b3=new Button("Cancel");
		b3.addActionListener(this);
		Button b4=new Button("Find Next");
		b4.addActionListener(this);
		Panel p4=new Panel();
		p4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f3.add(p4,"South");
		p4.add(b4);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		f3.setVisible(true);
	}
	public static void main(String args[])
	{
		MyNotepad mn=new MyNotepad();
	} 
}
