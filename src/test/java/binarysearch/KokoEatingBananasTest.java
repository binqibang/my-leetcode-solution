package binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KokoEatingBananasTest {
    private KokoEatingBananas koko;

    @BeforeEach
    void setUp() {
        koko = new KokoEatingBananas();
    }

    @Test
    void minEatingSpeed() {
        int[] piles = new int[] {3,6,7,11};
        int h = 8;
        System.out.println(koko.minEatingSpeed(piles, h));
    }
}