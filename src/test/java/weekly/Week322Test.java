package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week322Test {
    private Week322 week322;

    @BeforeEach
    void setUp() {
        week322 = new Week322();
    }

    @Test
    void isCircularSentence() {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(week322.isCircularSentence(sentence));
    }

    @Test
    void dividePlayers() {
        int[] skill = new int[] {3,2,5,1,3,4};
        System.out.println(week322.dividePlayers(skill));
    }

    @Test
    void minScore() {
        int n = 4;
        int[][] roads = new int[][] {{1,2,9}, {2,3,6}, {2,4,5}, {1,4,7}};
        System.out.println(week322.minScore(n, roads));
    }
}