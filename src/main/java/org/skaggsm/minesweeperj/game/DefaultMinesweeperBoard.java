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

package org.skaggsm.minesweeperj.game;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.skaggsm.minesweeperj.game.tile.BombMinesweeperTile;
import org.skaggsm.minesweeperj.game.tile.EmptyMinesweeperTile;
import org.skaggsm.minesweeperj.game.tile.MinesweeperTile;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mitchell Skaggs
 */
public class DefaultMinesweeperBoard implements MinesweeperBoard {
    private final Set<Point> bombs;
    private final int width;
    private final int height;

    public DefaultMinesweeperBoard(int width, int height) {
        this.width = width;
        this.height = height;
        bombs = new HashSet<>();
    }

    private static int getNthDigit(int number, int base, int n) {
        return (int) ((number / FastMath.pow(base, n)) % base);
    }

    @Override
    public MinesweeperTile getTile(Point point) {
        if (bombs.contains(point))
            return new BombMinesweeperTile();
        else
            return new EmptyMinesweeperTile(
                    getAdjacentPoints(point.x, point.y).stream()
                            .filter(bombs::contains)
                            .count());
    }

    private void requireInRange(int x, int y) {
        if (x < 0 || x >= width)
            throw new IllegalArgumentException(new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_RIGHT, x, 0, width));
        if (y < 0 || y >= height)
            throw new IllegalArgumentException(new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_RIGHT, y, 0, height));
    }

    private boolean inputIsInRange(int x, int y) {
        return x >= 0 && x < width
                && y >= 0 && y < height;
    }

    @Override
    public Set<Point> getAdjacentPoints(int x, int y) {
        requireInRange(x, y);

        Set<Point> points = new HashSet<>(8);

        for (int adjustedYValue = y - 1; adjustedYValue <= y + 1; adjustedYValue++) {
            for (int adjustedXValue = x - 1; adjustedXValue <= x + 1; adjustedXValue++) {

                if (inputIsInRange(adjustedXValue, adjustedYValue)
                        && !(adjustedYValue == y && adjustedXValue == x)) {
                    points.add(new Point(adjustedXValue, adjustedYValue));
                }
            }
        }
        return Collections.unmodifiableSet(points);
    }

    @Override
    public void setBomb(int x, int y) {
        requireInRange(x, y);

        bombs.add(new Point(x, y));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        //noinspection SuspiciousNameCombination
        int rowNumberDigits = (int) FastMath.log10(height) + 1;
        int columnNumberDigits = (int) FastMath.log10(width) + 1;

        //Column numbers
        for (int digit = columnNumberDigits; digit > 0; digit--) {
            Collections.nCopies(rowNumberDigits, " ").forEach(stringBuilder::append);
            stringBuilder.append("  ");
            for (int x = 0; x < width; x++) {
                stringBuilder.append(getNthDigit(x, 10, digit - 1)).append(" ");
            }
            stringBuilder.append(" \n");
        }

        //Divider line
        Collections.nCopies(rowNumberDigits, " ").forEach(stringBuilder::append);
        stringBuilder.append("  ");
        Collections.nCopies(width, "__").forEach(stringBuilder::append);
        stringBuilder.append(" \n");

        //Grid
        for (int y = 0; y < height; y++) {
            //Row number
            stringBuilder.append(String.format("%0" + rowNumberDigits + "d ", y));

            stringBuilder.append('|');
            for (int x = 0; x < width; x++) {
                if (bombs.contains(new Point(x, y)))
                    stringBuilder.append("X ");
                else
                    stringBuilder.append(". ");
            }
            stringBuilder.append("|\n");
        }

        //Last line
        Collections.nCopies(rowNumberDigits, " ").forEach(stringBuilder::append);
        stringBuilder.append("  ");
        Collections.nCopies(width, "--").forEach(stringBuilder::append);
        stringBuilder.append(" ");

        return stringBuilder.toString();
    }
}
