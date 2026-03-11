package batchprocessing;

import batchprocessing.dao.PlayerDAO;
import batchprocessing.dao.PlayerDaoImpl;
import batchprocessing.entity.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Create list of players
        List<Player> players = new ArrayList<>();

//        players.add(new Player(1, "Virat Kohli", "India"));
//        players.add(new Player(2, "Joe Root", "England"));
//        players.add(new Player(3, "Kane Williamson", "New Zealand"));

        // Create DAO object
        PlayerDAO dao = new PlayerDaoImpl();

        // Call batch insert
//        dao.insertBatch(players);
//
//        System.out.println("Batch execution completed.");

        // ------- UPDATE--------
//        List<Player> updated_players = new ArrayList<>();
//        updated_players.add(new Player(1,"Rahul Dravid","India"));
//        updated_players.add(new Player(2,"James Anderson","England"));
//        dao.updateBatch(updated_players);
//        System.out.println("Update completed.");

        //-----DELETE------
//          List<Integer> idsToDelete = new ArrayList<>();
//          idsToDelete.add(3);
//          idsToDelete.add(7);
//          dao.deleteBatch(idsToDelete);
//          System.out.println("deletion successful");

        //------VIEW ALL-----
        List<Player> allPlayers = dao.fetchAll();
        for(Player p:allPlayers){
            System.out.println(p.getPlayerId()+" "+p.getPlayerName()+" "+p.getPlayerCountry());
        }
    }
}