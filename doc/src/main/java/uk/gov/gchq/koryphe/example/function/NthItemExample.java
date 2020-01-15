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
package uk.gov.gchq.koryphe.example.function;

import uk.gov.gchq.koryphe.example.KorypheFunctionExample;
import uk.gov.gchq.koryphe.impl.function.NthItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class NthItemExample extends KorypheFunctionExample<Iterable<Integer>, Integer> {
    @Override
    public Function<Iterable<Integer>, Integer> getFunction() {
        return new NthItem<>(2);
    }

    @Override
    public Stream<Iterable<Integer>> getInput() {
        final List<Integer> first = Arrays.asList(3, 1, 4, 1);
        final List<Integer> second = Arrays.asList(5, 9, 2, 6);
        final List<Integer> third = Arrays.asList(5, 3, 5, 8);

        return Stream.of(first, second, third);
    }
}
