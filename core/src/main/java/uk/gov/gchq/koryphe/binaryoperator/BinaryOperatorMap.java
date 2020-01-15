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

package uk.gov.gchq.koryphe.binaryoperator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import uk.gov.gchq.koryphe.Since;
import uk.gov.gchq.koryphe.Summary;

import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Applies a {@link BinaryOperator} to the values of an input {@link Map}, combining values with matching keys.
 *
 * @param <K> Type of key
 * @param <T> Input/output type
 */
@Since("1.0.0")
@Summary("Merges 2 maps by applying a binary operator to each of the values")
public class BinaryOperatorMap<K, T> extends KorypheBinaryOperator<Map<K, T>> {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
    private BinaryOperator<? super T> binaryOperator;

    /**
     * Default - for serialisation.
     */
    public BinaryOperatorMap() {
    }

    public BinaryOperatorMap(final BinaryOperator<? super T> binaryOperator) {
        setBinaryOperator(binaryOperator);
    }

    public void setBinaryOperator(final BinaryOperator<? super T> binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    public BinaryOperator<? super T> getBinaryOperator() {
        return binaryOperator;
    }

    /**
     * Iterate through the values of an input map, folding them into the state map using the wrapped
     * <code>BinaryOperator</code>.
     *
     * @param state Current state map.
     * @param input New input map.
     * @return New state map.
     */
    @Override
    public Map<K, T> _apply(final Map<K, T> state, final Map<K, T> input) {
        for (final Map.Entry<K, T> entry : input.entrySet()) {
            final T newValue = (T) binaryOperator.apply(state.get(entry.getKey()), entry.getValue());
            state.put(entry.getKey(), newValue);
        }
        return state;
    }
}
