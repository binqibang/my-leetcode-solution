package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binqibang
 * @created 2021/9/13
 */
public class NumberOfBoomerangs {
    public static int numOfBoomerangs(int[][] points){
        int answer = 0;
        for (int[] p:points) {
            // Map<distance, count_distance>
            Map<Integer, Integer> count = new HashMap<>();
            for (int[] q:points) {
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                count.put(distance, count.getOrDefault(distance, 0) + 1);
            }
            // A(num_same_distance, 2)
            for(Map.Entry<Integer, Integer> entry:count.entrySet()){
                int num = entry.getValue();
                answer += num * (num - 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [][] test = {{0,0}, {1,0}, {2,0}};
        System.out.println(numOfBoomerangs(test));
    }
}
