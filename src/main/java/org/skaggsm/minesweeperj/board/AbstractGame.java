package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Viewer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * This class defines a game.
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <V> The type of the object that defines a view of the game state
 * @author Mitchell Skaggs
 */
public abstract class AbstractGame<M extends Move, V extends View> implements Game<M, V> {
    protected List<Viewer<V>> viewers;

    public AbstractGame() {
        viewers = new ArrayList<>();
    }

    @Override
    public void addViewer(@Nonnull Viewer<V> viewer) {
        viewers.add(viewer);
    }
}
