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

import java.awt.*;
import java.util.Set;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Mitchell Skaggs
 */
public class DefaultMinesweeperGameTest {
    private MinesweeperGame minesweeperGame;
    private MinesweeperBoard minesweeperBoard;

    @Before
    public void setUp() {
        minesweeperBoard = new DefaultMinesweeperBoard(5, 5);
        minesweeperBoard.setBomb(2, 0);
        minesweeperBoard.setBomb(2, 1);
        minesweeperBoard.setBomb(2, 2);
        minesweeperBoard.setBomb(1, 2);
        minesweeperBoard.setBomb(0, 2);
        minesweeperGame = new DefaultMinesweeperGame(minesweeperBoard);
    }

    @Test
    public void When_DefaultMinesweeperGameCreated_ReturnNewDefaultMinesweeperGame() {
        new DefaultMinesweeperGame(minesweeperBoard);
    }

    @Test
    public void When_MakeMoveCalledInEmptyField_UncoverAllTiles() {
        Set<Point> movePoints = minesweeperGame.makeMove(new DefaultMinesweeperMove(new Point(0, 0)));
        Set<Point> testedPoints = minesweeperGame.getTestedPoints();

        assertThat(movePoints, equalTo(testedPoints));
        assertThat(testedPoints, containsInAnyOrder(
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 1),
                new Point(1, 1)));
    }

    @Test
    public void When_MakeMoveCalledNextToBomb_UncoverOneTiles() {
        Set<Point> movePoints = minesweeperGame.makeMove(new DefaultMinesweeperMove(new Point(1, 0)));
        Set<Point> testedPoints = minesweeperGame.getTestedPoints();

        assertThat(movePoints, equalTo(testedPoints));
        assertThat(testedPoints, containsInAnyOrder(
                new Point(1, 0)));
    }
}