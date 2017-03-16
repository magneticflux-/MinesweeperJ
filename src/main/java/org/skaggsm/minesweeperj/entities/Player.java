package org.skaggsm.minesweeperj.entities;

import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

/**
 * This class defines the identity of player of a game.
 *
 * @author Mitchell Skaggs
 */
public interface Player<M extends Move, V extends View> extends Viewer<V>, Participant<M, V> {
    String getName();
}
