package batchprocessing.dao;
import batchprocessing.entity.Player;
import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    void insertBatch(List<Player> players) throws SQLException;
    void updateBatch(List<Player> players) throws SQLException;

    void deleteBatch(List<Integer> playerIds) throws SQLException;

    List<Player> fetchAll() throws SQLException;
}
