package methods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefensiveCopy {
    static class Period {
        private final Date start;
        private final Date end;
        private final List<Date> dates;

        // 불변성 깨지는 케이스
//        Period(Date start, Date end) {
//            this.start = start;
//            this.end = end;
//            this.dates = new ArrayList<>();
//            dates.add(start);
//            dates.add(end);
//        }

//        Date getStart() {
//            return this.start;
//        }
//
//        Date getEnd() {
//            return this.end;
//        }
//
//        List<Date> getDates() {
//            return this.dates;
//        }

        // 불변성 막는 케이스
        Period(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
            this.dates = List.of(start, end); // immutable list
        }

        Date getStart() {
            return new Date(this.start.getTime());
        }

        Date getEnd() {
            return new Date(this.end.getTime());
        }

        List<Date> getDates() {
            return new ArrayList<>(this.dates);
        }

        @Override
        public String toString() {
            return "Period{" +
                    "start=" + start +
                    ", end=" + end +
                    ", dates=" + dates +
                    '}';
        }
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        breakFinalConstructor(start, end);
        System.out.println("-----------");
        breakFinalGetter(new Period(start, end));
    }

    static void breakFinalConstructor(Date start, Date end) {
        Period period = new Period(start, end);
        System.out.println("before : " + period);

        // period에 건넨 start, end객체를 이용해 불변식을 깰 수 있다
        start.setYear(30);
        end.setMonth(11);
        System.out.println("after : " + period);
    }

    static void breakFinalGetter(Period period) {
        Date start = period.getStart();
        Date end = period.getEnd();
        List<Date> dates = period.getDates();

        System.out.println("before : " + period);
        // getter 메서드를 통해 얻은 참조로 변경할 수 있다
        start.setYear(11);
        end.setYear(22);
        dates.remove(1);
        System.out.println("after : " + period);
    }
}
