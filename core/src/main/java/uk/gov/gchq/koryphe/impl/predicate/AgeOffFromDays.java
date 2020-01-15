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

import uk.gov.gchq.koryphe.Since;
import uk.gov.gchq.koryphe.Summary;
import uk.gov.gchq.koryphe.tuple.predicate.KoryphePredicate2;

/**
 * An <code>AgeOffFromDays</code> is a {@link java.util.function.BiPredicate}
 * that ages off old data based on a provided age off time in days.
 */
@Since("1.0.0")
@Summary("Checks if a timestamp is recent based on a provided age off in days")
public class AgeOffFromDays extends KoryphePredicate2<Long, Integer> {
    public static final long DAYS_TO_MILLISECONDS = 24L * 60L * 60L * 1000L;

    @Override
    public boolean test(final Long timestamp, final Integer days) {
        return null != timestamp
                && null != days
                && (System.currentTimeMillis() - (days * DAYS_TO_MILLISECONDS) < timestamp);
    }
}
