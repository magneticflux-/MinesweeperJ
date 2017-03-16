package org.skaggsm.minesweeperj.board;

/**
 * This class represents an immutable view of the game board, relative to the player it was requested by and given to.
 *
 * @author Mitchell Skaggs
 */
public interface View {
    /**
     * Gets the turn number on which this view was created.
     *
     * @return The turn number
     */
    long getTurn();
}
