import java.io.*;
import java.net.Socket;



class Clienthandler implements Runnable {
    private final Socket clientSocket;

    public Clienthandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(),true) ;
                BufferedReader read = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())) ;
        ){
            String message ;
            while((message = read.readLine()) != null){
                System.out.println("Receve from : " + this.clientSocket.getInetAddress().getHostAddress() + " : " + message) ;
                out.println("Echo : " + message) ;
            }
        }catch(IOException ex){
            System.out.println("Error handling client: " + ex.getMessage());
        }finally{
            System.out.println("Client disconnected: " + this.clientSocket.getInetAddress().getHostAddress());
            try{
                clientSocket.close() ;
            }catch(IOException es){
                // do nothing here
            }

        }
    }
}