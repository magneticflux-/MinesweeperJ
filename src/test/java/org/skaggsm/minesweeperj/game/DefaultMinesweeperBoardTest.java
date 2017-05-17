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

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.game.tile.MinesweeperTile;

import java.awt.*;
import java.util.Collection;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.skaggsm.matchers.ThrowsException.doesThrow;

/**
 * @author Mitchell Skaggs
 */
@RunWith(JUnit4.class)
@Category(UnitTests.class)
public class DefaultMinesweeperBoardTest {
    private MinesweeperBoard minesweeperBoard;

    @SuppressWarnings("SpellCheckingInspection")
    @Before
    public void setUp() {
        /*
        Current field diagram
         ____________
        |X . . X X X |
        |. . . X . X |
        |. . . X X X |
         ------------
         */
        minesweeperBoard = new DefaultMinesweeperBoard(6, 6);
        minesweeperBoard.setBomb(0, 0);


        minesweeperBoard.setBomb(3, 0);
        minesweeperBoard.setBomb(4, 0);
        minesweeperBoard.setBomb(5, 0);

        minesweeperBoard.setBomb(3, 1);
        minesweeperBoard.setBomb(5, 1);

        minesweeperBoard.setBomb(3, 2);
        minesweeperBoard.setBomb(4, 2);
        minesweeperBoard.setBomb(5, 2);
    }

    @Test
    public void When_GetTileCalledOnBomb_Return_BombTile() {
        MinesweeperTile tile = minesweeperBoard.getTile(0, 0);
        assertTrue(tile.isBomb());

        assertThat(tile::getAdjacentBombCount, doesThrow(UnsupportedOperationException.class));
    }

    @Test
    public void When_GetTileCalledOnEmptyTile_Return_NumberOfAdjacentBombs() {
        MinesweeperTile tile1 = minesweeperBoard.getTile(1, 0);
        assertFalse(tile1.isBomb());
        assertEquals(tile1.getAdjacentBombCount(), 1);

        MinesweeperTile tile2 = minesweeperBoard.getTile(4, 1);
        assertFalse(tile2.isBomb());
        assertEquals(tile2.getAdjacentBombCount(), 8);
    }

    @Test
    public void When_GetAdjacentTilesCalledAtEdge_Return_FiveAdjacentTiles() {
        Collection<Point> points = minesweeperBoard.getAdjacentPoints(1, 0);

        assertThat(points, containsInAnyOrder(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 0)
        ));
    }

    @Test
    public void When_GetAdjacentTilesCalledAtCorner_Return_ThreeAdjacentTiles() {
        Collection<Point> topLeftPoints = minesweeperBoard.getAdjacentPoints(0, 0);

        assertThat(topLeftPoints, containsInAnyOrder(
                new Point(1, 0),
                new Point(0, 1),
                new Point(1, 1)
        ));

        Collection<Point> bottomRightPoints = minesweeperBoard.getAdjacentPoints(5, 5);

        assertThat(bottomRightPoints, containsInAnyOrder(
                new Point(4, 5),
                new Point(5, 4),
                new Point(4, 4)
        ));
    }

    @Test
    public void When_SetBombCalledOutsideBoard_Throw_IllegalArgumentException() {
        assertThat(() -> minesweeperBoard.setBomb(-1, -1),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.setBomb(-1, 0),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.setBomb(0, -1),
                doesThrow(IllegalArgumentException.class));

        assertThat(() -> minesweeperBoard.setBomb(6, 6),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.setBomb(6, 5),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.setBomb(5, 6),
                doesThrow(IllegalArgumentException.class));
    }

    @Test
    public void When_getAdjacentPointsCalledOutsideBoard_Throw_IllegalArgumentException() {
        assertThat(() -> minesweeperBoard.getAdjacentPoints(-1, -1),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(-1, 0),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(0, -1),
                doesThrow(IllegalArgumentException.class));

        assertThat(() -> minesweeperBoard.getAdjacentPoints(6, 6),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(6, 5),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(5, 6),
                doesThrow(IllegalArgumentException.class));
    }

    @Test
    public void When_GetAdjacentPointsCalledOutsideBoard_Throw_IllegalArgumentException() {
        assertThat(() -> minesweeperBoard.getAdjacentPoints(-1, -1),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(-1, 0),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(0, -1),
                doesThrow(IllegalArgumentException.class));

        assertThat(() -> minesweeperBoard.getAdjacentPoints(6, 6),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(6, 5),
                doesThrow(IllegalArgumentException.class));
        assertThat(() -> minesweeperBoard.getAdjacentPoints(5, 6),
                doesThrow(IllegalArgumentException.class));
    }
}
