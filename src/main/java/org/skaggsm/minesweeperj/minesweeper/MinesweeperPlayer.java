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

package org.skaggsm.minesweeperj.minesweeper;

import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;
import org.skaggsm.minesweeperj.entities.SimplePlayer;

import javax.annotation.Nonnull;

/**
 * This class represents a Minesweeper player. It uses the {@link MinesweeperMove} as its {@link Move}.
 *
 * @author Mitchell Skaggs
 */
public abstract class MinesweeperPlayer extends SimplePlayer<MinesweeperMove, View> {
    public MinesweeperPlayer(@Nonnull String name) {
        super(name);
    }
}
