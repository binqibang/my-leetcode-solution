package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * @question Given an integer n, return the Nth ugly number. Ugly number is a positive
 *            number whose prime factors only include 2, 3, and/or 5.
 * @author   binqibang
 * @created  2021/04/11
 * @example  Input: n = 10;  Output: 12
 *           Explanation: first 10 ugly numbers: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
 */
public class NthUglyNumber {
    /** Using min heap */
    public static int nthUglyNumber(int n){
        int[] factors = {2, 3, 5};
        // using set to remove duplication
        Set<Long> existed = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1L);
        existed.add(1L);
        long curr;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            // poll(): remove the head of the queue and assign it to curr
            curr = minHeap.poll();
            answer = (int) curr;
            for (int factor:factors) {
                long next = curr * factor;
                // if next is not existed
                if(existed.add(next)){
                    minHeap.offer(next);
                }
            }
        }
        return answer;
    }

    /** TestCalendar */
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        System.out.println(nthUglyNumber(n));
    }
}
