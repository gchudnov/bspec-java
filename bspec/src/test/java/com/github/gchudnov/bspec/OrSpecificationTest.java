package com.github.gchudnov.bspec;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * OR
 */
public class OrSpecificationTest {

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
    public void trueOrTrueIsTrue() {
        Specification<Object> spec = trueSpec.or(trueSpec);
        assertTrue(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void trueOrFalseIsTrue() {
        Specification<Object> spec = trueSpec.or(falseSpec);
        assertTrue(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void falseOrTrueIsTrue() {
        Specification<Object> spec = falseSpec.or(trueSpec);
        assertTrue(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void falseOrFalseIsFalse() {
        Specification<Object> spec = falseSpec.or(falseSpec);
        assertFalse(spec.isSatisfiedBy(new Object()));
    }
}
