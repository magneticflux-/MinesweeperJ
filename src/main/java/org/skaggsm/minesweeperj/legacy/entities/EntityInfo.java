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

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.UUID;

/**
 * This class represents the static information about an entity.
 *
 * @author Mitchell Skaggs
 */
public class EntityInfo {
    protected final UUID identification;

    /**
     * Constructs an EntityInfo based on the provided {@link Entity}.
     *
     * @param entity the Entity to take information from
     */
    public EntityInfo(@Nonnull Entity entity) {
        Objects.requireNonNull(entity);

        this.identification = entity.getIdentification();
    }

    /**
     * Gets the {@link UUID} identifier from this instance.
     *
     * @return the UUID identifier
     */
    public UUID getIdentification() {
        return identification;
    }
}
