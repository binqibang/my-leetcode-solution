package math;

import java.util.Random;

/**
 * Question: LeetCode #478 (Medium)
 * @author binqibang
 * @date 2022/6/5
 */
public class GenerateRandomPointOfCircle {
    Random random;
    double radius, xCenter, yCenter;

    public GenerateRandomPointOfCircle(double radius, double xCenter, double yCenter) {
        this.random = new Random();
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public double[] randPoint() {
        double x = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(x);
        return new double[]{xCenter + r * Math.cos(theta) * radius, yCenter + r * Math.sin(theta) * radius};
    }
}
