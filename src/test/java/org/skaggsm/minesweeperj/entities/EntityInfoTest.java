package org.skaggsm.minesweeperj.entities;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.skaggsm.categories.UnitTests;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class tests the {@link EntityInfo} class.
 *
 * @author Mitchell Skaggs
 */
@Category(UnitTests.class)
@RunWith(Theories.class)
public class EntityInfoTest {
    @Mock
    @DataPoint
    public static Entity SIMPLE_ENTITY;
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setUp() {
        SIMPLE_ENTITY = mock(Player.class);
        when(SIMPLE_ENTITY.getIdentification()).thenReturn(new UUID(0, 0));
    }

    @Theory
    public void Given_AnyEntity_WhenEntityInfoCreated_Then_ReturnSameData(Entity anyEntity) {
        EntityInfo entityInfo = new EntityInfo(anyEntity);

        assertEquals(anyEntity.getIdentification(), entityInfo.getIdentification());
    }
}