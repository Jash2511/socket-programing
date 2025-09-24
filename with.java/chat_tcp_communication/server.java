import java.io.* ;
import java.net.ServerSocket ;
import java.net.Socket ;


public class server {
    public static void main(String[] args){
        int port =  23456 ;

        try(ServerSocket server = new ServerSocket(port)){
            
            System.out.println("Server is running on port : "+ port + " ready to listen to client" ) ;

            Socket client = server.accept() ;
            System.out.println("Server is connected with client at :" + client.getInetAddress().getHostAddress()) ;
           
            
            
            PrintWriter out = new PrintWriter(client.getOutputStream(),true) ;
            BufferedReader message = new BufferedReader(new InputStreamReader(client.getInputStream())) ;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;

            String telegram  ;
            while((telegram = message.readLine()) != null) {
                System.out.println(client.getInetAddress().getHostAddress() + " : " + telegram) ;
                System.out.print("Enter message to send to server: ");
                String telemail = input.readLine() ;
                out.println(telemail) ;
                
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage()) ;
        }
    }
}
