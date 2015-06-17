package com.github.gchudnov.bspec;

/**
 * OR-specification
 */
public class OrSpecification<T> extends CompositeSpecification<T> {
    private Specification<T> mLhs;
    private Specification<T> mRhs;

    /**
     * Create a new OR specification based on two other spec.
     *
     * @param lhs Specification one.
     * @param rhs Specification two.
     */
    public OrSpecification(final Specification<T> lhs, final Specification<T> rhs) {
        this.mLhs = lhs;
        this.mRhs = rhs;
    }

    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return mLhs.isSatisfiedBy(candidate) || mRhs.isSatisfiedBy(candidate);
    }

}
