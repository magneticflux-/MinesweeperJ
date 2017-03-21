package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

/**
 * This class defines a game board and a method to make a move on the board.
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <V> The type of the object that defines a view of the game state
 * @author Mitchell Skaggs
 */
public interface Game<M extends Move, V extends View> extends Viewable<V>, Participable<M, V> {

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
