package org.skaggsm.minesweeperj.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.skaggsm.minesweeperj.entities.Player;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Mitchell Skaggs
 */
@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class GameTest {
    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Game<Move, View> game;
    @Mock
    private Player<Move, View> player;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addPlayer() throws Exception {
        game.addPlayer(player);

        verify(game, times(1).description("Method \"addParticipant\" not called!")).addParticipant(player);
        verify(game, times(1).description("Method \"addViewer\" not called!")).addViewer(player);
    }
}