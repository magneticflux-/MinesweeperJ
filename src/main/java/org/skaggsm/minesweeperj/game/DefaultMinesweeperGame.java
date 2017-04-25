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

import org.skaggsm.minesweeperj.game.tile.MinesweeperTile;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mitchell Skaggs
 */
public class DefaultMinesweeperGame implements MinesweeperGame {
    private final MinesweeperBoard minesweeperBoard;
    private final Set<Point> testedPoints;

    public DefaultMinesweeperGame(MinesweeperBoard minesweeperBoard) {
        this.minesweeperBoard = minesweeperBoard;
        testedPoints = new HashSet<>();
    }

    @Override
    public Set<Point> makeMove(MinesweeperMove minesweeperMove) {
        Point point = minesweeperMove.getPoint();
        MinesweeperTile tile = minesweeperBoard.getTile(point);
        long adjacentBombCount = tile.getAdjacentBombCount();

        if (tile.isBomb()) {
            throw new RuntimeException("Bomb!");
        }
        if (adjacentBombCount != 0) {
            testedPoints.add(point);
            return Collections.singleton(point);
        } else {
            testedPoints.add(point);
            return Stream.concat(Stream.of(point),
                    minesweeperBoard.getAdjacentPoints(point.x, point.y).stream()
                            .map(DefaultMinesweeperMove::new)
                            .map(this::makeMove)
                            .flatMap(Collection::stream))
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Point> getTestedPoints() {
        return Collections.unmodifiableSet(testedPoints);
    }
}
