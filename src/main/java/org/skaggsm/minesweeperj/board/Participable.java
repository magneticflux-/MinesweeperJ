package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;

import javax.annotation.Nonnull;

/**
 * This interface defines an object that is able to be participated in.
 *
 * @author Mitchell Skaggs
 */
public interface Participable<M extends Move, V extends View> {
    /**
     * Adds a participant to this Participable.
     *
     * @param participant the participant to add
     */
    void addParticipant(@Nonnull Participant<M, V> participant);

    /**
     * Removes a participant from this Participable.
     *
     * @param participant the participant to remove
     */
    void removeParticipant(@Nonnull Participant<M, V> participant);
}
