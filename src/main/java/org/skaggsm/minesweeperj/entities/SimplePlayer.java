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

package org.skaggsm.minesweeperj.entities;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import org.skaggsm.minesweeperj.board.Move;
import org.skaggsm.minesweeperj.board.View;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * This class is a useful base class for {@link Player} implementers.
 *
 * @author Mitchell Skaggs
 */
public abstract class SimplePlayer<M extends Move, V extends View> implements Player<M, V> {
    protected final String name;
    protected final UUID identification;
    protected V lastView;

    public SimplePlayer(@Nonnull String name) {
        this.name = name;
        this.identification = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UUID getIdentification() {
        return this.identification;
    }

    @Override
    public void updateView(V view) {
        lastView = view;
    }

    @Override
    public M requestMove(V view) {
        return requestMoveWithPrivateView(lastView);
    }

    /**
     * This method is called using the stored {@link View} received from being a privileged {@link Viewer}.
     *
     * @param view the private view
     * @return the move that the player wishes to make.
     * @see Participant#requestMove(View)
     * @see Viewer#updateView(View)
     */
    protected abstract M requestMoveWithPrivateView(V view);
}
