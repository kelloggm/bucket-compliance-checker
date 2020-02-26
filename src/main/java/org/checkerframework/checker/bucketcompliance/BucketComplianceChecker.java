package org.checkerframework.checker.bucketcompliance;

import org.checkerframework.checker.objectconstruction.ObjectConstructionChecker;
import org.checkerframework.com.google.common.collect.ImmutableList;
import org.checkerframework.common.value.ValueChecker;
import org.checkerframework.framework.source.AggregateChecker;
import org.checkerframework.framework.source.SourceChecker;

import java.util.Collection;

/**
 * This is the entry point for pluggable type-checking.
 */
public class BucketComplianceChecker extends AggregateChecker {
    /**
     * Returns the list of supported checkers to be run together. Subclasses need to override this
     * method.
     */
    @Override
    protected Collection<Class<? extends SourceChecker>> getSupportedCheckers() {
        return ImmutableList.of(ObjectConstructionChecker.class, ValueChecker.class);
    }
}
