package methods;

import java.util.List;

public class OverridingMain {
    static class Wine {
        String name() {
            return "wine";
        }
    }

    static class RedWine extends Wine {
        @Override
        String name() {
            return "Red wine";
        }
    }

    static class WhiteWine extends  Wine {
        @Override
        String name() {
            return "White wine";
        }
    }

    public static void main(String[] args) {
        List<Wine> wines = List.of(
                new Wine(),
                new RedWine(),
                new WhiteWine());

        // 의도대로 각 클래스에 맞는 name() 메서드가 호출된다
        for (Wine wine : wines) {
            System.out.println(wine.name());
            System.out.println(wine.getClass());
        }
    }
}
