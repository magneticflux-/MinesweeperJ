package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Viewer;

/**
 * @author Mitchell Skaggs
 */
public interface Viewable<V extends View> {
    /**
     * Adds a viewer to the game.
     *
     * @param viewer The viewer to add
     */
    void addViewer(Viewer<V> viewer);
}
