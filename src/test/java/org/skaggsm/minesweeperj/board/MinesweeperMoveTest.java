package org.skaggsm.minesweeperj.board;

import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.skaggsm.categories.UnitTests;
import org.skaggsm.minesweeperj.entities.Player;

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
    public static Player<MinesweeperMove, View> SIMPLE_PLAYER = mock(Player.class);

    @DataPoints
    public static int[] ROWS_AND_COLUMNS = new int[]{-1, 0, 1, 2};

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Theory
    public void Given_Defaults_When_SetCoordinatesBuildCalled_Then_AllDataMatches(Player<MinesweeperMove, ? extends View> anyPlayer, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        MinesweeperMove minesweeperMove = new MinesweeperMove.Builder()
                .setPlayer(anyPlayer)
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();

        assertEquals(minesweeperMove.getPlayer(), anyPlayer);
        assertEquals(minesweeperMove.getMoveType(), anyMoveType);
        assertEquals(minesweeperMove.getRow(), row);
        assertEquals(minesweeperMove.getColumn(), column);
    }

    @Theory
    public void Given_Defaults_When_SetRowSetColumnBuildCalled_Then_AllDataMatches(Player<MinesweeperMove, ? extends View> anyPlayer, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        MinesweeperMove minesweeperMove = new MinesweeperMove.Builder()
                .setPlayer(anyPlayer)
                .setMoveType(anyMoveType)
                .setRow(row)
                .setColumn(column)
                .build();

        assertEquals(minesweeperMove.getPlayer(), anyPlayer);
        assertEquals(minesweeperMove.getMoveType(), anyMoveType);
        assertEquals(minesweeperMove.getRow(), row);
        assertEquals(minesweeperMove.getColumn(), column);
    }

    @Theory
    public void Given_NegativeRowAnyColumn_When_BuildCalled_Then_ThrowIllegalArgumentException(Player<MinesweeperMove, ? extends View> anyPlayer, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(row, lessThan(0));

        exceptionRule.expect(IllegalArgumentException.class);
        new MinesweeperMove.Builder()
                .setPlayer(anyPlayer)
                .setMoveType(anyMoveType)
                .setCoordinates(row, column)
                .build();
    }

    @Theory
    public void Given_AnyRowNegativeColumn_When_BuildCalled_Then_ThrowIllegalArgumentException(Player<MinesweeperMove, ? extends View> anyPlayer, MinesweeperMove.MoveType anyMoveType, int row, int column) throws Exception {
        assumeThat(column, lessThan(0));

        exceptionRule.expect(IllegalArgumentException.class);
        new MinesweeperMove.Builder()
                .setPlayer(anyPlayer)
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
    public void Given_NoMoveType_When_BuildCalled_Then_ThrowIllegalStateException(Player<MinesweeperMove, ? extends View> anyPlayer, int row, int column) throws Exception {
        assumeThat(row, greaterThanOrEqualTo(0));
        assumeThat(column, greaterThanOrEqualTo(0));

        exceptionRule.expect(IllegalStateException.class);
        new MinesweeperMove.Builder()
                .setPlayer(anyPlayer)
                .setCoordinates(row, column)
                .build();
    }
}