import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
*  Email Program.
*  Recieves information to send to SMTP server and server sends email
*  Waits for a Welcome message from the server.
*  Sends the first sentence to the server.
*  Recieves server responses
*  Closes the socket and exits.
*  author: Ori Garibi and Ofek Shoichet
*  Email:  garibi@chapman.edu and shoichet@chapman.edu
*  Date:  2/15/2021
*  version: 3.1
*/
public class Email {
    public static void main(String[] argv) throws Exception {
        // Get user input
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Sender email: ");
        final String sender_email_address = inFromUser.readLine();
    
        System.out.print("Reciever email: ");
        final String receiver_email_address = inFromUser.readLine();

        System.out.print("Sender name: ");
        final String sender_name = inFromUser.readLine();
    
        System.out.print("Reciever name: ");
        final String receiver_name = inFromUser.readLine();

        System.out.print("Subject: ");
        final String subject = inFromUser.readLine();
    
        System.out.print("Message: ");
        String message = "";
        boolean period = false;
        String userInput = "";
        while(!userInput.equals(".")){
          userInput = inFromUser.readLine();
          message+=userInput + "\n";
        }
        System.out.println("now i am connecting");
        // Finished getting user input
    
        // Connect to the server
        Socket clientSocket = null;
    
        try {
          clientSocket = new Socket("smtp.chapman.edu", 25);
        } catch (Exception e) {
          System.out.println("Failed to open socket connection");
          System.exit(0);
        }
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inFromServer =  new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
    
        // Exchange messages with the server
        // Recive and display the Welcome Message
        //String welcomeMessage = inFromServer.readLine();
        //System.out.println("FROM SERVER:" + welcomeMessage);

        String modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        String helo = "HELO icd.chapman.edu";
        System.out.println(helo);
        outToServer.println(helo);
        
        
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        System.out.println("MAIL FROM: "+sender_email_address);
        outToServer.println("MAIL FROM: "+sender_email_address);
        
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        System.out.println("RCPT TO: "+receiver_email_address);
        outToServer.println("RCPT TO: "+receiver_email_address);

        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        System.out.println("DATA");
        outToServer.println("DATA");

        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        System.out.println("From: "+ sender_name);
        outToServer.println("From: "+ sender_name);

        System.out.println("To: "+ receiver_name);
        outToServer.println("To: "+ receiver_name);
        
        System.out.println("Subject: "+ subject);
        outToServer.println("Subject: "+ subject);

        System.out.println(message);
        outToServer.println(message);

        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        System.out.println("QUIT");
        outToServer.println("QUIT");

    
        // Close the socket connection
        clientSocket.close();
      }
}
