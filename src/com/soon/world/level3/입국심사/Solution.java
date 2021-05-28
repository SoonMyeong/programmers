package com.soon.world.level3.입국심사;

import java.util.Arrays;

/**
 * 이분탐색 유형의 문제..?
 *  - 이분탐색 (mid)
 *  - 걸리는 시간의 최소,최대 를 이분탐색의 left ,right 로 설정 후 mid 를 사용 하여 sum 해 준다.
 */
public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length-1];

        while(left<=right) {
            long mid = (left+right) / 2;
            long sum = 0;
            for(int i=0; i<times.length; i++) {
                sum += mid / times[i];
            }

            if(sum<n) {
                left = mid + 1;
            }else {
                if(mid <= answer) {
                    answer = mid;
                }
                right = mid - 1;
            }


        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution.solution(n,times));
    }
}
