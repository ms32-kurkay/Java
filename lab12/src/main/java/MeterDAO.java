import java.util.List;

public interface MeterDAO {
    List<Meter> selectMeters(String username, String type);
    int deleteMeter(int id);
    int insertMeter(Meter meter, String username);
    int updateMeter(Meter meter, String username);
    Meter selectMeter(int id);
    List<String> selectTypes();
}
