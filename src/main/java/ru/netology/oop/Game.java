package ru.netology.oop;

import java.util.HashMap;

public class Game {

    private HashMap<String, Player> players= new HashMap<>();

    public void register (String name, Player player) {
        players.put(name, player);
    }

    public Player searchPlayer(String key) {
        return players.get(key);
    }

    public int round(String name1, String name2) {
        Player player1 = searchPlayer(name1);
        Player player2 = searchPlayer(name2);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + name1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + name2 + " не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

}
