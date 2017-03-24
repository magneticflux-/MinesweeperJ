package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;

import java.util.List;

/**
 * This class organizes participants' turn ordering.
 *
 * @author Mitchell Skaggs
 */
public class SequentialTurnController<M extends Move, V extends View> implements TurnController<M, V> {
    protected int lastMovedIndex = 0;

    @Override
    public Participant<M, V> getNextParticipant(List<Participant<M, V>> participants) {
        if (participants.size() == 0)
            throw new IllegalArgumentException("Participant list size must be > 0!");

        lastMovedIndex %= participants.size();

        return participants.get(lastMovedIndex++);
    }
}
