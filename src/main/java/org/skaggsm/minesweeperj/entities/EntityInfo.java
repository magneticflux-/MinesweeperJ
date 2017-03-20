package org.skaggsm.minesweeperj.entities;

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
