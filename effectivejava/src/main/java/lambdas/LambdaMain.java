package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {
        // enum type에 lambda를 활용하면 코드를 더 간단히 관리할 수 있다
        System.out.println(Operation.DIVIDE.apply(3.0, 6.0));
        System.out.println(Operation.PLUS.apply(3.0, 6.0));
        System.out.println(Operation.MINUS.apply(3.0, 6.0));
        System.out.println(Operation.TIMES.apply(3.0, 6.0));

        // 익명 클래스를 활용한 정렬
        List<String> words = List.of("abcd", "abc", "abcdef", "abcde");
        printSortedWordsByAnonymous(words);
        printSortedWordsByLambda(words);
    }

    private static void printSortedWordsByAnonymous(List<String> words) {
        List<String> copiedWords = copyWords(words);
        Collections.sort(copiedWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println(copiedWords);
    }

    private static void printSortedWordsByLambda(List<String> words) {
        List<String> copiedWords = copyWords(words);
        // 방법 1.1 매개변수 타입 명시 안함
        Collections.sort(copiedWords, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 방법 1.2 매개변수 타입 명시
        // 타입 추론으로 생략해도 되지만, 코드 리뷰시 리뷰어가 타입을 확인하기 어렵기 때문에 나는 이 방법을 선호한다
        Collections.sort(copiedWords, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));

        // 방법 2
        Collections.sort(copiedWords, Comparator.comparingInt(String::length));
        // 방법 3
        copiedWords.sort(Comparator.comparingInt(String::length));
        System.out.println(copiedWords);
    }

    private static List<String> copyWords(List<String> words) {
        List<String> copiedWords = new ArrayList<>();
        copiedWords.addAll(words);

        return copiedWords;
    }
}
