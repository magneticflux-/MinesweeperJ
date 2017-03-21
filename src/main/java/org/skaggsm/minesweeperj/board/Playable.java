package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

/**
 * @author Mitchell Skaggs
 */
public interface Playable<M extends Move, V extends View> {

    /**
     * Adds a player to the game.
     *
     * @param player The player to add
     */
    void addPlayer(Player<M, V> player);
}