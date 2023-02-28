package org.collections;

public class Game {
    private Player[] players;

    public Game() {
        players = new Player[0];
    }

    public void register(Player player) {
        int size = players.length;
        Player[] newPlayers = new Player[size + 1];
        System.arraycopy(players, 0, newPlayers, 0, size);
        newPlayers[size] = player;
        players = newPlayers;
    }

    public Player[] findAll() {
        return players;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(String.format("Player %s is not registered", playerName1));
        }
        if (player2 == null) {
            throw new NotRegisteredException(String.format("Player %s is not registered", playerName2));
        }

        return player1.compareTo(player2);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
