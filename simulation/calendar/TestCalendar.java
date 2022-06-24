package simulation.calendar;

/**
 * @author binqibang
 */
public class TestCalendar {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}
