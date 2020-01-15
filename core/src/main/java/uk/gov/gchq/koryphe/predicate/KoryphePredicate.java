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

package uk.gov.gchq.koryphe.predicate;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.function.Predicate;

/**
 * Abstract superclass provided for convenience.
 *
 * @param <I> Input type
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
public abstract class KoryphePredicate<I> implements Predicate<I> {
    @SuppressFBWarnings(value = "BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS", justification = "the method classEquals does the check")
    @Override
    public boolean equals(final Object obj) {
        return this == obj || (null != obj && getClass().equals(obj.getClass()));
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
