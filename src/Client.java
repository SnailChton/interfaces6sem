import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Scanner in = new Scanner(System.in);
        String wordToServer;
        while (true) {
            wordToServer = in.next();
            if (!wordToServer.equals("0")) {
                writer.write(wordToServer + "\n");
                writer.flush();
            } else {
                writer.write(wordToServer + "\n");
                writer.flush();
                break;
            }
        }

        System.out.println(reader.readLine());

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
