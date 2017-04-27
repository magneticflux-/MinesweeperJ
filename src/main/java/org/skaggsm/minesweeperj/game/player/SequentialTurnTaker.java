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

package org.skaggsm.minesweeperj.game.player;

import com.google.common.collect.Iterators;
import org.skaggsm.minesweeperj.game.MinesweeperGame;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mitchell Skaggs
 */
public class SequentialTurnTaker implements TurnTaker {
    private final MinesweeperGame minesweeperGame;
    private final Iterator<MinesweeperPlayer> players;

    public SequentialTurnTaker(MinesweeperGame minesweeperGame, MinesweeperPlayer... players) {
        this(minesweeperGame, Arrays.asList(players));
    }

    public SequentialTurnTaker(MinesweeperGame minesweeperGame, List<MinesweeperPlayer> players) {
        this.minesweeperGame = minesweeperGame;
        this.players = Iterators.cycle(players);
    }

    @Override
    public void takeNextTurn() {
        minesweeperGame.makeMove(players.next().getMove(minesweeperGame));
    }
}
