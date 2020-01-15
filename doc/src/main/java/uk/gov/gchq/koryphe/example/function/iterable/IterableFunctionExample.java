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
package uk.gov.gchq.koryphe.example.function.iterable;

import uk.gov.gchq.koryphe.impl.function.IterableFunction;
import uk.gov.gchq.koryphe.impl.function.MultiplyBy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class IterableFunctionExample extends KorypheIterableFunctionExample<Iterable<Integer>, Iterable<Integer>> {
    @Override
    public Function<Iterable<Integer>, Iterable<Integer>> getFunction() {
        return new IterableFunction<>(new MultiplyBy(2));
    }

    @Override
    public Stream<Iterable<Integer>> getInput() {
        final List<Integer> aa = Arrays.asList(2, 3, 5);
        final List<Integer> ab = Arrays.asList(7, 11, 13);
        final List<Integer> ac = Arrays.asList(17, 19, 23);

        return Stream.of(aa, ab, ac);
    }
}
