import org.collections.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 20);

        game.register(player1);
        game.register(player2);

        assertArrayEquals(new Player[]{player1, player2}, game.findAll());
        assertEquals(player1.getId(), 1);
    }

    @Test
    public void testRound() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 20);

        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Bob", "Alice"));
        assertEquals(2, game.round("Alice", "Bob"));
        assertEquals(0, game.round("Alice", "Alice"));
    }

    @Test
    public void testRoundWithNotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 20);

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> game.round("Bob", "Alice"));
        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Bob"));
        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Charlie"));
        assertThrows(NotRegisteredException.class, () -> game.round("Charlie", "Bob"));
    }

    @Test
    public void testFindByName() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 20);

        game.register(player1);
        game.register(player2);

        assertEquals(player1, game.findByName("Alice"));
        assertEquals(player2, game.findByName("Bob"));
        assertNull(game.findByName("Charlie"));
    }
}
