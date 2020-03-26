# Bucket Compliance Checker

This checker enforces the rules for HIPAA compliance listed by this page: 
https://www.dashsdk.com/docs/aws/hipaa/amazon-s3/ when creating Amazon Web Servies
S3 buckets using the [AWS CDK](https://aws.amazon.com/cdk/) for Java.

In particular, it enforces that:
* new buckets use best practices that ensure they are not and cannot become world-readable,
* new buckets are encrypted, and
* new buckets are versioned, so that data will not be lost if overwritten.

These rules are specified in stub files in the `stubs` folder.

The checker conservatively over-approximates the run-time behavior of
the program being checked. If it does not issue an error, then the program
never configures a bucket without following the rules above. It may
issue false positive warnings, however.

This checker combines annotations from two other checkers: the
[Constant Value
Checker](https://checkerframework.org/manual/#constant-value-checker)
of the Checker Framework and the [Object Construction
Checker](https://github.com/kelloggm/object-construction-checker). Refer
to the documentation of those checkers for the meanings of annotations
and error messages.

## How to run the checker

First, publish the checker to your local Maven repository by running
`./gradlew publishToMavenLocal` in this repository.

Then, if you use Gradle, add the following to the `build.gradle` file in
the project you wish to type-check (using Maven is similar):

```
repositories {
    mavenLocal()
    mavenCentral()
}
dependencies {
    annotationProcessor 'org.checkerframework:bucketcompliance-checker:0.1-SNAPSHOT'
    compileOnly 'org.checkerframework:checker-qual:3.1.1'
    compileOnly 'net.sridharan.objectconstruction:object-construction-qual:0.1.7'
}
```

Now, when you build your project, the Bucket Compliance Checker will also run.


## How to specify your code

At compile time, the Bucket ComplianceChecker estimates what values the program
may compute at run time.  It issues a warning if the program may create a non-compliant bucket.
It works via a technique called pluggable typechecking.

You may need to specify the contracts of methods and fields in your
code -- that is, their requirements and their guarantees. You can
specify your code using annotations from the two checkers on which
this checker is built: the [Constant Value
Checker](https://checkerframework.org/manual/#constant-value-checker)
of the Checker Framework and the [Object Construction
Checker](https://github.com/kelloggm/object-construction-checker). Refer
to the documentation of those checkers for the meaning of annotations.

## How to build the checker

Run these commands from the top-level directory.

`./gradlew build`: build the checker

`./gradlew publishToMavenLocal`: publish the checker to your local Maven repository.
This is useful for testing before you publish it elsewhere, such as to Maven Central.


## More information

The Bucket Compliance Checker is built upon the Checker Framework.  Please see
the [Checker Framework Manual](https://checkerframework.org/manual/) for
more information about using pluggable type-checkers, including this one.
