package org.skaggsm.minesweeperj.board;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.Theories;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category(UnitTests.class)
public class SequentialTurnControllerTest {
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    private SequentialTurnController<Move, View> turnController;

    @Before
    public void setup() {
        turnController = new SequentialTurnController<>();
    }

    @Test
    public void Given_EmptyList_When_GetNextParticipantCalled_Then_ThrowIllegalArgumentException() {
        exceptionRule.expect(IllegalArgumentException.class);

        turnController.getNextParticipant(Collections.emptyList());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void Given_List_When_GetNextParticipantCalled_Then_ReturnInLoop() {
        List<Participant<Move, View>> participants = new ArrayList<>();
        Participant<Move, View> participant1 = mock(Participant.class);
        Participant<Move, View> participant2 = mock(Participant.class);
        Participant<Move, View> participant3 = mock(Participant.class);
        Collections.addAll(participants, participant1, participant2, participant3);

        assertEquals(turnController.getNextParticipant(participants), participant1);
        assertEquals(turnController.getNextParticipant(participants), participant2);
        assertEquals(turnController.getNextParticipant(participants), participant3);

        assertEquals(turnController.getNextParticipant(participants), participant1);
        assertEquals(turnController.getNextParticipant(participants), participant2);
        assertEquals(turnController.getNextParticipant(participants), participant3);
    }
}
