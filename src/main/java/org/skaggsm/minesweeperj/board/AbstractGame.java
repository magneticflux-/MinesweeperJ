package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

import javax.annotation.Nonnull;

/**
 * This class defines a game board and a method to make a move on the board.
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <V> The type of the object that defines a view of the game state
 * @author Mitchell Skaggs
 */
public abstract class AbstractGame<M extends Move, V extends View> implements Viewable<V>, Participable<M, V>, Playable<M, V> {
    public void addPlayer(@Nonnull Player<M, V> player) {
        addViewer(player);
        addParticipant(player);
    }
}
