package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

import javax.annotation.Nonnull;

/**
 * This class defines a Game object that uses a {@link TurnController} for deciding moves.
 *
 * @author Mitchell Skaggs
 */
public interface Game<M extends Move, V extends View> extends Viewable<V>, Participable<M, V>, Playable<M, V>, HasTurnController {
    @Override
    default void addPlayer(@Nonnull Player<M, V> player) {
        addViewer(player);
        addParticipant(player);
    }

    @Override
    default void removePlayer(@Nonnull Player<M, V> player) {
        removeParticipant(player);
        removeViewer(player);
    }

    /**
     * Submits a move from the included player's perspective.
     *
     * @param move the move to make
     */
    void makeMove(M move);

    /**
     * Makes the next participant take their move.
     */
    void nextTurn();
}
