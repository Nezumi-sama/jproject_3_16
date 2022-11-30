import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();

    public ArrayList<Player> findAll(){
        return playerList;
    }

    public void register(Player player) {
        boolean flag = false;
        for (Player namePlayer : playerList) {
            if (player.getId() == namePlayer.getId()) {
                flag = true;
            }
        }

        if (!flag) {
            playerList.add(player);
        }
    }


    public Player findByName(String name) {
        for (Player item : playerList) {
            if (item.getName() == name) {
                return item;
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
