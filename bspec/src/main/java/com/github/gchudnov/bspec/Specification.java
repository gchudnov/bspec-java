package com.github.gchudnov.bspec;

/**
 * Specification interface
 *
 * http://en.wikipedia.org/wiki/Specification_pattern
 */
public interface Specification<T> {

    /**
     * Check if obj is satisfied by the specification.
     * @param candidate Object to test
     * @return TRUE if the provided object satisfied specification
     */
    boolean isSatisfiedBy(T candidate);

    /**
     * Create a new specification that is the AND operation of this specification and another specification.
     * @param other Specification to AND.
     * @return A new specification.
     */
    Specification<T> and(Specification<T> other);

    /**
     * Create a new specification that is the OR operation of this specification and another specification.
     * @param other Specification to OR.
     * @return A new specification.
     */
    Specification<T> or(Specification<T> other);

    /**
     * Create a new specification that is the NOT operation of this specification.
     * @return A new specification.
     */
    Specification<T> not();
}
