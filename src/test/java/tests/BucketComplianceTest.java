import java.io.File;
import java.util.List;
import org.checkerframework.checker.bucketcompliance.BucketComplianceChecker;
import org.checkerframework.framework.test.CheckerFrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test runner for tests of the Bucket Compliance Checker.
 *
 * <p>Tests appear as Java files in the {@code tests/bucketcompliance} folder. To add a new test case,
 * create a Java file in that directory. The file contains "// ::" comments to indicate expected
 * errors and warnings; see
 * https://github.com/typetools/checker-framework/blob/master/checker/tests/README .
 */
public class BucketComplianceTest extends CheckerFrameworkPerDirectoryTest {
    public BucketComplianceTest(List<File> testFiles) {
        super(
                testFiles,
                BucketComplianceChecker.class,
                "bucketcompliance",
                "-Anomsgtext",
                "-Astubs=stubs/",
                "-AstubDebug");
        System.out.println("running test");
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[] {"bucketcompliance"};
    }
}
