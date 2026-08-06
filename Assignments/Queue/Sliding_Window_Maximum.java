package Queue;

import java.util.*;
// dequeue with sliding window
// 1. If index at first of dequeue is outside window size (i-k) remove it (pop)
// 2. before iteration current element index remove all the elements that are smaller/equal to them
// 3. The largest element will always be at the front of the queue 
public class Sliding_Window_Maximum {
    static class MonotonicQueue {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int x) {
            while (!dq.isEmpty() && dq.peekLast() < x) {
                dq.pollLast();
            }
            dq.addLast(x);
        }

        public void pop(int x) {
            if (!dq.isEmpty() && dq.peekFirst() == x) {
                dq.pollFirst();
            }
        }

        public int max() {
            return dq.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            mq.push(nums[i]);
        }
        res[0] = mq.max();
        for (int i = k; i < n; i++) {
            mq.push(nums[i]);
            mq.pop(nums[i - k]);
            res[i - k + 1] = mq.max();
        }
        return res;
    }
    public static void main(String[] args) {
        Sliding_Window_Maximum solution = new Sliding_Window_Maximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
