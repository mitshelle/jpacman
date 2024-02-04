package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class LevelTest {

    private static final PacManSprites sprites = new PacManSprites();
    private static final GhostFactory ghost = new GhostFactory(sprites);

    private static final PointCalculator point = mock(PointCalculator.class);
    public LevelFactory levelFactory = new LevelFactory(sprites, ghost, point);
    static List<Ghost> ghosts =  new ArrayList<>();
    static List<Square> startPositions = new ArrayList<>();

    @Test
    void testisInProgress() {
        Board board = mock(Board.class);
        ghosts.add(ghost.createClyde());
        ghosts.add(ghost.createBlinky());
        ghosts.add(ghost.createInky());
        ghosts.add(ghost.createPinky());
        startPositions.add(board.squareAt(0,0));
        Level level = levelFactory.createLevel(board, ghosts, startPositions);
        assertThat(level.isInProgress()).isEqualTo(false);
    }

    @Test
    void getBoard() {
        Board board = mock(Board.class);
        ghosts.add(ghost.createClyde());
        ghosts.add(ghost.createBlinky());
        ghosts.add(ghost.createInky());
        ghosts.add(ghost.createPinky());
        startPositions.add(board.squareAt(0,0));
        Level level = levelFactory.createLevel(board, ghosts, startPositions);
        assertThat(level.getBoard()).isNotNull();
    }

}
