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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.skaggsm.minesweeperj.game.MinesweeperGame;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Mitchell Skaggs
 */
public class SequentialTurnTakerTest {
    private SequentialTurnTaker sequentialTurnTaker;
    @Mock
    private MinesweeperGame mockMinesweeperGame;
    @Mock
    private MinesweeperPlayer mockMinesweeperPlayer1, mockMinesweeperPlayer2, mockMinesweeperPlayer3;

    @Before
    public void setUp() {
        initMocks(this);
        sequentialTurnTaker = new SequentialTurnTaker(mockMinesweeperGame, mockMinesweeperPlayer1, mockMinesweeperPlayer2, mockMinesweeperPlayer3);

        when(mockMinesweeperPlayer1.getMove(any(MinesweeperGame.class))).then(Answers.RETURNS_MOCKS);
        when(mockMinesweeperPlayer2.getMove(any(MinesweeperGame.class))).then(Answers.RETURNS_MOCKS);
        when(mockMinesweeperPlayer3.getMove(any(MinesweeperGame.class))).then(Answers.RETURNS_MOCKS);
    }

    @Test
    public void When_TakeNextTurnCalled_Return_CorrectNextPlayer() {
        //First time through turns
        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer1, times(1)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(1)).makeMove(any());

        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer2, times(1)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(2)).makeMove(any());

        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer3, times(1)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(3)).makeMove(any());

        //Second time through turns
        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer1, times(2)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(4)).makeMove(any());

        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer2, times(2)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(5)).makeMove(any());

        sequentialTurnTaker.takeNextTurn();
        verify(mockMinesweeperPlayer3, times(2)).getMove(mockMinesweeperGame);
        verify(mockMinesweeperGame, times(6)).makeMove(any());
    }
}