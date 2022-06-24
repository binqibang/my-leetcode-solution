package binarysearch;

/**
 * @author binqibang
 */
public class TestMinSpeed {
    public static void main(String[] args) {
        int[] piles = new int[] {3,6,7,11};
        int h = 8;
        KokoEatingBananas test = new KokoEatingBananas();
        System.out.println(test.minEatingSpeed(piles, h));
    }
}
