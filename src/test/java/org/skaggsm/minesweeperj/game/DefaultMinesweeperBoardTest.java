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
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.game.tile.MinesweeperTile;

import static org.junit.Assert.*;

/**
 * @author Mitchell Skaggs
 */
@RunWith(JUnit4.class)
@Category(UnitTests.class)
public class DefaultMinesweeperBoardTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

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
        minesweeperBoard = new DefaultMinesweeperBoard();
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

        thrown.expect(UnsupportedOperationException.class);
        tile.getAdjacentBombCount();
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
}
