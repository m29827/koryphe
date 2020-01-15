/*
 * Copyright 2019-2020 Crown Copyright
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

import com.google.common.collect.Lists;
import org.junit.Test;

import uk.gov.gchq.koryphe.function.FunctionTest;
import uk.gov.gchq.koryphe.util.JsonSerialiser;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvToMapsTest extends FunctionTest {
    @Override
    protected Function getInstance() {
        return new CsvToMaps();
    }

    @Override
    protected Class<? extends Function> getFunctionClass() {
        return CsvToMaps.class;
    }

    @Override
    public void shouldJsonSerialiseAndDeserialise() throws IOException {
        // Given
        final CsvToMaps function = new CsvToMaps()
                .header("header1", "header2", "header3")
                .delimiter('|')
                .firstRow(2)
                .quoteChar('\'')
                .quoted();

        // When
        final String json = JsonSerialiser.serialise(function);

        // Then
        JsonSerialiser.assertEquals(String.format("{%n" +
                "   \"class\" : \"uk.gov.gchq.koryphe.impl.function.CsvToMaps\",%n" +
                "   \"header\" : [\"header1\", \"header2\", \"header3\"]," +
                "   \"delimiter\" : \"|\"," +
                "   \"firstRow\" : 2," +
                "   \"quoteChar\" : \"'\"," +
                "   \"quoted\" : true" +
                "}"), json);
    }

    @Test
    public void shouldParseCsvWithHeader() {
        // Given
        final CsvToMaps function = new CsvToMaps().header("header1", "header2", "header3").firstRow(1);
        String input = "header1,header2,header3\nvalue1,value2,value3";

        // When
        Iterable<Map<String, Object>> result = function.apply(input);

        // Then
        HashMap<Object, Object> map = new HashMap<>();
        map.put("header1", "value1");
        map.put("header2", "value2");
        map.put("header3", "value3");
        assertEquals(Collections.singletonList(map), Lists.newArrayList(result));
    }

    @Test
    public void shouldReturnNullForNullInput() {
        // Given
        final CsvToMaps function = new CsvToMaps();
        final String input = null;

        // When
        Object result = function.apply(input);

        // Then
        assertNull(result);
    }
}
