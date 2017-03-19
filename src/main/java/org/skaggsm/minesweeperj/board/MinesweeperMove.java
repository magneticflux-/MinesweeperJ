package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * This class represents an immutable move in a minesweeper game.
 *
 * @author Mitchell Skaggs
 */
public class MinesweeperMove implements Move {
    private final Player<MinesweeperMove, ? extends View> player;
    private final int row;
    private final int column;
    private final MoveType moveType;

    private MinesweeperMove(@Nonnull Player<MinesweeperMove, ? extends View> player, @Nonnegative int row, @Nonnegative int column, @Nonnull MoveType moveType) {
        this.player = player;
        this.row = row;
        this.column = column;
        this.moveType = moveType;
    }

    @Override
    public Player<MinesweeperMove, ? extends View> getPlayer() {
        return player;
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
        private Player<MinesweeperMove, ? extends View> player;
        private int row;
        private int column;
        private MoveType moveType;

        /**
         * Constructs a new instance with default values.
         */
        public Builder() {
            this.player = null;
            this.row = -1;
            this.column = -1;
            this.moveType = null;
        }

        /**
         * Sets the player that made the move.
         *
         * @param player The player
         * @return The builder
         */
        public Builder setPlayer(@Nonnull Player<MinesweeperMove, ? extends View> player) {
            this.player = player;
            return this;
        }


        /**
         * Sets the row to which this move will refer.
         *
         * @param row The row to set
         * @return The builder
         */
        public Builder setRow(@Nonnegative int row) {
            this.row = row;
            return this;
        }

        /**
         * Sets the column to which this move will refer.
         *
         * @param column The column to set
         * @return The builder
         */
        public Builder setColumn(@Nonnegative int column) {
            this.column = column;
            return this;
        }

        /**
         * Convenience method. Sets the row and column to which this move will refer.
         *
         * @param row    The row to set
         * @param column The column to set
         * @return The builder
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
         * @return a new MinesweeperMove
         * @throws NullPointerException if {@link Builder#setPlayer(Player)} or {@link Builder#setMoveType(MoveType)} was not called
         */
        public MinesweeperMove build() {
            checkArguments();
            return new MinesweeperMove(player, row, column, moveType);
        }

        /**
         * Throws {@link IllegalStateException} if the builder has not been fully constructed before the {@link Builder#build()} method is called.
         */
        private void checkArguments() {
            if (this.player == null)
                throw new IllegalStateException("\"setPlayer\" must be called before building!");
            if (row < 0)
                throw new IllegalStateException("\"setRow\" must be called before building!");
            if (column < 0)
                throw new IllegalStateException("\"setColumn\" must be called before building!");
            if (moveType == null)
                throw new IllegalStateException("\"setMoveType\" must be called before building!");
        }
    }
}
