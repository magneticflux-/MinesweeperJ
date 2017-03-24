package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

import javax.annotation.Nonnull;

/**
 * @author Mitchell Skaggs
 */
public interface Game<M extends Move, V extends View> extends Viewable<V>, Participable<M, V>, Playable<M, V>, HasTurnController {
    /**
     * Adds a player to this game.
     *
     * @param player the player to add
     */
    default void addPlayer(@Nonnull Player<M, V> player) {
        addViewer(player);
        addParticipant(player);
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
