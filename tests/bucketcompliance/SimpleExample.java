// a simple good/bad smoke test

import software.amazon.awscdk.core.*;
import software.amazon.awscdk.services.s3.BucketAccessControl;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.ec2.*;

class SimpleExample extends Stack {

    public SimpleExample(final Construct scope, final String name) {
        super(scope, name);

        // make a good bucket
        Bucket bucket =
                Bucket.Builder.create(this, "MyBucket")
                        .versioned(true)
                        .encryption(BucketEncryption.KMS_MANAGED)
                        .accessControl(BucketAccessControl.PRIVATE)
                        .build();

        // make a bad bucket

        // :: error: noncompliant.bucket
        Bucket bucket2 =
                Bucket.Builder.create(this, "MyBucket")
                        //.versioned(true)
                        //.encryption(BucketEncryption.KMS_MANAGED)
                        //.accessControl(BucketAccessControl.PRIVATE)
                        .build();
    }
}