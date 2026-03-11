package batchprocessing.dao;

import batchprocessing.entity.Player;
import batchprocessing.repository.PlayerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDAO {
    @Override
    public void insertBatch(List<Player> players) throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String insertQuery = "INSERT INTO players VALUES(?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(insertQuery);

        for(Player p : players){
            stmt.setInt(1,p.getPlayerId());
            stmt.setString(2,p.getPlayerName());
            stmt.setString(3,p.getPlayerCountry());
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("Inserted rows: "+ result.length);
        connection.close();
    }

    @Override
    public void updateBatch(List<Player> players) throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String updateQuery = "UPDATE players SET playerName=?,playerCountry=? WHERE playerId = ? ";
        PreparedStatement stmt = connection.prepareStatement(updateQuery);

        for (Player p : players) {
            stmt.setString(1, p.getPlayerName());     // playerName
            stmt.setString(2, p.getPlayerCountry());  // playerCountry
            stmt.setInt(3, p.getPlayerId());          // WHERE playerId
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("Updated rows: " + result.length);
        connection.close();
    }

    @Override
    public void deleteBatch(List<Integer> playerIds) throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String deleteQuery = "DELETE FROM players WHERE playerId = ? ";
        PreparedStatement stmt = connection.prepareStatement(deleteQuery);
        for (int id : playerIds) {
            stmt.setInt(1, id);
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("Deleted rows: " + result.length);
    }

    @Override
    public List<Player> fetchAll() throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String selectQuery = "SELECT playerId,playerName,playerCountry FROM players";
        PreparedStatement stmt = connection.prepareStatement(selectQuery);
        ResultSet rs = stmt.executeQuery();
        List<Player> players = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("playerId");
            String name = rs.getString("playerName");
            String country = rs.getString("playerCountry");
            Player player = new Player(id,name,country);
            players.add(player);
        }
        return players;
    }
}
