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
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.LegacyTests;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.legacy.board.Move;
import org.skaggsm.minesweeperj.legacy.board.View;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class tests the {@link PlayerInfo} class.
 *
 * @author Mitchell Skaggs
 */
@RunWith(Theories.class)
@Category({UnitTests.class, LegacyTests.class})
public class PlayerInfoTest {
    @Mock
    @DataPoint
    public static Player<? extends Move, ? extends View> SIMPLE_PLAYER;
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setup() {
        SIMPLE_PLAYER = mock(Player.class);
        when(SIMPLE_PLAYER.getName()).thenReturn("Simple Player");
        when(SIMPLE_PLAYER.getIdentification()).thenReturn(new UUID(0, 0));
    }

    @Theory
    public void Given_AnyPlayer_WhenPlayerInfoCreated_Then_ReturnSameData(Player<? extends Move, ? extends View> anyPlayer) {
        PlayerInfo<? extends Move, ? extends View> playerInfo = new PlayerInfo<>(anyPlayer);

        assertEquals(anyPlayer.getName(), playerInfo.getName());
    }
}