package simulation.calendar;

/**
 * @author binqibang
 */
public class TestCalendar {
    public static void main(String[] args) {
        /*
         Test MyCalendar
         */
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));

        /*
         Test MyCalendarTwo
         */
        MyCalendarTwo calendarTwo = new MyCalendarTwo();
        calendarTwo.book(10, 20);
        calendarTwo.book(50, 60);
        calendarTwo.book(10, 40);
        calendarTwo.book(5, 15);
        calendarTwo.book(5, 10);
        calendarTwo.book(25, 55);
    }
}
