package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class LevelTest {

    private static final PacManSprites sprites = new PacManSprites();
    private static final GhostFactory ghostFactory = new GhostFactory(sprites);
    private static final Ghost ghost = mock(Ghost.class);

    private static final PointCalculator point = mock(PointCalculator.class);
    public LevelFactory levelFactory = new LevelFactory(sprites, ghostFactory, point);
    static List<Ghost> ghostList =  new ArrayList<>();
    static List<Square> startPositionsList = new ArrayList<>();
    private static final Board board = mock(Board.class);
    private static final Square startPos1 = mock(Square.class);
    private static final CollisionMap cmap = mock(CollisionMap.class);

    @Test
    void testisInProgress() {
        // get the level
        // pass in the board, ghost list, starting positions, collision map
        Level level = new Level(board, Lists.newArrayList(ghost), Lists.newArrayList(startPos1), cmap);
        // start the level
        level.start();
        assertThat(level.isInProgress()).isEqualTo(true);
    }

    @Test
    void getBoard() {
        // create ghosts for the game
        ghostList.add(ghostFactory.createClyde());
        ghostList.add(ghostFactory.createBlinky());
        ghostList.add(ghostFactory.createInky());
        ghostList.add(ghostFactory.createPinky());
        // starting position
        startPositionsList.add(board.squareAt(0, 0));
        // get the level
        Level level = levelFactory.createLevel(board, ghostList, startPositionsList);
        assertThat(level.getBoard()).isNotNull();
    }

}
