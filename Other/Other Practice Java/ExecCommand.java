import java.io.IOException;  
   
public class ExecCommand {  
    public ExecCommand() {  
        try {  
            String command = "ping 127.0.0.1";  
            Process process = Runtime.getRuntime().exec(command);  
            System.out.println("Executing command: " + command);  
        } catch (IOException e) {  
            System.err.println(e);  
        }  
    }  
   
    public static void main(String[] args) {  
        new ExecCommand();  
    }  
}  