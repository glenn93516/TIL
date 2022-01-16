package enumtype;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class BitField {
    static class Text {
        static final int STYLE_BOLD          = 1 << 0;
        static final int STYLE_ITALIC        = 1 << 1;
        static final int STYLE_UNDERLINE     = 1 << 2;
        static final int STYLE_STRIKETHROUGH = 1 << 3;

        void applyStylesForIntEnum(int style) {

        }

        void applyStylesForEnum(Set<Style> styles) {

        }
    }

    enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public static void main(String[] args) {
        Text text = new Text();
        // 정수 열거 패턴 사용시
        // 타입 안정적이지 않고, 해석이 어렵다
        text.applyStylesForIntEnum(Text.STYLE_BOLD | Text.STYLE_ITALIC);

        // enum type 사용시
        // 타입 안정적이다, Set 인터페이스를 활용한다
        text.applyStylesForEnum(EnumSet.of(Style.UNDERLINE, Style.BOLD));
        text.applyStylesForEnum(Set.of(Style.UNDERLINE, Style.BOLD));

        // 단점은 아직 불변 EnumSet이 지원되지 않는다.
        // 대안 : unmodifiableSet으로 감싼다
        Set<Style> immutableEnumSet = Collections.unmodifiableSet(EnumSet.of(Style.UNDERLINE, Style.BOLD));
        text.applyStylesForEnum(immutableEnumSet);
    }
}
