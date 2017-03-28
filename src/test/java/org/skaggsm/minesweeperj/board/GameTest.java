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

package org.skaggsm.minesweeperj.board;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Player;

import static org.mockito.Mockito.*;

/**
 * This class tests the {@link AbstractGame} class.
 *
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category(UnitTests.class)
public class GameTest {
    @Mock
    @DataPoint
    public static Player<Move, View> SIMPLE_PLAYER;

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Game<Move, View> game;

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setup() {
        SIMPLE_PLAYER = mock(Player.class); //Needed because of @DataPoint usage and static field
    }

    @Theory
    public void Given_AnyPlayer_When_AddPlayerCalled_Then_AddParticipantCalledAddViewerCalled(Player<Move, View> anyPlayer) throws Exception {
        game.addPlayer(anyPlayer);

        verify(game, times(1)).addParticipant(anyPlayer);
        verify(game, times(1)).addViewer(anyPlayer);
    }
}