package com.capg;

import com.capg.dao.PlayerDAO;
import com.capg.dao.PlayerDAOImpl;
import com.capg.entity.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerDAO dao  = new PlayerDAOImpl();
        //   dao.insertPlayer(new Player(7,"Dhoni","INDIA"));
        //  dao.updatePlayer(new Player(7,"Ronaldo","Portugal"));
        //  dao.insertPlayer(new Player(10,"Sachin","INDIA"));
        //  dao.deletePlayer(10);
        List<Player> players = dao.getAllPlayers();
        for(Player p:players){
            System.out.println(p);
        }
    }
}
