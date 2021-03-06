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

package org.skaggsm.minesweeperj.game.player;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.skaggsm.minesweeperj.game.DefaultMinesweeperMove;

import java.awt.*;
import java.io.StringReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Mitchell Skaggs
 */
public class InputStreamMinesweeperPlayerTest {
    private InputStreamMinesweeperPlayer inputStreamMinesweeperPlayer;

    @Before
    public void setUp() {
        inputStreamMinesweeperPlayer = new InputStreamMinesweeperPlayer(new StringReader("0,0  0,1  1,0  1,1"));
    }

    @Test
    public void When_GetMoveCalled_Return_CorrectMoves() {
        assertThat(inputStreamMinesweeperPlayer.getMove(null), Matchers.is(new DefaultMinesweeperMove(new Point(0, 0))));

        assertThat(inputStreamMinesweeperPlayer.getMove(null), is(new DefaultMinesweeperMove(new Point(0, 1))));

        assertThat(inputStreamMinesweeperPlayer.getMove(null), is(new DefaultMinesweeperMove(new Point(1, 0))));

        assertThat(inputStreamMinesweeperPlayer.getMove(null), is(new DefaultMinesweeperMove(new Point(1, 1))));
    }
}