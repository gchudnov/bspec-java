package com.github.gchudnov.bspec;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Composite
 */
public class CompositeSpecificationTest {

    class TrueSpecification extends CompositeSpecification<Object> {
        @Override
        public boolean isSatisfiedBy(Object candidate) {
            return true;
        }
    }

    class FalseSpecification extends CompositeSpecification<Object> {
        @Override
        public boolean isSatisfiedBy(Object candidate) {
            return false;
        }
    }

    Specification<Object> trueSpec = new TrueSpecification();
    Specification<Object> falseSpec = new FalseSpecification();

    @Test
    public void complexSpec() {
        Specification<Object> spec = trueSpec.or(falseSpec).and(trueSpec).not();
        assertFalse(spec.isSatisfiedBy(new Object()));
    }
}
