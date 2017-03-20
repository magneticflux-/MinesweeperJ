package org.skaggsm.minesweeperj.board;

import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.internal.util.ConsoleMockitoLogger;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Player;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * This class test the {@link Game} interface's default method {@link Game#addPlayer(Player)}.
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
    public final MockitoRule mockitoRule = new JUnitRule(new ConsoleMockitoLogger(), Strictness.STRICT_STUBS);

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Game<Move, View> game;

    @Theory
    public void Given_AnyPlayer_When_AddPlayerCalled_Then_AddParticipantCalledAddViewerCalled(Player<Move, View> anyPlayer) throws Exception {
        game.addPlayer(anyPlayer);

        verify(game, times(1)).addParticipant(anyPlayer);
        verify(game, times(1)).addViewer(anyPlayer);
    }
}