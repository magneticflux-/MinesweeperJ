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

package org.skaggsm.minesweeperj.legacy.board;

import org.skaggsm.minesweeperj.legacy.entities.Participant;

import java.util.List;

/**
 * This interface defines an object that may be used to determine ordering of turns.
 *
 * @author Mitchell Skaggs
 */
public interface TurnController<M extends Move, V extends View> {
    Participant<M, V> getNextParticipant(List<Participant<M, V>> participants);
}
