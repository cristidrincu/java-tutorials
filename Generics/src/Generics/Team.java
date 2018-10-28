/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristiandrincu
 * @param <T>
 */
public class Team<T extends Player> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    
    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean addPlayer(T player) {
        boolean added;
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            added = false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            added = true;
        }
        
        return added;
    }
    
    public int numPlayers() {
        return this.members.size();
    }
    
    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        played++;
        
        if(opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }
    
    public int ranking() {
        return (won * 2) + tied;
    }
}
