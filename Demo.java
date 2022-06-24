import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        var random = new Random();
        int N = (int) 1e6;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(random.nextInt(), random.nextInt());
        }
        long startTime = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            continue;
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9 );

        startTime = System.nanoTime();
        for (Integer key : map.keySet()) {
            int value = map.get(key);
        }
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9 );

        int i = 0;
        System.out.println(++i);
        System.out.println(i);

    }
}
