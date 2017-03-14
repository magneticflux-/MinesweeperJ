package org.skaggsm.minesweeperj.board;

/**
 * This class defines a game board and a method to make a move on the board
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <S> The type of the object that defines the publicly visible game state
 * @author Mitchell Skaggs
 */
public interface Game<M extends Move, S> {
    /**
     * Makes a move on the game board using the provided move data
     *
     * @param move the move data to use
     */
    void makeMove(M move);

    /**
     * Gets the current game state.
     *
     * @return The current game state. Recommended to be immutable.
     */
    S getGameState();
}
