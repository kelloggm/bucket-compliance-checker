package org.checkerframework.checker.bucketcompliance;

import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;

public class BucketComplianceAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {
    public BucketComplianceAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker);
        this.postInit();
    }
}
