package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Player;

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

    public MinesweeperMove(Player<MinesweeperMove, ? extends View> player, int row, int column, MoveType moveType) {
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
}
