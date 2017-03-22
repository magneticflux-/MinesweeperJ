package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.PlayerInfo;

/**
 * This class represents a move by a player. It should provide data to the game about how to progress.
 * <p>Subclasses of this class should be immutable.</p>
 *
 * @author Mitchell Skaggs
 */
public interface Move {
    /**
     * This returns the info of the player that made the move.
     *
     * @return the info of the player this move was made by
     */
    PlayerInfo<? extends Move, ? extends View> getPlayerInfo();
}
