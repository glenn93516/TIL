package enumtype.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationMain {
    public static void main(String[] args) throws Exception {
        testBasicAnnotation();
        testParameterAnnotation();
    }

    static void testBasicAnnotation() throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("enumtype.annotations.Example");

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    System.out.println(method + " 실패 : " + cause);
                } catch (Exception e) {
                    System.out.println("잘못 사용된 @MyTest: " + method);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }

    static void testParameterAnnotation() throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("enumtype.annotations.ExceptionExample");

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외 던지지 않음%n", method);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    Class<? extends Throwable> type = method.getAnnotation(ExceptionTest.class).value();
                    if (type.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.printf("테스트 %s 실패: 기대한 예외 %s, 실제 예외 %s%n", method, type.getName(), cause);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용된 @ExceptionTest: " + method);
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d%n", passed, tests - passed);
    }
}
