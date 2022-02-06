package methods;

import java.util.List;
import java.util.Optional;

public class OptionalMain {

    static String findLongestString_notOptional(List<String> strings) {
        if (strings.isEmpty()) {
            // exception을 던질 경우 이게 진짜 예외 상황인지, stackTrace 비용은 적지 않은지 생각해야함
            throw new IllegalArgumentException("컬렉션이 비어있으면 예외");
//            return null; // 만약 null을 반환하면 클라이언트에서 추가적인 처리 필요
        }
        int maxLength = 0;
        String max = null;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
                max = string;
            }
        }
        return max;
    }

    static Optional<String> findLongestString_withOptional(List<String> strings) {
        // 이렇게 아예 빈 옵셔널을 반환하거나
        if (strings.isEmpty()) {
            return Optional.empty();
        }
        int maxLength = 0;
        String max = null;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
                max = string;
            }
        }
        // of에는 null을 넣으면 안됨
//        return Optional.of(max);
        // ofNullable로 하면 null인 경우 Optional.empty() 반환
        return Optional.ofNullable(max);
    }

    public static void main(String[] args) {
        List<String> strings = List.of("a", "bc", "cde");
        // 이렇게 예외처리를 하거나, null에 대한 처리를 해줘야 한다
        try {
            String longestString = findLongestString_notOptional(strings);
            System.out.println(longestString);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        // 옵셔널로 받는 경우 별도 처리를 해줘야 한다
        // 반환값이 없는 경우 기본값 설정
        String longestString = findLongestString_withOptional(strings).orElse("기본값");
        // 원하는 예외를 던짐
        String longestString2 = findLongestString_withOptional(strings).orElseThrow(RuntimeException::new);
    }
}
