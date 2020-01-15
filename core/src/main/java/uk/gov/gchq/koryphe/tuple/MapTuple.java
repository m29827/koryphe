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

package uk.gov.gchq.koryphe.tuple;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A <code>MapTuple</code> is an implementation of {@link Tuple} backed by a {@link java.util.Map}.
 */
public class MapTuple<R> implements Tuple<R> {
    private Map<R, Object> values;

    /**
     * Create a <code>MapTuple</code> backed by the given {@link java.util.Map}.
     *
     * @param values Backing {@link java.util.Map}.
     */
    public MapTuple(final Map<R, Object> values) {
        this.values = values;
    }

    /**
     * Create a <code>MapTuple</code> backed by a new {@link java.util.HashMap}.
     */
    public MapTuple() {
        this.values = new HashMap<>();
    }

    @Override
    public void put(final R reference, final Object value) {
        values.put(reference, value);
    }

    @Override
    public Object get(final R reference) {
        if (THIS.equals(reference)) {
            return this;
        }
        return values.get(reference);
    }

    @Override
    public Iterable<Object> values() {
        return values.values();
    }

    @Override
    public Iterator<Object> iterator() {
        return values().iterator();
    }

    public Map<R, Object> getValues() {
        return values;
    }

    public void setValues(final Map<R, Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("values", values)
                .build();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MapTuple<?> mapTuple = (MapTuple<?>) o;

        return new EqualsBuilder()
                .append(values, mapTuple.values)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(11, 31)
                .append(values)
                .toHashCode();
    }
}
