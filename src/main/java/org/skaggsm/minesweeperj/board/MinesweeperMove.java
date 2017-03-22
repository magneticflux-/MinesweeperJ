package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.PlayerInfo;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * This class represents an immutable move in a minesweeper game.
 *
 * @author Mitchell Skaggs
 */
public class MinesweeperMove implements Move {
    private final PlayerInfo<MinesweeperMove, ? extends View> playerInfo;
    private final int row;
    private final int column;
    private final MoveType moveType;

    private MinesweeperMove(@Nonnull PlayerInfo<MinesweeperMove, ? extends View> playerInfo, @Nonnegative int row, @Nonnegative int column, @Nonnull MoveType moveType) {
        this.playerInfo = playerInfo;
        this.row = row;
        this.column = column;
        this.moveType = moveType;
    }

    @Override
    public PlayerInfo<MinesweeperMove, ? extends View> getPlayerInfo() {
        return playerInfo;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public enum MoveType {
        TEST, FLAG
    }

    /**
     * This class is a builder for {@link MinesweeperMove}.
     *
     * @author Mitchell Skaggs
     */
    public static class Builder {
        private PlayerInfo<MinesweeperMove, ? extends View> playerInfo;
        private int row;
        private int column;
        private MoveType moveType;

        /**
         * Constructs a new instance with default values.
         */
        public Builder() {
            this.playerInfo = null;
            this.row = -1;
            this.column = -1;
            this.moveType = null;
        }

        /**
         * Sets the playerInfo that made the move.
         *
         * @param playerInfo The playerInfo
         * @return The builder
         */
        public Builder setPlayerInfo(@Nonnull PlayerInfo<MinesweeperMove, ? extends View> playerInfo) {
            this.playerInfo = playerInfo;
            return this;
        }


        /**
         * Sets the row to which this move will refer.
         *
         * @param row The row to set
         * @return The builder
         * @throws IllegalArgumentException If {@code row} < 0
         */
        public Builder setRow(@Nonnegative int row) {
            if (row < 0)
                throw new IllegalArgumentException("'row' must be >= 0!");

            this.row = row;
            return this;
        }

        /**
         * Sets the column to which this move will refer.
         *
         * @param column The column to set
         * @return The builder
         * @throws IllegalArgumentException If {@code column} < 0
         */
        public Builder setColumn(@Nonnegative int column) {
            if (column < 0)
                throw new IllegalArgumentException("'column' must be >= 0!");

            this.column = column;
            return this;
        }

        /**
         * Convenience method. Sets the row and column to which this move will refer.
         *
         * @param row    The row to set
         * @param column The column to set
         * @return The builder
         * @throws IllegalArgumentException If {@code row} or {@code column} are < 0
         */
        public Builder setCoordinates(@Nonnegative int row, @Nonnegative int column) {
            this.setRow(row);
            this.setColumn(column);
            return this;
        }

        /**
         * Sets the move type of this move.
         *
         * @param moveType The type of move
         * @return The builder
         */
        public Builder setMoveType(@Nonnull MoveType moveType) {
            this.moveType = moveType;
            return this;
        }

        /**
         * Builds a {@link MinesweeperMove}.
         *
         * @return a new MinesweeperMoveL
         * @throws NullPointerException if {@link Builder#setPlayerInfo(PlayerInfo)} or {@link Builder#setMoveType(MoveType)} was not called
         */
        public MinesweeperMove build() {
            checkArguments();
            return new MinesweeperMove(playerInfo, row, column, moveType);
        }

        /**
         * Throws {@link IllegalStateException} if the builder has not been fully constructed before the {@link Builder#build()} method is called.
         */
        private void checkArguments() {
            if (this.playerInfo == null)
                throw new IllegalStateException("\"setPlayerInfo\" must be called before building!");
            if (row < 0)
                throw new IllegalStateException("\"setRow\" must be called before building!");
            if (column < 0)
                throw new IllegalStateException("\"setColumn\" must be called before building!");
            if (moveType == null)
                throw new IllegalStateException("\"setMoveType\" must be called before building!");
        }
    }
}
