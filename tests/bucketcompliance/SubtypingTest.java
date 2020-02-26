import org.checkerframework.checker.bucketcompliance.qual.*;

// Test basic subtyping relationships for the Bucket Compliance Checker.
class SubtypeTest {
    void allSubtypingRelationships(@BucketComplianceUnknown int x, @BucketComplianceBottom int y) {
        @BucketComplianceUnknown int a = x;
        @BucketComplianceUnknown int b = y;
        // :: error: assignment.type.incompatible
        @BucketComplianceBottom int c = x; // expected error on this line
        @BucketComplianceBottom int d = y;
    }
}
