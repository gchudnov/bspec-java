package com.github.gchudnov.bspec;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * NOT
 */
public class NotSpecificationTest {

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
    public void notTrueIsFalse() {
        Specification<Object> spec = trueSpec.not();
        assertFalse(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void notFalseIsTrue() {
        Specification<Object> spec = falseSpec.not();
        assertTrue(spec.isSatisfiedBy(new Object()));
    }
}
