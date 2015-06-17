package com.github.gchudnov.bspec;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * AND
 */
public class AndSpecificationTest {

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
    public void trueAndTrueIsTrue() {
        Specification<Object> spec = trueSpec.and(trueSpec);
        assertTrue(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void trueAndFalseIsFalse() {
        Specification<Object> spec = trueSpec.and(falseSpec);
        assertFalse(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void falseAndTrueIsFalse() {
        Specification<Object> spec = falseSpec.and(trueSpec);
        assertFalse(spec.isSatisfiedBy(new Object()));
    }

    @Test
    public void falseAndFalseIsFalse() {
        Specification<Object> spec = falseSpec.and(falseSpec);
        assertFalse(spec.isSatisfiedBy(new Object()));
    }
}
