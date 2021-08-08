package com.soon.world.level1.로또의최고최저순위;

import java.util.Arrays;

//최고 순위는 무조건 0이 맞는 수 인거고,
//최저 순위는 무조건 0이 맞지 않는 수
public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        for(int lotto : lottos) {
            for(int num: win_nums) {
                if(lotto==num) {
                    count++;
                }
            }
            if(lotto == 0) {
                zeroCount++;
            }
        }

        answer[0] = calculateNumber(count+zeroCount);
        answer[1] = calculateNumber(count);
        return answer;
    }

    private int calculateNumber(int count) {
        switch (count) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default : return 6;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};
        System.out.println(Arrays.toString(solution.solution(lottos, win_nums)));
    }
}
