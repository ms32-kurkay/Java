import java.sql.*;

public class UserDAOImplementation implements UserDAO {
    private static Connection connection;
    private static PreparedStatement statement;
    @Override
    public User getUser(String username, String password) {
        User user = new User();
        try{
            String query = "SELECT * FROM users WHERE user_login = ? AND user_password = ?";
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int insertUser(User u) {
        int status = 0;
        try {
            String query = "INSERT INTO users(user_login,user_password) VALUES(?,?)";
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,u.getUsername());
            statement.setString(2,u.getPassword());
            status = statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean getUserName(String username) {
         boolean status = false;
        try{
            String query = "SELECT * FROM users WHERE user_login = ?";
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(1)!=null)
                    status = true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}

