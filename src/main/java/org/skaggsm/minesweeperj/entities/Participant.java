package org.skaggsm.minesweeperj.entities;

import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

/**
 * This class represents an {@link Entity} that participates in a game and makes moves.
 *
 * @author Mitchell Skaggs
 */
public interface Participant<M extends Move, V extends View> extends Entity {
    /**
     * Called to request a {@link Move} from a {@link Participant}. The participant must act on either public information or information from a {@link Viewer}, which may be the same object.
     *
     * @param view A {@link View} of the board that is publicly available. No viewer-specific information should be provided.
     * @return The move that the participant wishes to make.
     */
    M requestMove(V view);
}
