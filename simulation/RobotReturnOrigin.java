package simulation;

/**
 * LeetCode #657 (Easy)
 * @author binqibang
 * @date 2022/7/5
 */
public class RobotReturnOrigin {
    public static boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }
        int [] coordinate = new int[] {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'R': coordinate[0]++;
                break;
                case 'L': coordinate[0]--;
                break;
                case 'U': coordinate[1]++;
                break;
                default: coordinate[1]--;
            }
        }
        return coordinate[0] == 0 && coordinate[1] == 0;
    }

    public static void main(String[] args) {
        String test = "UD";
        System.out.println(judgeCircle(test));
    }
}
