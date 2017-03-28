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

package org.skaggsm.minesweeperj.entities;

import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

import javax.annotation.Nonnull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category(UnitTests.class)
public class SimplePlayerTest {
    @DataPoints
    public static final String[] NAME_STRINGS = new String[]{"Test", "", "Player 1", "\'\"Test\"\'"};

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Before
    public void setup() {
    }

    @Theory
    public void Given_AnyName_WhenGetNameCalled_Then_ReturnName(String anyName) {
        SimplePlayer<Move, View> simplePlayer = new SimplePlayerImpl(anyName);

        assertEquals(simplePlayer.getName(), anyName);
    }

    @Theory
    public void Given_Nothing_WhenTwoSimplePlayersCreatedAtTheSameTime_Then_ReturnUniqueUUID() {
        SimplePlayer<Move, View> simplePlayer1 = new SimplePlayerImpl("Player 1");
        SimplePlayer<Move, View> simplePlayer2 = new SimplePlayerImpl("Player 2");

        assertNotEquals(simplePlayer1.getIdentification(), simplePlayer2.getIdentification());
    }

    private static final class SimplePlayerImpl extends SimplePlayer<Move, View> {
        public SimplePlayerImpl(@Nonnull String name) {
            super(name);
        }

        @Override
        public void updateView(View view) {
        }

        @Override
        public Move requestMove(View view) {
            return null;
        }
    }
}