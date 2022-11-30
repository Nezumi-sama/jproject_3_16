import java.util.HashMap;

public class Game {
    private HashMap<String, Player> playerMap = new HashMap<>();

    public HashMap<String, Player> findAll() {
        return playerMap;
    }

    public void register(Player player) {
        boolean flag = false;
        for (String namePlayer : playerMap.keySet()) {
            if (player.getName() == namePlayer) {
                flag = true;
            }
        }

        if (!flag) {
            playerMap.put(player.getName(), player);
        }
    }

    public Player findByName(String name) {
        for (String namePlayer : playerMap.keySet()) {
            if (namePlayer == name) {
                return playerMap.get(namePlayer);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if ((findByName(playerName1) == null) || (findByName(playerName2) == null)) {
            throw new NotRegisteredException(
                    "Один или оба играка не зарегистрированы"
            );
        }
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
