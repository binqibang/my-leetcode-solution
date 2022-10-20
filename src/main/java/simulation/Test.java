package simulation;

public class Test {
    public static void main(String[] args) {
        Shift2DGrid solution = new Shift2DGrid();
        int[][] test = new int[][] {{1,2},{4,5},{7,8}};
        int k = 5;
        var ans = solution.shiftGrid(test, k);
        System.out.println(ans.toString());

        // Test Fraction Addition and Subtraction
        FractionOperation solution1 = new FractionOperation();
        var exp = "1/2+1/5-8/5";
        System.out.println(solution1.fractionAddition(exp));
    }
}
