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
import org.skaggsm.minesweeperj.legacy.entities.Viewer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class defines a game.
 *
 * @param <M> The type of the object that encapsulates a move
 * @param <V> The type of the object that defines a view of the game state
 * @author Mitchell Skaggs
 */
public abstract class AbstractGame<M extends Move, V extends View> implements Game<M, V> {
    protected final TurnController<M, V> turnController;
    protected final List<Viewer<V>> viewers;
    protected final List<Participant<M, V>> participants;

    /**
     * Creates a new AbstractGame using the provided TurnController for deciding turn ordering.
     *
     * @param turnController the TurnController for the AbstractGame to use
     */
    public AbstractGame(TurnController<M, V> turnController) {
        this.turnController = turnController;
        viewers = new ArrayList<>();
        participants = new ArrayList<>();
    }

    @Override
    public void nextTurn() {
        this.makeMove(getMoveForParticipant(getNextParticipant()));
    }

    protected M getMoveForParticipant(Participant<M, V> participant) {
        return participant.requestMove(this.getPublicView());
    }

    protected Participant<M, V> getNextParticipant() {
        return turnController.getNextParticipant(this.participants);
    }

    @Override
    public TurnController getTurnController() {
        return turnController;
    }

    @Override
    public void addViewer(@Nonnull Viewer<V> viewer) {
        viewers.add(viewer);
    }

    @Override
    public void removeViewer(@Nonnull Viewer<V> viewer) {
        viewers.remove(viewer);
    }

    public List<Viewer<V>> getViewers() {
        return Collections.unmodifiableList(viewers);
    }

    @Override
    public void addParticipant(@Nonnull Participant<M, V> participant) {
        participants.add(participant);
    }

    @Override
    public void removeParticipant(@Nonnull Participant<M, V> participant) {
        participants.remove(participant);
    }

    public List<Participant<M, V>> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    protected void updateAllViewers() {
        for (Viewer<V> viewer : viewers) {
            updateViewer(viewer);
        }
    }

    protected abstract void updateViewer(Viewer<V> viewer);
}
