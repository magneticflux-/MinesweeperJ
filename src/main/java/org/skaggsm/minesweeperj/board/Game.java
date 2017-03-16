package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;
import org.skaggsm.minesweeperj.entities.Player;
import org.skaggsm.minesweeperj.entities.Viewer;

/**
 * This class defines a game board and a method to make a move on the board.
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <V> The type of the object that defines a view of the game state
 * @author Mitchell Skaggs
 */
public interface Game<M extends Move, V extends View> {
    /**
     * Makes a move on the game board using the provided move data.
     *
     * @param move The move data to use
     */
    void makeMove(M move);

    /**
     * Adds a viewer to the game.
     *
     * @param viewer The viewer to add
     */
    void addViewer(Viewer<V> viewer);

    /**
     * Adds a participant to the game.
     *
     * @param participant The participant to add
     */
    void addParticipant(Participant<M, V> participant);

    /**
     * Adds a player to the game.
     *
     * @param player The player to add
     */
    default void addPlayer(Player<M, V> player) {
        addViewer(player);
        addParticipant(player);
    }
}
