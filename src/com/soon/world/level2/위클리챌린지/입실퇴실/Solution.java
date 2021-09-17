package com.soon.world.level2.위클리챌린지.입실퇴실;

import java.util.*;

public class Solution {

    /**
     *
     * 와 못풀어서 어떻게든 다른사람 풀이로 해결한 뒤 좋아요 많은 풀이 중 내스타일인 코드 가져옴...
     *
     * 각 자리수에 set.size() 만큼 더해준다는게 전혀 생각치 못한 개념이였다.
     * 분석합시다..
     *
     * @param enter
     * @param leave
     * @return
     */
    public int[] solution(int[] enter, int[] leave) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[enter.length];
        int i = -1;
        int j = 0;
        while(j < leave.length) {
            if (set.contains(leave[j])) {
                set.remove(leave[j]);
                count[leave[j]-1] += set.size();
                for (int s : set) count[s-1]++;
                j++;
            } else {
                while (++i < enter.length) {
                    set.add(enter[i]);
                    if (enter[i] == leave[j]) break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};


        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(enter, leave)));
    }
}
