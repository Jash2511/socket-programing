import java.io.*; 
import java.net.ServerSocket ;
import java.net.Socket ;

public class server {
    public static void main(String[] args){
        int port = 12345 ;

        try (ServerSocket serversocket = new ServerSocket(port)){
            
            System.out.println("server is binded on port :" + port + " and ready to listen ") ;

            Socket clientSocket = serversocket.accept() ;

            String clinet = clientSocket.getInetAddress().getHostAddress() + " : ";

            System.out.println("connected client on : " + clientSocket.getInetAddress()) ;

            BufferedReader io = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())) ;

            System.out.println(clinet + io.readLine()) ;
            System.out.println(clinet + io.readLine()) ;

        } catch (IOException ex) {
            System.out.println(ex.getMessage()) ;
        }
    }
    
        
}
