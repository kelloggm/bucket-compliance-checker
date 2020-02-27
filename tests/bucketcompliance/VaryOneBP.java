// checks all combinations of the required parameters

import software.amazon.awscdk.core.*;
import software.amazon.awscdk.services.s3.BucketAccessControl;
import software.amazon.awscdk.services.s3.BlockPublicAccess;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.ec2.*;

class VaryOneBP extends Stack {

    public VaryOneBP(final Construct scope, final String name) {
        super(scope, name);

        // vary versioned

        Bucket b1_1 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .versioned(true)
                        .encryption(BucketEncryption.KMS)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        .build());

        Bucket b1_2 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        // .versioned(true)
                        .encryption(BucketEncryption.KMS)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        // :: error: method.invocation.invalid
                        .build());

        // vary encryption


        Bucket b2_1 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .encryption(BucketEncryption.KMS)
                        .versioned(true)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        .build());

        Bucket b2_2 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .encryption(BucketEncryption.KMS_MANAGED)
                        .versioned(true)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        .build());

        Bucket b2_3 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        .build());

        Bucket b2_4 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        // .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        // :: error: method.invocation.invalid
                        .build());

        // vary access control

        Bucket b3_1 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .accessControl(BucketAccessControl.PRIVATE)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());


        Bucket b3_2 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .accessControl(BucketAccessControl.BUCKET_OWNER_FULL_CONTROL)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());

        Bucket b3_3 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .accessControl(BucketAccessControl.BUCKET_OWNER_READ)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());

        Bucket b3_4 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        // .accessControl(BucketAccessControl.BUCKET_OWNER_READ)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        // :: error: method.invocation.invalid
                        .build());

        // vary block public access

        Bucket b4_1 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ALL)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());

        Bucket b4_2 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .blockPublicAccess(BlockPublicAccess.BLOCK_ACLS)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());

        Bucket b4_3 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        // .blockPublicAccess(BlockPublicAccess.BLOCK_ACLS)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        // :: error: method.invocation.invalid
                        .build());

        // vary public read access

        Bucket b5_1 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        .publicReadAccess(false)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        .build());

        Bucket b5_2 =
                new Bucket(this, "MyBucket", BucketProps.builder()
                        // .publicReadAccess(false)
                        .encryption(BucketEncryption.S3_MANAGED)
                        .versioned(true)
                        // :: error: method.invocation.invalid
                        .build());

    }
}