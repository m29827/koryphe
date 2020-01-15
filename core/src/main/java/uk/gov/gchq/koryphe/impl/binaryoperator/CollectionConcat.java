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

import java.util.Collection;

/**
 * A <code>CollectionConcat</code> is a {@link KorypheBinaryOperator} that concatenates
 * {@link java.util.Collection}s together.
 */
@Since("1.0.0")
@Summary("Concatenates collections together.")
public class CollectionConcat<T> extends KorypheBinaryOperator<Collection<T>> {
    @Override
    protected Collection<T> _apply(final Collection<T> a, final Collection<T> b) {
        a.addAll(b);
        return a;
    }
}
