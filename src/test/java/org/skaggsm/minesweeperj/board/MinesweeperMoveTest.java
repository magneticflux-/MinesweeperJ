package org.skaggsm.minesweeperj.board;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.PlayerInfo;

import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;
import static org.mockito.Mockito.mock;

/**
 * This class tests the {@link MinesweeperMove} class.
 *
 * @author Mitchell Skaggs
 */
@Category(UnitTests.class)
@RunWith(Theories.class)
public class MinesweeperMoveTest {
    @DataPoints
    public static MinesweeperMove.MoveType[] MOVE_TYPES = MinesweeperMove.MoveType.values();

    @SuppressWarnings("unchecked")
    @DataPoint
    public static PlayerInfo<MinesweeperMove, View> SIMPLE_PLAYER_INFO;

    @DataPoints
    public static int[] ROWS_AND_COLUMNS = new int[]{-1, 0, 1, 2};

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setup() {
        SIMPLE_PLAYER_INFO = mock(PlayerInfo.class);
    }

    @Theory
    public void Given_Defaults_When_SetCoordinatesBuildCalled_Then_AllDataMatches(PlayerInfo<MinesweeperMove, ? extends View> anyPlayerInfo, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        MinesweeperMove minesweeperMove = new MinesweeperMove.Builder()
                .setPlayerInfo(anyPlayerInfo)
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();

        assertEquals(minesweeperMove.getPlayerInfo(), anyPlayerInfo);
        assertEquals(minesweeperMove.getMoveType(), anyMoveType);
        assertEquals(minesweeperMove.getRow(), row);
        assertEquals(minesweeperMove.getColumn(), column);
    }

    @Theory
    public void Given_Defaults_When_SetRowSetColumnBuildCalled_Then_AllDataMatches(PlayerInfo<MinesweeperMove, ? extends View> anyPlayerInfo, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        MinesweeperMove minesweeperMove = new MinesweeperMove.Builder()
                .setPlayerInfo(anyPlayerInfo)
                .setMoveType(anyMoveType)
                .setRow(row)
                .setColumn(column)
                .build();

        assertEquals(minesweeperMove.getPlayerInfo(), anyPlayerInfo);
        assertEquals(minesweeperMove.getMoveType(), anyMoveType);
        assertEquals(minesweeperMove.getRow(), row);
        assertEquals(minesweeperMove.getColumn(), column);
    }

    @Theory
    public void Given_NegativeRowAnyColumn_When_BuildCalled_Then_ThrowIllegalArgumentException(PlayerInfo<MinesweeperMove, ? extends View> anyPlayerInfo, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, lessThan(0));

        exceptionRule.expect(IllegalArgumentException.class);
        new MinesweeperMove.Builder()
                .setPlayerInfo(anyPlayerInfo)
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();
    }

    @Theory
    public void Given_AnyRowNegativeColumn_When_BuildCalled_Then_ThrowIllegalArgumentException(PlayerInfo<MinesweeperMove, ? extends View> anyPlayerInfo, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(column, lessThan(0));

        exceptionRule.expect(IllegalArgumentException.class);
        new MinesweeperMove.Builder()
                .setPlayerInfo(anyPlayerInfo)
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();
    }

    @Theory
    public void Given_NoPlayer_When_BuildCalled_Then_ThrowIllegalStateException(MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        exceptionRule.expect(IllegalStateException.class);
        new MinesweeperMove.Builder()
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();
    }

    @Theory
    public void Given_NoMoveType_When_BuildCalled_Then_ThrowIllegalStateException(PlayerInfo<MinesweeperMove, ? extends View> anyPlayerInfo, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        exceptionRule.expect(IllegalStateException.class);
        new MinesweeperMove.Builder()
                .setPlayerInfo(anyPlayerInfo)
                .setCoordinates(row, column)
                .build();
    }
}