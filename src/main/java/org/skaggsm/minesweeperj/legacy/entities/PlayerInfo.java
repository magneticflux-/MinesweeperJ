/*
 * Copyright (C) 2017 Mitchell Skaggs
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.skaggsm.minesweeperj.legacy.entities;

import org.skaggsm.minesweeperj.legacy.board.Move;
import org.skaggsm.minesweeperj.legacy.board.View;

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
