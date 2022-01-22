package enumtype.annotations;

public class ExceptionExample {
    @ExceptionTest(ArithmeticException.class)
    public static void itShouldBeSuccess() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void itShouldBeFailedForAnotherException() {
        int[] a = new int [0];
        a[3] = 5;
    }

    @ExceptionTest(Exception.class)
    public static void itShouldBeFailedForNoException() {

    }
}
