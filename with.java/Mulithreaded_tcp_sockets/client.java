import java.io.* ;
import java.net.Socket ;
import java.net.UnknownHostException;

class client {
    public static void main(String[] args){
        int port = 12345 ;
        String ip = "127.0.0.1" ;
        try(
                Socket client = new Socket(ip,port) ;
                PrintWriter out = new PrintWriter(client.getOutputStream(),true) ;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;
                BufferedReader Echo = new BufferedReader(new InputStreamReader(client.getInputStream())) ;
        ){
            System.out.println("client is connected with server at port : "+ port) ;
            System.out.println("Enter message to send server :  ") ;
            String message ;
            while((message = input.readLine())!= null){
                out.println(message) ;
                System.out.println("Echo : " + Echo.readLine());
                System.out.println("Enter message to send server :  ") ;
            }

        }catch(UnknownHostException uhx){
            System.out.println(uhx.getMessage()) ;
        }catch(IOException ex ){
            System.out.println(ex.getMessage()) ;
        }
    }
}