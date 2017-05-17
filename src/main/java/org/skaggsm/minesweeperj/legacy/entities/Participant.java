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

package org.skaggsm.minesweeperj.legacy.entities;

import org.skaggsm.minesweeperj.legacy.board.Move;
import org.skaggsm.minesweeperj.legacy.board.View;

/**
 * This class represents an {@link Entity} that participates in a game and makes moves.
 *
 * @author Mitchell Skaggs
 */
public interface Participant<M extends Move, V extends View> extends Entity {
    /**
     * Called to request a {@link Move} from a {@link Participant}. The participant must act on either public information or information from a {@link Viewer}, which may be the same object.
     *
     * @param view A {@link View} of the board that is publicly available. No viewer-specific information should be provided.
     * @return The move that the participant wishes to make.
     */
    M requestMove(V view);
}
