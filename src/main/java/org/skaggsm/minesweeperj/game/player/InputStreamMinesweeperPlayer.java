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

import org.skaggsm.minesweeperj.game.DefaultMinesweeperMove;
import org.skaggsm.minesweeperj.game.MinesweeperGame;
import org.skaggsm.minesweeperj.game.MinesweeperMove;

import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Mitchell Skaggs
 */
public class InputStreamMinesweeperPlayer implements MinesweeperPlayer {
    private static final Pattern WHITESPACE_COMMA_PATTERN = Pattern.compile("[\\p{javaWhitespace},;]+");
    private final Scanner scanner;

    public InputStreamMinesweeperPlayer(InputStream inputStream) {
        this(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public InputStreamMinesweeperPlayer(Readable readable) {
        scanner = new Scanner(readable);
        scanner.useDelimiter(WHITESPACE_COMMA_PATTERN);
    }

    @Override
    public MinesweeperMove getMove(MinesweeperGame minesweeperGame) {
        int xCoordinate = scanner.nextInt();
        int yCoordinate = scanner.nextInt();

        return new DefaultMinesweeperMove(new Point(xCoordinate, yCoordinate));
    }
}
