package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;

import java.util.List;

/**
 * @author Mitchell Skaggs
 */
public interface TurnController<M extends Move, V extends View> {
    Participant<M, V> getNextParticipant(List<Participant<M, V>> participants);
}
