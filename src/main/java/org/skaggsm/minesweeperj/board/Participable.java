package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;

/**
 * @author Mitchell Skaggs
 */
public interface Participable<M extends Move, V extends View> {
    /**
     * Adds a participant to the game.
     *
     * @param participant The participant to add
     */
    void addParticipant(Participant<M, V> participant);
}
