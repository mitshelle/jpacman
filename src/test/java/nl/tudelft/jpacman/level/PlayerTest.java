package nl.tudelft.jpacman.level;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.sprite.PacManSprites;
import static org.assertj.core.api.Assertions.assertThat;
public class PlayerTest {
    // get the sprites class needed for the player factory
    private static final PacManSprites sprite = new PacManSprites();
    // then get the Player factory and pass the sprite class to it
    // needed to get the player
    private final PlayerFactory playFactory = new PlayerFactory(sprite);
    private final Player player = playFactory.createPacMan();

    /**
     * Test is alive or not?
     */
    @Test
    void testIsAlive() {
        assertThat(player.isAlive()).isEqualTo(true);
    }

    /**
     * Test to see if getKiller has a killer
     */
    @Test
    void testGetKiller() {
        assertThat(player.getKiller()).isNull();
    }
}
