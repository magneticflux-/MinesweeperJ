package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.player.Player;

/**
 * This class represents an a move by a player. It should provide data to the game about how to progress.
 *
 * @author Mitchell Skaggs
 */
public interface Move {
    /**
     * This returns the player that made the move.
     *
     * @return the player this move was made by
     */
    Player getPlayer();
}
