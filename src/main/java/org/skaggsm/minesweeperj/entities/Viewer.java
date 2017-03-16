package org.skaggsm.minesweeperj.entities;

import org.skaggsm.minesweeperj.board.View;

/**
 * This class represents an entity that observes the game's state. It only receives a view of what it can see.
 *
 * @author Mitchell Skaggs
 */
public interface Viewer<V extends View> extends Entity {
    /**
     * This method is called after a move was made to the game that may have modified this viewer's view of the game state.
     *
     * @param view The provided view of the game
     */
    void updateView(V view);
}
