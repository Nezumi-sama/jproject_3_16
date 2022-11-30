import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "player1", 185);
    Player player2 = new Player(2, "player2", 315);
    Player player3 = new Player(3, "player3", 118);
    Player player4 = new Player(4, "player4", 185);
    Player player5 = new Player(5, "player5", 428);

    @Test
    void shouldNoRegister() {
        HashMap<String, Player> playerMap = new HashMap<>();
        Game game = new Game();

        playerMap.put("player1", player1);
        playerMap.put("player2", player2);
        playerMap.put("player3", player3);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        HashMap<String, Player> expected = playerMap;
        HashMap<String, Player> actual = game.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldAlreadyRegister() {
        HashMap<String, Player> playerMap = new HashMap<>();
        Game game = new Game();

        playerMap.put("player1", player1);
        playerMap.put("player2", player2);

        game.register(player1);
        game.register(player2);
        game.register(player2);
        HashMap<String, Player> expected = playerMap;
        HashMap<String, Player> actual = game.findAll();

        assertEquals(expected, actual);

    }

    @Test
    void shouldFindByNameThereIs() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Player expected = game.findByName("player2");
        Player actual = player2;

        assertEquals(expected, actual);

    }

    @Test
    void shouldFindByNameThereIsNot() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Player expected = game.findByName("player4");
        Player actual = null;

        assertEquals(expected, actual);

    }

    @Test
    void shouldRoundVictoryFirst() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = game.round("player2", "player3");
        int actual = 1;

        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundVictorySecond() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = game.round("player1", "player2");
        int actual = 2;

        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player4);

        int expected = game.round("player1", "player4");
        int actual = 0;

        assertEquals(expected, actual);
    }


    @Test
    void shouldRoundFirstNoRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("player4", "player3");
        });

    }

    @Test
    void shouldRoundSecondNoRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("player1", "player4");
        });

    }

    @Test
    void shouldRoundFirstAndSecondNoRegister() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("player5", "player4");
        });

    }

}