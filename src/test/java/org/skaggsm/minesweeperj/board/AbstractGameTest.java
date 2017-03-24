package org.skaggsm.minesweeperj.board;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Participant;
import org.skaggsm.minesweeperj.entities.Player;
import org.skaggsm.minesweeperj.entities.Viewer;

import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * This class tests the {@link AbstractGame} class.
 *
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category(UnitTests.class)
public class AbstractGameTest {
    @DataPoint
    public static Viewer<View> SIMPLE_VIEWER;
    @DataPoint
    public static Participant<Move, View> SIMPLE_PARTICIPANT;
    @DataPoint
    public static Player<Move, View> SIMPLE_PLAYER;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    private AbstractGame<Move, View> abstractGame;
    private TurnController<Move, View> turnController;
    private View view;
    private Move move;
    private Participant<Move, View> participant;

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void staticSetup() {
        SIMPLE_VIEWER = mock(Viewer.class);
        SIMPLE_PARTICIPANT = mock(Participant.class);
        SIMPLE_PLAYER = mock(Player.class);
    }

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {
        participant = mock(Participant.class);
        view = mock(View.class);
        move = mock(Move.class);
        turnController = mock(TurnController.class);
        abstractGame = spy(new TestAbstractGame(turnController));
    }

    @Theory
    public void Given_AnyViewer_When_AddViewerCalled_Then_ViewerIsInList(Viewer<View> anyViewer) {
        abstractGame.addViewer(anyViewer);

        assertThat(anyViewer, isIn(abstractGame.getViewers()));
    }

    @Theory
    public void Given_AnyViewer_When_AddViewerCalledRemoveViewerCalled_Then_ViewerIsNotInList(Viewer<View> anyViewer) {
        abstractGame.addViewer(anyViewer);
        abstractGame.removeViewer(anyViewer);

        assertThat(anyViewer, not(isIn(abstractGame.getViewers())));
    }

    @Theory
    public void Given_AnyParticipant_When_AddParticipantCalled_Then_ParticipantIsInList(Participant<Move, View> anyParticipant) {
        abstractGame.addParticipant(anyParticipant);

        assertThat(anyParticipant, isIn(abstractGame.getParticipants()));
    }

    @Theory
    public void Given_AnyParticipant_When_AddParticipantCalledRemoveParticipantCalled_Then_ParticipantIsNotInList(Participant<Move, View> anyParticipant) {
        abstractGame.addParticipant(anyParticipant);
        abstractGame.removeParticipant(anyParticipant);

        assertThat(anyParticipant, not(isIn(abstractGame.getParticipants())));
    }

    @Theory
    public void Given_AnyPlayer_When_AddPlayerCalled_Then_PlayerIsInLists(Player<Move, View> anyPlayer) {
        abstractGame.addPlayer(anyPlayer);

        assertThat(anyPlayer, isIn(abstractGame.getViewers()));
        assertThat(anyPlayer, isIn(abstractGame.getParticipants()));
    }

    @Theory
    public void Given_AnyPlayer_When_AddPlayerCalledRemovePlayerCalled_Then_PlayerIsNotInLists(Player<Move, View> anyPlayer) {
        abstractGame.addPlayer(anyPlayer);
        abstractGame.removePlayer(anyPlayer);

        assertThat(anyPlayer, not(isIn(abstractGame.getViewers())));
        assertThat(anyPlayer, not(isIn(abstractGame.getParticipants())));
    }

    @Test
    public void Given_AbstractGame_When_GetTurnControllerCalled_Then_ReturnTurnController() {
        assertEquals(abstractGame.getTurnController(), turnController);
    }

    @Test
    public void Given_AbstractGame_When_NextTurnCalled_Then_MakeMoveCalled() {
        when(abstractGame.getPublicView()).thenReturn(view);
        when(turnController.getNextParticipant(anyList())).thenReturn(participant);
        when(participant.requestMove(view)).thenReturn(move);

        abstractGame.nextTurn();

        verify(abstractGame, times(1)).makeMove(move);
    }

    @Test
    public void Given_AbstractGame_When_GetMoveForParticipantCalled_Then_ReturnMove() {
        when(abstractGame.getPublicView()).thenReturn(view);
        when(participant.requestMove(view)).thenReturn(move);

        assertEquals(abstractGame.getMoveForParticipant(participant), move);
    }

    @Test
    public void Given_AbstractGame_When_GetNextParticipantCalled_Then_ReturnParticipant() {
        when(turnController.getNextParticipant(anyList())).thenReturn(participant);

        assertEquals(abstractGame.getNextParticipant(), participant);
    }

    @Theory
    public void Given_AnyViewerAndAbstractGame_When_UpdateAllViewersCalled_Then_UpdateViewerCalled(Viewer<View> anyViewer) {
        abstractGame.addViewer(anyViewer);
        abstractGame.updateAllViewers();

        verify(abstractGame).updateViewer(anyViewer);
    }

    private static class TestAbstractGame extends AbstractGame<Move, View> {
        TestAbstractGame(TurnController<Move, View> turnController) {
            super(turnController);
        }

        @Override
        public View getPublicView() {
            return null;
        }

        @Override
        public void makeMove(Move move) {
        }

        @Override
        protected void updateViewer(Viewer<View> viewer) {
        }
    }
}
