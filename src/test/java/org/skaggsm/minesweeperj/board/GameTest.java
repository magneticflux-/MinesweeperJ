package org.skaggsm.minesweeperj.board;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Player;

import static org.mockito.Mockito.*;

/**
 * This class tests the {@link AbstractGame} class.
 *
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category(UnitTests.class)
public class GameTest {
    @Mock
    @DataPoint
    public static Player<Move, View> SIMPLE_PLAYER;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private AbstractGame<Move, View> abstractGame;

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setup() {
        SIMPLE_PLAYER = mock(Player.class); //Needed because of @DataPoint usage and static field
    }

    @Theory
    public void Given_AnyPlayer_When_AddPlayerCalled_Then_AddParticipantCalledAddViewerCalled(Player<Move, View> anyPlayer) throws Exception {
        abstractGame.addPlayer(anyPlayer);

        verify(abstractGame, times(1)).addParticipant(anyPlayer);
        verify(abstractGame, times(1)).addViewer(anyPlayer);
    }
}