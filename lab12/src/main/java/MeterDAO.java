import java.util.List;

public interface MeterDAO {
    List<Meter> selectMeters(String username);
    int deleteMeter(int id);
    int insertMeter(Meter meter, String username);
    int updateMeter(Meter meter);
    Meter selectMeter(int id);
}
