package org.skaggsm.minesweeperj.entities;

import java.util.UUID;

/**
 * This class represents something involved in a game that must be uniquely identified.
 *
 * @author Mitchell Skaggs
 */
public interface Entity {
    /**
     * Used by the game to uniquely identify this object.
     *
     * @return The entity's identity
     */
    UUID getIdentification();
}
