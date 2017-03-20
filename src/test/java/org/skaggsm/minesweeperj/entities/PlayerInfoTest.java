package org.skaggsm.minesweeperj.entities;

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
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class tests the {@link PlayerInfo} class.
 *
 * @author Mitchell Skaggs
 */
@Category(UnitTests.class)
@RunWith(Theories.class)
public class PlayerInfoTest {
    @Mock
    @DataPoint
    public static Player<? extends Move, ? extends View> SIMPLE_PLAYER;
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setUp() {
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