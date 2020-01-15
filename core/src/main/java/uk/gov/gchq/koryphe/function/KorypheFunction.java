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

package uk.gov.gchq.koryphe.function;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.function.Function;

/**
 * Abstract superclass provided for convenience.
 *
 * @param <I> Input type
 * @param <O> Output type
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
public abstract class KorypheFunction<I, O> implements Function<I, O> {
    @Override
    public boolean equals(final Object obj) {
        return this == obj || classEquals(obj);
    }

    protected boolean classEquals(final Object other) {
        return null != other && getClass().equals(other.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
