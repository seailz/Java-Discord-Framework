/*
 * MIT License
 *
 * Copyright (c) 2022 Negative
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package com.seailz.jdaframework.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * TriConsumer
 * Primarily meant for {@link }.
 *
 * @param <T>  Type
 * @param <U>  Value 1
 * @param <U1> Value 2
 */
@FunctionalInterface
public interface TriConsumer<T, U, U1> {

    void accept(@NotNull T t, @NotNull U u, @NotNull U1 u1);

    default TriConsumer<T, U, U1> andThen(@NotNull TriConsumer<? super T, ? super U, ? super U1> after) {
        Objects.requireNonNull(after);

        return (l, r, r1) -> {
            accept(l, r, r1);
            after.accept(l, r, r1);
        };
    }
}
