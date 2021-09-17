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
                //나갈 애를 기준으로 남아있는 애들의 길이만큼 방문을 한다.
                //예를들어 set = [1,4,2] 일 경우 2번은 1번과 4번 모두를 만난것이므로 2번자리에 setSize 인 2를 더해준다.
                count[leave[j]-1] += set.size();
                for (int s : set) count[s-1]++; //방안에 있는사람들은 서로 만난 것이므로 1씩 더해준다.
                j++;
            } else {
                while (++i < enter.length) {
                    set.add(enter[i]);
                    if (enter[i] == leave[j]) break;   //방에 방문을 하다가 나갈순서에 해당하는 순번이 나오면 방에 사람 집어넣는 거를 멈춘다.
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};


        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(enter, leave)));
    }
}
