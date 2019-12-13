import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeterDAOImplemetation implements MeterDAO {
    private static Connection connection;
    public List<Meter> selectMeters(String username, String type){
        List<Meter> meters = new ArrayList<>();
        try {
            String query = "SELECT meters.id, meter_type, meter_value, date_format(date_value, '%d.%m.%Y') " +
                    "FROM users_meters JOIN users ON users_meters.user_id = users.id " +
                    "JOIN meters ON users_meters.meter_id = meters.id " +
                    "WHERE user_login='"+username+"' AND meter_type = '"+type+"'";
            connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Meter meter = MeterFactory.createMeter("electricity");
                meter.setId(resultSet.getInt(1));
                meter.setValue(resultSet.getDouble(3));
                meter.setDate(resultSet.getString(4));
                meters.add(meter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meters;
    }

    public int deleteMeter(int id){
        try {
            String query = "DELETE FROM meters WHERE id = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertMeter(Meter meter, String username){
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement;
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO meters(meter_type, meter_value, date_value) VALUES (?,?,?);");
            preparedStatement.setString(1, meter.getType());
            preparedStatement.setDouble(2, meter.getValue());
            preparedStatement.setString(3, meter.getDate());
            preparedStatement.executeUpdate();
            statement.execute("SELECT id FROM users WHERE user_login='"+username+"';");
            ResultSet resultSet = statement.getResultSet();
            int id = 0;
            while (resultSet.next()){
                id = resultSet.getInt(1);
            }
            
            connection.createStatement().executeUpdate("INSERT INTO users_meters(user_id, meter_id) VALUES("+id+",(SELECT id FROM meters WHERE id = last_insert_id())); ");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateMeter(Meter meter, String username){
        try {
            String query = "UPDATE meters SET meter_type = ?, meter_value = ?, date_value = current_date() WHERE id = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, meter.getType());
            preparedStatement.setDouble(2, meter.getValue());
            preparedStatement.setString(3, username);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Meter selectMeter(int id){
        Meter meter = null;
//        try {
//            String query = "SELECT * FROM meters WHERE id = ?";
//            connection = ConnectionManager.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                meter = new Meter();
//                meter.setId(resultSet.getInt(1));
//                meter.setType(resultSet.getString(2));
//                meter.setValue(resultSet.getDouble(3));
//                meter.setDate(resultSet.getString(4));
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
        return meter;
    }

    @Override
    public List<String> selectTypes() {
        List<String> types = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT meter_type FROM meters";
            connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                types.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
}
