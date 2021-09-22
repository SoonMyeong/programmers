package com.soon.world.review.level2.위클리챌린지.입실퇴실;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    /**
     * 좀 더 나답게 풀이
     * 근데 말 그대로 풀이하게 되면 지역변수 사용에 있어 헤깔릴 수 있을듯
     * @param enter
     * @param leave
     * @return
     */
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Set<Integer> room = new HashSet<>();
        int i = 0;
        int j = 0;

        while(i < leave.length) {
            if (!room.contains(leave[i])) {
                while (j < enter.length) {
                    room.add(enter[j]);
                    if (enter[j] == leave[i]) {
                        j++;
                        break;
                    }else {
                        j++;
                    }
                }
            } else {
                room.remove(leave[i]);
                answer[leave[i]-1] += room.size();
                for (int person : room) {
                    answer[person-1]++;
                }
                i++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};

        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.solution(enter, leave)));
    }
}
