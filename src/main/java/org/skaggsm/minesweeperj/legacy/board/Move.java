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

package org.skaggsm.minesweeperj.legacy.board;

import org.skaggsm.minesweeperj.legacy.entities.PlayerInfo;

/**
 * This class represents a move by a player. It should provide data to the game about how to progress.
 * <p>Subclasses of this class should be immutable.</p>
 *
 * @author Mitchell Skaggs
 */
public interface Move {
    /**
     * This returns the info of the player that made the move.
     *
     * @return the info of the player this move was made by
     */
    PlayerInfo<? extends Move, ? extends View> getPlayerInfo();
}
