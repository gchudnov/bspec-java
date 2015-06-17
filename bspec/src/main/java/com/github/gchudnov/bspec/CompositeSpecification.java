package com.github.gchudnov.bspec;

/**
 * Composite Specification
 */
public abstract class CompositeSpecification<T> implements Specification<T> {

    @Override
    public abstract boolean isSatisfiedBy(T candidate);

    @Override
    public Specification<T> and(Specification<T> other) {
        return new AndSpecification<T>(this, other);
    }

    @Override
    public Specification<T> or(Specification<T> other) {
        return new OrSpecification<T>(this, other);
    }

    @Override
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }
}
