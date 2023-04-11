import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            ArrayList<String> wordsForSorting = new ArrayList<>();
            String word;
            while (true) {
                word = reader.readLine();
                if (word.equals("0")) {
                    break;
                } else {
                    wordsForSorting.add(word);
                }
            }

            Words words = new Words(wordsForSorting);

            writer.write(words.getResult().toString());
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}

