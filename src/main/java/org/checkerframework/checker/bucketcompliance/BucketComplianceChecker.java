package org.checkerframework.checker.bucketcompliance;

import org.checkerframework.checker.objectconstruction.ObjectConstructionChecker;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.value.ValueChecker;

import java.util.LinkedHashSet;

/**
 * This is the entry point for pluggable type-checking.
 */
public class BucketComplianceChecker extends BaseTypeChecker {

    @Override
    protected LinkedHashSet<Class<? extends BaseTypeChecker>> getImmediateSubcheckerClasses() {
        LinkedHashSet<Class<? extends BaseTypeChecker>> checkers =
                super.getImmediateSubcheckerClasses();
        checkers.add(ObjectConstructionChecker.class);
        checkers.add(ValueChecker.class);
        return checkers;
    }
}
