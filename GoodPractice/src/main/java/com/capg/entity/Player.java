package com.capg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int playerId;
    private String playerName ;
    private String playerCountry;

//    public Player(int playerId,String playerName,String playerCountry){
//        this.playerId = playerId;
//        this.playerName = playerName
//    }
}
