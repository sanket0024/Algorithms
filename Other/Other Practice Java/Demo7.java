

import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo {
public static void main ( String [] args ){
String fileWriterString= "C:\\FIleWRITER.TXT";
FileWriter fileWriter =null;
try{
fileWriter= new FileWriter( fileWriterString, true ); // true for appending text
String abc = "HELLO WORLD";
fileWriter.write(abc);
}catch (IOException eIOException) {
System.out.println( "IOEXCEPTION IN READING THE FILE" + eIOException);
}finally{
try{
if( fileWriter!=null ){
fileWriter.close();
}

}catch (IOException eIOException) {
System.out.println( "IOEXCEPTION IN READING THE FILE" + eIOException);
}
}
}
}