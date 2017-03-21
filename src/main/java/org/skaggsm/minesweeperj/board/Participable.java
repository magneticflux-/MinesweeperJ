package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;

import javax.annotation.Nonnull;

/**
 * @author Mitchell Skaggs
 */
public interface Participable<M extends Move, V extends View> {
    /**
     * Adds a participant to the game.
     *
     * @param participant The participant to add
     */
    void addParticipant(@Nonnull Participant<M, V> participant);
}
