import java.io.IOException ;
import java.net.ServerSocket ;
import java.net.Socket ;

public class server {
    public static void main(String[] args){
        int port = 12345 ;

        try(ServerSocket serversocket = new ServerSocket(port)){
            System.out.println("Server is listining at port : " + port) ;

            while(true){
                Socket client = serversocket.accept() ;
                System.out.println("New client connected : " + client.getInetAddress().getHostAddress()) ;

                Clienthandler clientSocket = new Clienthandler(client) ;
                new Thread(clientSocket).start() ;
            }
        }catch(IOException ex){
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}