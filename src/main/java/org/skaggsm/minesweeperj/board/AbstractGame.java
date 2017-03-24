package org.skaggsm.minesweeperj.board;

import org.skaggsm.minesweeperj.entities.Participant;
import org.skaggsm.minesweeperj.entities.Viewer;

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
