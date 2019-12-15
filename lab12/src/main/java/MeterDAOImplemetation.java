import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeterDAOImplemetation implements MeterDAO {
    private static Connection connection;

    public List<Meter> selectMeters(String username){
        List<Meter> meters = new ArrayList<>();
        try {
            String query = "SELECT meters.id, meter_type, meter_value, date_format(date_value, '%d.%m.%Y') " +
                    "FROM users_meters JOIN users ON users_meters.user_id = users.id " +
                    "JOIN meters ON users_meters.meter_id = meters.id " +
                    "WHERE user_login='"+username+"'";
            connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String type = resultSet.getString(2);
                Meter meter = MeterFactory.createMeter(type);
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

    public Meter selectMeter(int id){
        Meter meter = null;
        try {
            String query = "SELECT * FROM meters WHERE id = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String type = resultSet.getString(2);
                meter = MeterFactory.createMeter(type);
                meter.setId(resultSet.getInt(1));
                meter.setValue(resultSet.getDouble(3));
                meter.setDate(resultSet.getString(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return meter;
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
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO meters(meter_type, meter_value, date_value) VALUES (?,?,?);");
            preparedStatement.setString(1, meter.getType());
            preparedStatement.setDouble(2, meter.getValue());
            preparedStatement.setString(3, meter.getDate());
            preparedStatement.executeUpdate();
            Statement selectUserId = connection.createStatement();
            selectUserId.execute("SELECT id FROM users WHERE user_login='"+username+"'");
            ResultSet userIdSet = selectUserId.getResultSet();
            int userId = 0;
            while(userIdSet.next()){
                userId = userIdSet.getInt(1);
            }
            Statement selectMeterId = connection.createStatement();
            selectMeterId.execute("SELECT id FROM meters WHERE id = last_insert_id();");
            ResultSet meterIdSet = selectMeterId.getResultSet();
            int meterId = 0;
            while (meterIdSet.next()){
                meterId = meterIdSet.getInt(1);
            }
            connection.createStatement().executeUpdate("INSERT INTO users_meters SET user_id = "+userId+", meter_id = "+meterId+"; ");
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateMeter(Meter meter){
        try {
            String query = "UPDATE meters SET meter_type = ?, meter_value = ?, date_value = ? WHERE id = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, meter.getType());
            preparedStatement.setDouble(2, meter.getValue());
            preparedStatement.setString(3, meter.getDate());
            preparedStatement.setInt(4, meter.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
