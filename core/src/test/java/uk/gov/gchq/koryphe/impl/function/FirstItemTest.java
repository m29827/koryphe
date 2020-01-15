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
package uk.gov.gchq.koryphe.impl.function;

import org.junit.Test;

import uk.gov.gchq.koryphe.function.FunctionTest;
import uk.gov.gchq.koryphe.util.JsonSerialiser;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FirstItemTest extends FunctionTest {
    @Override
    protected Function getInstance() {
        return new FirstItem();
    }

    @Override
    protected Class<? extends Function> getFunctionClass() {
        return FirstItem.class;
    }

    @Override
    public void shouldJsonSerialiseAndDeserialise() throws IOException {
        // Given
        final FirstItem function = new FirstItem();

        // When
        final String json = JsonSerialiser.serialise(function);

        // Then
        JsonSerialiser.assertEquals(String.format("{%n" +
                "  \"class\" : \"uk.gov.gchq.koryphe.impl.function.FirstItem\"%n" +
                "}"), json);

        // When 2
        final FirstItem deserialised = JsonSerialiser.deserialise(json, FirstItem.class);

        // Then 2
        assertNotNull(deserialised);
    }

    @Test
    public void shouldReturnCorrectValueWithInteger() {
        // Given
        final FirstItem<Integer> function = new FirstItem<>();

        // When
        final Integer result = function.apply(Arrays.asList(1, 2, 3, 4));

        // Then
        assertNotNull(result);
        assertEquals(new Integer(1), result);
    }

    @Test
    public void shouldReturnCorrectValueWithString() {
        // Given
        final FirstItem<String> function = new FirstItem<>();

        // When
        final String result = function.apply(Arrays.asList("these", "are", "test", "strings"));

        // Then
        assertNotNull(result);
        assertEquals("these", result);
    }

    @Test
    public void shouldReturnNullForNullElement() {
        // Given
        final FirstItem<String> function = new FirstItem<>();

        // When
        final String result = function.apply(Arrays.asList(null, "two", "three"));

        // Then
        assertNull(result);
    }

    @Test
    public void shouldThrowErrorForNullInput() {
        // Given
        final FirstItem<String> function = new FirstItem<>();

        // When / Then
        try {
            function.apply(null);
            fail("Exception expected");
        } catch (final IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Input cannot be null"));
        }
    }
}
