package me.zaksen.util

import java.util.*

fun interface TriConsumer<A, B, C> {
    fun accept(a: A, b: B, c: C)

    fun andThen(after: TriConsumer<in A, in B, in C>): TriConsumer<A, B, C> {
        Objects.requireNonNull(after)
        return TriConsumer { a: A, b: B, c: C ->
            accept(a, b, c)
            after.accept(a, b, c)
        }
    }
}
