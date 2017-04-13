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

package org.skaggsm.minesweeperj.minesweeper.view;

import org.skaggsm.minesweeperj.board.View;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Arrays;

/**
 * This class represents a view of a Minesweeper board.
 *
 * @author Mitchell Skaggs
 */
public class MinesweeperView implements View {
    /**
     * This is returned when {@link MinesweeperView#getTouchingBombs(int, int)} is called on either a bomb or an unknown tile.
     */
    public static final int INVALID_TILE = -1;

    private static final int UNKNOWN_TILE = -2;
    private static final int BOMB_TILE = -1;

    private final long turn;
    /**
     * Values:
     * 0,1,2...8 = touching bombs
     * -1 = bomb tile
     * -2 = unknown tile
     */
    private final int[][] board;

    public MinesweeperView(@Nonnull MinesweeperView other) {
        this.turn = other.turn;
        this.board = deepCopyIntArray(other.board);
    }

    public MinesweeperView(@Nonnegative int rows, @Nonnegative int columns, @Nonnegative long turn) {
        this.turn = turn;
        this.board = new int[rows][columns];
    }

    public MinesweeperView(@Nonnull int[][] board, @Nonnegative long turn) {
        this.turn = turn;
        this.board = board;
    }

    private int[][] deepCopyIntArray(@Nonnull int[][] other) {
        int[][] result = new int[other.length][0];
        for (int i = 0; i < result.length; i++)
            result[i] = Arrays.copyOf(other[i], other[i].length);
        return result;
    }

    /**
     * Used to determine the visibility of a tile.
     *
     * @param row    the row
     * @param column the column
     * @return the visibility of the tested tile
     */
    public TileVisibility getTileState(int row, int column) {
        return this.board[row][column] != UNKNOWN_TILE ? TileVisibility.KNOWN : TileVisibility.UNKNOWN;
    }

    /**
     * Gets the number of adjacent bombs to a tile.
     *
     * @param row    the row
     * @param column the column
     * @return the number of adjacent bombs, or INVALID_TILE if not visible or the tile is a bomb
     */
    public int getTouchingBombs(int row, int column) {
        int tile = this.board[row][column];
        if (tile >= 0) return tile;
        else return INVALID_TILE;
    }

    @Override
    public long getTurn() {
        return this.turn;
    }
}
