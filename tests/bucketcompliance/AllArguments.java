// checks all combinations of the required parameters

import software.amazon.awscdk.core.*;
import software.amazon.awscdk.services.s3.BucketAccessControl;
import software.amazon.awscdk.services.s3.BlockPublicAccess;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.ec2.*;

class AllArguments extends Stack {

    public AllArguments(final Construct scope, final String name) {
        super(scope, name);

        Bucket b0 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: method.invocation.invalid
                        .build();

        // just versioned

        Bucket b1 =
                Bucket.Builder.create(this, "MyBucket")
                        .versioned(true)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b2 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .versioned(false)
                        // :: error: method.invocation.invalid
                        .build();

        // just encryption

        Bucket b3 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .encryption(BucketEncryption.UNENCRYPTED)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b3_1 =
                Bucket.Builder.create(this, "MyBucket")
                        .encryption(BucketEncryption.KMS)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b3_2 =
                Bucket.Builder.create(this, "MyBucket")
                        .encryption(BucketEncryption.KMS_MANAGED)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b3_3 =
                Bucket.Builder.create(this, "MyBucket")
                        .encryption(BucketEncryption.S3_MANAGED)
                        // :: error: method.invocation.invalid
                        .build();

        // just access control

        Bucket b4 =
                Bucket.Builder.create(this, "MyBucket")
                        .accessControl(BucketAccessControl.PRIVATE)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b5 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .accessControl(BucketAccessControl.AUTHENTICATED_READ)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b6 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .accessControl(BucketAccessControl.AWS_EXEC_READ)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b7 =
                Bucket.Builder.create(this, "MyBucket")
                        .accessControl(BucketAccessControl.BUCKET_OWNER_FULL_CONTROL)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b8 =
                Bucket.Builder.create(this, "MyBucket")
                        .accessControl(BucketAccessControl.BUCKET_OWNER_READ)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b9 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .accessControl(BucketAccessControl.LOG_DELIVERY_WRITE)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b10 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .accessControl(BucketAccessControl.PUBLIC_READ)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b11 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .accessControl(BucketAccessControl.PUBLIC_READ_WRITE)
                        // :: error: method.invocation.invalid
                        .build();

        // block public access

        Bucket b12 =
                Bucket.Builder.create(this, "MyBucket")
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b13 =
                Bucket.Builder.create(this, "MyBucket")
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ACLS)
                        // :: error: method.invocation.invalid
                        .build();

        // public read access

        Bucket b14 =
                Bucket.Builder.create(this, "MyBucket")
                        .publicReadAccess(false)
                        // :: error: method.invocation.invalid
                        .build();

        Bucket b15 =
                Bucket.Builder.create(this, "MyBucket")
                        // :: error: argument.type.incompatible
                        .publicReadAccess(true)
                        // :: error: method.invocation.invalid
                        .build();
    }
}