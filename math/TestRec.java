package math;

public class TestRec {
    public static void main(String[] args) {
        int[][] test = new int[][] {{-2, -2, 1, 1}, {2, 2, 4, 6}, {1, 2, 4, 5}};
        RandomPointOfNonOverlappingRecs sol = new RandomPointOfNonOverlappingRecs(test);
        var start = System.nanoTime();
        for (int i = 0; i < 10e8; i++) {
            int[] point = sol.pick();
            // System.out.printf("(%d, %d)\n",point[0], point[1]);
        }
        var finish = System.nanoTime();
        double cost = (double) (finish - start) / 1e9;
        System.out.printf("cost: %.4f s", cost);
    }
}
