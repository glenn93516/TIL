package lambdas;

import java.util.HashMap;
import java.util.Map;

public class MethodReferenceMain {
    public static void main(String[] args) {
        simpleMethodReferenceCase();
        lambdaBetterCase();
    }

    // 메서드 참조가 람다보다 더 간결한 경우
    private static void simpleMethodReferenceCase() {
        Map<String, Integer> map = new HashMap<>();
        // lambda 사용 시
        map.merge("key name", 1, (count, incr) -> count + incr);

        // method reference - 1
        map.merge("key name", 1, Integer::sum);
        // method reference - 2 (using readable method name)
        map.merge("key", 1, MethodReferenceMain::readableMethodName);
    }

    // 람다가 더 유용한 경우
    private static void lambdaBetterCase() {
        Map<String, Integer> map = new HashMap<>();
        // 클래스 명과 메서드 이름이 너무 길거나 가독성이 떨어지는 경우
        map.merge("key", 1, MethodReferenceMain::tooLongMethodNameForMethodReference);
        // 매개변수 명이 가독성을 좋게 해주는 경우
        // orderHandler.modify((orderId, modifiedOrder) -> orderHandler.modify(orderId, modifiedOrder));
    }

    private static int readableMethodName(int count, int incr) {
        return incr;
    }

    private static int tooLongMethodNameForMethodReference(int count, int incr) {
        return incr;
    }
}
