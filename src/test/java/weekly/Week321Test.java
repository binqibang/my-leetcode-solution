package weekly;

import list.ListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week321Test {
    private Week321 week321;

    @BeforeEach
    void setUp() {
        week321 = new Week321();
    }

    @Test
    void pivotInteger() {
        System.out.println(week321.pivotInteger(8));
    }

    @Test
    void appendCharacters() {
        String s = "coaching", t = "coding";
        System.out.println(week321.appendCharacters(s, t));
    }

    @Test
    void removeNodes() {
        int[] values = new int[] {5,2,13,3,8};
        var head = ListUtil.createList(values);
        ListUtil.printList(head);
        var removed = week321.removeNodes(head);
        ListUtil.printList(removed);
    }

    @Test
    void countSubarrays() {
        int[] nums = new int[] {3,2,1,4,5};
        int k = 4;
        System.out.println(week321.countSubarrays(nums, k));
    }
}