package com.github.gchudnov.bspec;

/**
 * AND-specification
 */
public class AndSpecification<T> extends CompositeSpecification<T> {
    private Specification<T> mLhs;
    private Specification<T> mRhs;

    /**
     * Create a new AND specification based on two other specs
     *
     * @param lhs Specification one.
     * @param rhs Specification two.
     */
    public AndSpecification(final Specification<T> lhs, final Specification<T> rhs) {
        this.mLhs = lhs;
        this.mRhs = rhs;
    }

    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return mLhs.isSatisfiedBy(candidate) && mRhs.isSatisfiedBy(candidate);
    }
}
