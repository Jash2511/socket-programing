
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException; 

public class client {
    public static void main(String[] args){
        String ip = "localhost" ;
        int port = 12345 ;

        try(Socket socket = new Socket(ip,port)){

            System.out.println("client is connected with server at port :" + port) ;

            // PrintWriter out = new PrintWriter(socket.getOutputStream(),true) ;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;

            // out.print(input.readLine()) ; 
            // out.print("word") ;
            socket.getOutputStream().write(input.readLine().getBytes()) ;
            socket.getOutputStream().write("world".getBytes()) ;
           

        }catch(UnknownHostException uhx){
            System.out.println(uhx.getMessage()) ;

        }catch(IOException ex){
            System.out.println(ex.getMessage()) ;
        }
    }
    
}
