package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Viewer;

import javax.annotation.Nonnull;

/**
 * This interface defines an object that is able to be viewed.
 *
 * @author Mitchell Skaggs
 */
public interface Viewable<V extends View> {
    /**
     * Adds a viewer to this Viewable.
     *
     * @param viewer the viewer to add
     */
    void addViewer(@Nonnull Viewer<V> viewer);

    /**
     * Removes a viewer from this Viewable.
     *
     * @param viewer the viewer to remove
     */
    void removeViewer(@Nonnull Viewer<V> viewer);

    /**
     * Returns the publicly visible view of the Viewable.
     *
     * @return a public view
     */
    V getPublicView();
}
