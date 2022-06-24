package math;

/**
 * @author binqibang
 */
public class Test {
    public static void main(String[] args) {
        GenerateRandomPointOfCircle randomPointOfCircle = new GenerateRandomPointOfCircle(3, -2, 0);
        var point1 = randomPointOfCircle.randPoint();
        var point2 = randomPointOfCircle.randPoint();
        var point3 = randomPointOfCircle.randPoint();
        System.out.printf("[%.4f, %.4f]\n", point1[0], point1[1]);
        System.out.printf("[%.4f, %.4f]\n", point2[0], point2[1]);
        System.out.printf("[%.4f, %.4f]\n", point3[0], point3[1]);
    }
}
