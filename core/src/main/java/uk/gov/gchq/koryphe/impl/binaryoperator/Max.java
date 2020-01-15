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

import uk.gov.gchq.koryphe.Since;
import uk.gov.gchq.koryphe.Summary;
import uk.gov.gchq.koryphe.binaryoperator.KorypheBinaryOperator;

/**
 * A <code>Max</code> is a {@link KorypheBinaryOperator} that takes in
 * {@link Comparable}s and calculates the maximum comparable. It assumes that all the input comparables
 * are compatible and can be compared against each other.
 */
@Since("1.0.0")
@Summary("Calculates the max value")
public class Max extends KorypheBinaryOperator<Comparable> {
    @Override
    protected Comparable _apply(final Comparable a, final Comparable b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}
