package org.skaggsm.minesweeperj.board;

/**
 * This interface defines an object that possesses a turn controller.
 *
 * @author Mitchell Skaggs
 */
public interface HasTurnController<M extends Move, V extends View> {
    TurnController<M, V> getTurnController();
}
