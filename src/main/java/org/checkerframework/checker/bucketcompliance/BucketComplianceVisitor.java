package org.checkerframework.checker.bucketcompliance;

import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.type.TypeHierarchy;

public class BucketComplianceVisitor extends BaseTypeVisitor<BucketComplianceAnnotatedTypeFactory> {
    /**
     * @param checker the type-checker associated with this visitor (for callbacks to {@link
     *                TypeHierarchy#isSubtype})
     */
    public BucketComplianceVisitor(BaseTypeChecker checker) {
        super(checker);
    }
}
