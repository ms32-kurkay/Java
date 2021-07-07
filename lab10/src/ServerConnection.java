import java.io.*;
import java.net.*;
import java.util.*;

public class ServerConnection extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String nickName;

    public ServerConnection(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = in.readLine();
            String[] strings = word.split(", ");
            this.nickName = strings[1];
            System.out.println(nickName + "joined to chat");
            for (ServerConnection sc : Server.serverList) {
                sc.out.write("hello, " + nickName + "\n");
                sc.out.flush();
            }
            while (true) {
                word = in.readLine();
                System.out.println(">>" + word);
                for (ServerConnection sc : Server.serverList) {
                    sc.out.write(word + "\n");
                    sc.out.flush();
                }
            }
        } catch (IOException e) {
            this.downService();
        }
    }

    private void downService() {
        try {
            if(!socket.isClosed()) {
                System.out.println(nickName + " exited from chat");
                Iterator<ServerConnection> i = Server.serverList.iterator();
                while(i.hasNext()){
                    ServerConnection s = i.next();
                    if(s.equals(this)){
                        s.interrupt();
                        i.remove();
                    }
                }
                for (ServerConnection sc : Server.serverList) {
                    sc.out.write("good bye," + nickName + "\n");
                    sc.out.flush();
                }
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







