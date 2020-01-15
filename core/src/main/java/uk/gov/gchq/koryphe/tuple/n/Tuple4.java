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

package uk.gov.gchq.koryphe.tuple.n;

/**
 * An {@link TupleN} containing 4 entries.
 *
 * @param <A> Type of the entry at index 0.
 * @param <B> Type of the entry at index 1.
 * @param <C> Type of the entry at index 2.
 * @param <D> Type of the entry at index 3.
 */
public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    public Tuple4() {
        super(4);
    }

    public Tuple4(final A a, final B b, final C c, final D d) {
        this();
        put0(a);
        put1(b);
        put2(c);
        put3(d);
    }

    /**
     * Pass-through constructor for larger tuple sizes.
     *
     * @param size Tuple size.
     */
    protected Tuple4(final int size) {
        super(size);
        if (size < 4) {
            throw new IllegalArgumentException("Invalid size");
        }
    }

    public D get3() {
        return (D) get(3);
    }

    public void put3(final D d) {
        put(3, d);
    }
}
