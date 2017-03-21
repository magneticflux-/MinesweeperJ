package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

import javax.annotation.Nonnull;

/**
 * @author Mitchell Skaggs
 */
public interface Playable<M extends Move, V extends View> {

    /**
     * Adds a player to this Playable.
     *
     * @param player the player to add
     */
    void addPlayer(@Nonnull Player<M, V> player);
}