package com.soon.world.level2.모의고사;

import java.util.*;

/**
 *  문제 풀이
 *  1. 수포자별 맞은 개수 구하기
 *  2. 수포자별 맞은 개수들 중 최대 값 구하기
 *  3. 최대 맞은 개수가 중복일 수 있으며 몇명일지 몰라 ArrayList 사용 및 최대값과 같은 수포자 list 에 추가
 *  4. 수포자별 맞은 개수를 구할 때 count 배열에 인덱스 0부터 채웠으므로  +1 해줌
 */
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int [] count = new int[3];
        List<Integer> winners = new ArrayList<>();

        //1
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]) {
                count[0]++;
            }
            if(answers[i] == two[i%two.length]) {
                count[1]++;
            }
            if(answers[i] == three[i%three.length]) {
                count[2]++;
            }
        }

        //2
        int temp = count[0];
        for (int j : count) {
            if (temp < j) {
                temp = j;
            }
        }

        //3
        for(int i=0; i<count.length; i++){
            if(temp == count[i])
                winners.add(i);
        }

        //4
        int[] answer = new int[winners.size()];
        for (int i=0; i<winners.size();i++){
            answer[i]=winners.get(i)+1;
        }

        return answer;
    }
}
