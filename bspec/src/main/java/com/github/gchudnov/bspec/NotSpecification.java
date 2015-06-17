package com.github.gchudnov.bspec;

/**
 * NOT-specification
 */
public class NotSpecification<T> extends CompositeSpecification<T> {

    private Specification<T> mOther;

    /**
     * Create a new NOT specification based on another spec.
     * @param other Specification instance to not.
     */
    public NotSpecification(final Specification<T> other) {
        this.mOther = other;
    }

    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return !mOther.isSatisfiedBy(candidate);
    }

}
