package org.skaggsm.minesweeperj.board;

/**
 * @author Mitchell Skaggs
 */
public interface HasTurnController<M extends Move, V extends View> {
    TurnController<M, V> getTurnController();
}
