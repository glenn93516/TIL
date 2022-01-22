package enumtype.annotations;

public class Example {
    @MyTest
    public static void itShouldSuccess() {

    }

    @MyTest
    public static void itShouldBeFailed() {
        throw new RuntimeException("failed");
    }

    @MyTest
    public void itShouldBeFailedForNoneStatic() {

    }

    public static void itShouldBeIgnored() {

    }
}
