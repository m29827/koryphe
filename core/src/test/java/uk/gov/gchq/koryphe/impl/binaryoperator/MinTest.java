/*
 * Copyright 2017-2020 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.koryphe.impl.binaryoperator;

import org.junit.Before;
import org.junit.Test;

import uk.gov.gchq.koryphe.binaryoperator.BinaryOperatorTest;
import uk.gov.gchq.koryphe.util.JsonSerialiser;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MinTest extends BinaryOperatorTest {
    private Comparable state;

    @Before
    public void before() {
        state = null;
    }

    @Test
    public void testAggregateInIntMode() {
        // Given
        final Min min = new Min();

        // When 1
        state = min.apply(1, state);

        // Then 1
        assertTrue(state instanceof Integer);
        assertEquals(1, state);

        // When 2
        state = min.apply(2, state);

        // Then 2
        assertTrue(state instanceof Integer);
        assertEquals(1, state);

        // When 3
        state = min.apply(3, state);

        // Then 3
        assertTrue(state instanceof Integer);
        assertEquals(1, state);
    }

    @Test
    public void testAggregateInLongMode() {
        // Given
        final Min min = new Min();

        // When 1
        state = min.apply(1l, state);

        // Then 1
        assertTrue(state instanceof Long);
        assertEquals(1l, state);

        // When 2
        state = min.apply(2l, state);

        // Then 2
        assertTrue(state instanceof Long);
        assertEquals(1l, state);

        // When 3
        state = min.apply(3l, state);

        // Then 3
        assertTrue(state instanceof Long);
        assertEquals(1l, state);
    }

    @Test
    public void testAggregateInDoubleMode() {
        // Given
        final Min min = new Min();


        // When 1
        state = min.apply(2.1d, state);

        // Then 1
        assertTrue(state instanceof Double);
        assertEquals(2.1d, state);

        // When 2
        state = min.apply(1.1d, state);

        // Then 2
        assertTrue(state instanceof Double);
        assertEquals(1.1d, state);

        // When 3
        state = min.apply(3.1d, state);

        // Then 3
        assertTrue(state instanceof Double);
        assertEquals(1.1d, state);
    }

    @Test
    public void testAggregateMixedInput() {
        // Given
        final Min min = new Min();

        // When 1
        state = min.apply(5, state);

        // When 2
        try {
            state = min.apply(2l, state);
            fail();
        } catch (final ClassCastException cce) {
        }

        // When 3
        try {
            state = min.apply(2.1d, state);
            fail();
        } catch (final ClassCastException cce) {
        }

        // Then 3
        assertTrue(state instanceof Integer);
        assertEquals(5, state);
    }

    @Test
    public void shouldJsonSerialiseAndDeserialise() throws IOException {
        // Given
        final Min aggregator = new Min();

        // When 1
        final String json = JsonSerialiser.serialise(aggregator);

        // Then 1
        JsonSerialiser.assertEquals(String.format("{%n" +
                "  \"class\" : \"uk.gov.gchq.koryphe.impl.binaryoperator.Min\"%n" +
                "}"), json);

        // When 2
        final Min deserialisedAggregator = JsonSerialiser.deserialise(json, Min.class);

        // Then 2
        assertNotNull(deserialisedAggregator);
    }

    @Override
    protected Min getInstance() {
        return new Min();
    }

    @Override
    protected Class<Min> getFunctionClass() {
        return Min.class;
    }
}
