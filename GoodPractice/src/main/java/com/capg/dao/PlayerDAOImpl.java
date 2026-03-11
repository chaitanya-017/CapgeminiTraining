package com.capg.dao;

import com.capg.entity.Player;
import com.capg.repository.Player_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO{
    public void insertPlayer(Player player){
        String sql = "INSERT INTO players VALUES (?,?,?)";
        try(Connection conn = Player_repository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,player.getPlayerId());
            pstmt.setString(2,player.getPlayerName());
            pstmt.setString(3,player.getPlayerCountry());
            pstmt.executeUpdate();
            System.out.println("Player Inserted");

        }catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void updatePlayer(Player player) {
        String sql = "UPDATE players SET playerName=?,playerCountry=? WHERE playerId=?";
        try(Connection conn = Player_repository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,player.getPlayerName());
            pstmt.setString(2,player.getPlayerCountry());
            pstmt.setInt(3,player.getPlayerId());
            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.println("player updated successfully");
            }
            else{
                System.out.println("updation failed");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM players WHERE playerId =?";
        try(Connection conn = Player_repository.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql)) {
                pstmt.setInt(1,playerId);
                int rows = pstmt.executeUpdate();
                if(rows>0){
                    System.out.println("Player Deleted Successfully");
                }
                else{
                    System.out.println("Deletion Failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
        }


    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> list = new ArrayList<>();
        String queue = "SELECT * FROM players";
        try(Connection conn = Player_repository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(queue)){
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("playerId");
                String name = rs.getString("playerName");
                String country = rs.getString("playerCountry");
                Player player = new Player(id,name,country);
                list.add(player);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
