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
import uk.gov.gchq.koryphe.predicate.KoryphePredicate;

/**
 * An <code>IsFalse</code> is a {@link java.util.function.Predicate} that checks that the input boolean is
 * false.
 */
@Since("1.0.0")
@Summary("Checks if an input is false")
public class IsFalse extends KoryphePredicate<Boolean> {
    @Override
    public boolean test(final Boolean input) {
        return Boolean.FALSE.equals(input);
    }
}
