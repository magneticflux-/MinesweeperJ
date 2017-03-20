package org.skaggsm.minesweeperj.entities;

import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

import javax.annotation.Nonnull;

/**
 * This class represents the static information about a player.
 *
 * @author Mitchell Skaggs
 */
public class PlayerInfo<M extends Move, V extends View> extends EntityInfo {
    protected final String name;

    /**
     * Constructs a PlayerInfo based on the provided {@link Player}.
     *
     * @param player the Player to take information from
     */
    public PlayerInfo(@Nonnull Player<M, V> player) {
        super(player);
        this.name = player.getName();
    }

    /**
     * Gets the name from this instance.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }
}
