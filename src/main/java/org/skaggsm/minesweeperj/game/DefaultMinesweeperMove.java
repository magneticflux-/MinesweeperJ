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

package org.skaggsm.minesweeperj.game;

import javax.annotation.Nonnull;
import java.awt.*;

/**
 * @author Mitchell Skaggs
 */
public class DefaultMinesweeperMove implements MinesweeperMove {
    @Nonnull
    private final Point point;

    public DefaultMinesweeperMove(@Nonnull Point point) {
        this.point = point;
    }

    @Override
    @Nonnull
    public Point getPoint() {
        return point;
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultMinesweeperMove that = (DefaultMinesweeperMove) o;

        return point.equals(that.point);
    }

    @Override
    public String toString() {
        return "DefaultMinesweeperMove{" +
                "point=" + point +
                '}';
    }
}
