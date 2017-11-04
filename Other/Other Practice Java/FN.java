import java.util.*;
import java.lang.*;
import java.io.*;
class Fre
{
public static void main(String[ ] args) throws IOException
{
DataInputStream dis=new DataInputStream(System.in);
String str=dis.readLine();
String temp;
StringTokenizer st=new StringTokenizer(str);
int n=st.countTokens( );
String a[ ]=new String[n];
int i=0,count=0;
while(st.hasMoreTokens())
{
a[i]=st.nextToken();
i++;
}
for(int x=1;x;)
{for(int y=0;y;)
{if(a[y].compareTo(a[y+1])>0)
{
temp=a[y];
a[y]=a[y+1];
a[y+1]=temp;
}}}
System.out.println("the sorted string are:");
for(i=0;i;){
System.out.println(a[i]+" ");
}
System.out.println();
for(i=0;i;){count=1;
if(i){
while(a[i].compareTo(a[i+1])==0)
{
count++;
i++;
if(i>=n-1)
{
System.out.println(a[i]+" "+count);
System.exit(0);
}
}
}
System.out.println(a[i]+" "+count);
}
}
} 
