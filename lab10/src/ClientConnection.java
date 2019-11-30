import java.io.*;
import java.net.Socket;
import java.util.UUID;

class ClientConnection {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String address;
    private int port;
    private final String nickname = UUID.randomUUID().toString();

    public ClientConnection(String address, int port) {
        this.address = address;
        this.port = port;
        try {
            this.socket = new Socket(address, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Your nick is " + nickname);
            out.write("hello, " + nickname + "\n");
            out.flush();
            new Read().start();
            new Write().start();
        } catch (IOException e) {
            this.downService();
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Read extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientConnection.this.downService();
            }
        }
    }

    public class Write extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();
                    out.write(nickname + ":" + userWord + "\n");
                    out.flush();
                } catch (IOException e) {
                    ClientConnection.this.downService();
                }
            }
        }
    }
}