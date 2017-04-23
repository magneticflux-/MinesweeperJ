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

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.LegacyTests;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.legacy.board.Move;
import org.skaggsm.minesweeperj.legacy.board.View;

import javax.annotation.Nonnull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category({UnitTests.class, LegacyTests.class})
public class SimplePlayerTest {
    @DataPoints
    public static final String[] NAME_STRINGS = new String[]{"Test", "", "Player 1", "\'\"Test\"\'"};
    @DataPoint
    public static View SIMPLE_VIEW;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @BeforeClass
    public static void staticSetup() {
        SIMPLE_VIEW = mock(View.class);
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

    @Theory
    public void Given_AnyView_When_UpdateViewCalled_Then_StoreCorrectView(View anyView) {
        SimplePlayer<Move, View> simplePlayer = new SimplePlayerImpl("");

        simplePlayer.updateView(anyView);

        assertEquals(simplePlayer.lastView, anyView);
    }

    @Theory
    public void Given_Nothing_When_RequestMoveCalled_Then_CallRequestMoveWithPrivateView() {
        SimplePlayer<Move, View> simplePlayer = spy(new SimplePlayerImpl(""));
        View view = mock(View.class);

        simplePlayer.updateView(view);
        simplePlayer.requestMove(null);

        verify(simplePlayer).requestMoveWithPrivateView(view);
    }

    private static class SimplePlayerImpl extends SimplePlayer<Move, View> {
        SimplePlayerImpl(@Nonnull String name) {
            super(name);
        }

        @Override
        protected Move requestMoveWithPrivateView(View view) {
            return null;
        }
    }
}