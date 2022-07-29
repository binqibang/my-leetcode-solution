package math;

/**
 * @author binqibang
 */
public class TestMath {
    public static void main(String[] args) {
        // Test `GenerateRandomPointOfCircle`
        GenerateRandomPointOfCircle randomPointOfCircle = new GenerateRandomPointOfCircle(3, -2, 0);
        var point1 = randomPointOfCircle.randPoint();
        var point2 = randomPointOfCircle.randPoint();
        var point3 = randomPointOfCircle.randPoint();
        System.out.printf("[%.4f, %.4f]\n", point1[0], point1[1]);
        System.out.printf("[%.4f, %.4f]\n", point2[0], point2[1]);
        System.out.printf("[%.4f, %.4f]\n", point3[0], point3[1]);

        // Test `RandomPointOfNonOverlappingRecs`
        int[][] test = new int[][] {{-2, -2, 1, 1}, {2, 2, 4, 6}, {1, 2, 4, 5}};
        RandomPointOfNonOverlappingRecs sol = new RandomPointOfNonOverlappingRecs(test);
        for (int i = 0; i < 10; i++) {
            int[] point = sol.pick();
            System.out.printf("(%d, %d)\n",point[0], point[1]);
        }

        // Test `PrimeArrangements`
        PrimeArrangements sol1 = new PrimeArrangements();
        System.out.println(sol1.numPrimeArrangements(20));

        // Test `ValidSquare`
        ValidSquare sol2 = new ValidSquare();
        int[] p1 = new int[] {0, 0};
        int[] p2 = new int[] {1, 1};
        int[] p3 = new int[] {1, 0};
        int[] p4 = new int[] {0, 1};
        System.out.println(sol2.validSquare(p1, p2, p3, p4));

    }
}
