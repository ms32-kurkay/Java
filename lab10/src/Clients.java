class Client1 {
    public static String ip = "localhost";
    public static int port = 8080;
    public static void main(String[] args) {
        new ClientConnection(ip, port);
    }
}
class Client2 {
    public static String ip = "localhost";
    public static int port = 8080;
    public static void main(String[] args) {
        new ClientConnection(ip, port);
    }
}
