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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import uk.gov.gchq.koryphe.Since;
import uk.gov.gchq.koryphe.Summary;
import uk.gov.gchq.koryphe.predicate.KoryphePredicate;

/**
 * An <code>AgeOff</code> is a {@link java.util.function.Predicate} that ages off old data based on a provided age of time in milliseconds.
 */
@Since("1.0.0")
@Summary("Checks if a timestamp is recent based on a provided age off time")
public class AgeOff extends KoryphePredicate<Long> {
    public static final long HOURS_TO_MILLISECONDS = 60L * 60L * 1000L;
    public static final long DAYS_TO_MILLISECONDS = 24L * HOURS_TO_MILLISECONDS;

    /**
     * The default age of time (1 year) in milliseconds.
     */
    public static final long AGE_OFF_TIME_DEFAULT = 365L * DAYS_TO_MILLISECONDS;

    private long ageOffTime = AGE_OFF_TIME_DEFAULT;

    // Default constructor for serialisation
    public AgeOff() {
    }

    public AgeOff(final long ageOffTime) {
        this.ageOffTime = ageOffTime;
    }

    @Override
    public boolean test(final Long input) {
        return null != input && (System.currentTimeMillis() - input) < ageOffTime;
    }

    public long getAgeOffTime() {
        return ageOffTime;
    }

    public void setAgeOffTime(final long ageOffTime) {
        this.ageOffTime = ageOffTime;
    }

    public void setAgeOffDays(final int ageOfDays) {
        setAgeOffTime(DAYS_TO_MILLISECONDS * ageOfDays);
    }

    public void setAgeOffHours(final long ageOfHours) {
        setAgeOffTime(HOURS_TO_MILLISECONDS * ageOfHours);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !getClass().equals(obj.getClass())) {
            return false;
        }

        final AgeOff otherPredicate = (AgeOff) obj;
        return new EqualsBuilder()
                .append(ageOffTime, otherPredicate.ageOffTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(ageOffTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ageOffTime", ageOffTime)
                .toString();
    }
}
