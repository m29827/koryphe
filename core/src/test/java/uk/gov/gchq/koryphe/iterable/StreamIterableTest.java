/*
 * Copyright 2019-2020 Crown Copyright
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

package uk.gov.gchq.koryphe.iterable;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StreamIterableTest {

    @Test
    public void shouldDelegateIteratorToIterable() {
        // Given
        final Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);
        final Stream<Object> stream = mock(Stream.class);
        given(streamSupplier.get()).willReturn(stream);
        final StreamIterable<Object> wrappedIterable = new StreamIterable<>(streamSupplier);
        final Iterator<Object> iterator = mock(Iterator.class);
        given(stream.iterator()).willReturn(iterator);

        // When
        final CloseableIterator<Object> result = wrappedIterable.iterator();

        // Then - call has next and check it was called on the mock.
        result.hasNext();
        verify(iterator).hasNext();
    }
}
