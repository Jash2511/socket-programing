import java.io.* ;
import java.net.Socket ;
import java.net.UnknownHostException; 

public class client {
    public static void main(String[] args){
        String ip = "localhost" ;
        int port = 23456 ;

        try(Socket socket  = new Socket(ip ,port)){
            
            System.out.println("Client is connected with server at : "+ ip + port + ".") ;

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true) ;
            BufferedReader message = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;
            String userInput ;
            System.out.print("Enter message to send to server: ");

            while((userInput = input.readLine() ) != null){
                out.println(userInput) ;
                String telegram = message.readLine() ;
                System.out.println(telegram) ;
                System.out.print("Enter message to send to server: ");
            }

        }catch(UnknownHostException uxh){
            System.out.println(uxh.getMessage()) ;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
