public interface UserDAO {
    User getUser(String username, String password);
    int insertUser(User u);
    boolean getUserName(String username);
}
