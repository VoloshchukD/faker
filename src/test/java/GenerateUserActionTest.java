import junit.framework.TestCase;

public class GenerateUserActionTest extends TestCase {
    private GenerateUserAction generateUserAction = new GenerateUserAction();

    public void testWithMillionUserDataNumber() {
        long time = System.currentTimeMillis();
        String[] args = {"ru_RU", "1000000", "0"};
        Main.main(args);
        System.out.println((System.currentTimeMillis() - time) / 1000 + " s");
    }

    public void testWithThreeAndWithTwoParameters() {
        generateUserAction.run("ru_RU", "1", "0");
        System.out.println();
        generateUserAction.run("ru_RU", "1");
    }

    public void testWithWrongParameters() {
       generateUserAction.run("ru_RU", "-1", "0");
    }

    public void testTenUserDataGeneration() {
        generateUserAction.run("ru_RU", "10", "0");
        System.out.println();
        generateUserAction.run("by_BY", "10", "0");
        System.out.println();
        generateUserAction.run("en_US", "10", "0");
    }

    public void testWithThreeAndFiveThousandErrorsInAStringGeneration() {
        generateUserAction.run("ru_RU", "1", "3");
        generateUserAction.run("ru_RU", "1", "5000");
    }

    public void testWithZeroErrorsInAStringGeneration() {
        generateUserAction.run("ru_RU", "1", "0");
    }

}