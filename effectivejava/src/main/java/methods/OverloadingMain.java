package methods;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class OverloadingMain {
    // 의도 : 매개변수로 받는 컬렉션 타입에 따라 다른 문자열을 반환해주자
    static String classify(Set<?> set) {
        return "set";
    }

    static String classify(List<?> list) {
        return "list";
    }

    static String classify(Collection<?> collection) {
        return "else";
    }

    public static void main(String[] args) {
        List<Collection> collections = List.of(
                new HashSet<String>(),
                new ArrayList<Integer>(),
                new ConcurrentHashMap<String, String>().values());

        // 컴파일 타임에 Collection이기 때문에 전부 else만 출력됨
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
            // 런타임 클래스를 출력해보면 Collection이 아다
            System.out.println(c.getClass());
        }
    }
}
