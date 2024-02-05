package nl.tudelft.jpacman.level;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.sprite.PacManSprites;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    // get the sprites class needed for the player factory
    private static final PacManSprites sprite = new PacManSprites();
    // then get the Player factory and pass the sprite class to it
    // needed to get the player
    private final PlayerFactory playFactory = new PlayerFactory(sprite);
    private final Player player = playFactory.createPacMan();
    private static final PointCalculator point = mock(PointCalculator.class);
    private final PlayerCollisions collision = new PlayerCollisions(point);
    private static final GhostFactory ghostFactory = new GhostFactory(sprite);

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
        Ghost ghost = ghostFactory.createClyde();
        collision.playerVersusGhost(player, ghost);
        assertThat(player.getKiller()).isEqualTo(ghost);
    }
}
