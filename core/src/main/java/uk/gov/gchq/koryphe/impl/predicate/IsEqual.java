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

package uk.gov.gchq.koryphe.impl.predicate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import uk.gov.gchq.koryphe.Since;
import uk.gov.gchq.koryphe.Summary;
import uk.gov.gchq.koryphe.predicate.KoryphePredicate;

/**
 * An <code>IsEqual</code> is a {@link java.util.function.Predicate} that checks that the input is
 * equal to a control value.
 */
@Since("1.0.0")
@Summary("Checks if an input is equal to a provided value")
public class IsEqual extends KoryphePredicate<Object> {
    private Object controlValue;

    public IsEqual() {
        // Required for serialisation
    }

    public IsEqual(final Object controlValue) {
        this.controlValue = controlValue;
    }

    @JsonProperty("value")
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    public Object getControlValue() {
        return controlValue;
    }

    public void setControlValue(final Object controlValue) {
        this.controlValue = controlValue;
    }

    @Override
    public boolean test(final Object input) {
        if (null == controlValue) {
            return null == input;
        }

        return controlValue.equals(input);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !getClass().equals(obj.getClass())) {
            return false;
        }

        final IsEqual isEqual = (IsEqual) obj;
        return new EqualsBuilder()
                .append(controlValue, isEqual.controlValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(controlValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("controlValue", controlValue)
                .toString();
    }
}
