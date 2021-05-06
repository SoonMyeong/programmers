package com.soon.world.level2.스킬트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 문제 해결 과정 (음..?자르고 자르고 생각하다보니 3중포문이 나오길래.. 구글링 해봄)
 * 이 문제의 해결 방법은 생각보다? 간단 했다.
 * 1. skill_trees 를 순회 하면서
 * 2. skill_tree 의 인덱스 별로 자른다. split
 * 3. 자른 걸 가지고 skill.indexOf() 를 써서 비교를 하는데
 * 4. 만약, skill 에 포함되지 않은 문자 일 경우 값은 계속 0일 것이다.
 * 5. 하지만 스킬트리에서 순서에 맞게 나열 했다면, skill.indexOf의 값은
 * 6. 순서대로 1,2,3 .. 증가하게 될 것이다.
 * 7. 따라서 해당 순서에 맞게 count 를 증가 시 잘못 된 스킬트리의 경우 count 값이 skill.indexOf 보다 더 작은 경우가 될 것이다.
 * 8. 또한 count 값과 skill.indexOf 가 같을 때만 count 를 증가해 준다. (index 존재 안할 시 -1 리턴하므로 같을 때만)
 * 8. 이를 걸러내면 된다.
 * ---------------------------
 * 결과 제출 후 아주 신박한 코드를 봐서 그걸로 다시 적어봄
 */
public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        //여기서 아주 신박한 코드를 발견했다..
        //정규표현식을 쓰는 방법인데 skill 을 skill_tree 에 비교하지 않고
        //skill_tree 에 대해 정규표현식을 활용한 뒤 첫번째 문자가 skill 의 0번째 인덱스 값과 같은지 확인 하는 방법인데
        //[^skill] 그러니까, skill 에 포함된 문자들을 포함하지 않을 경우 문자를 ""로 치환하고, indexOf() 를 통해
        //첫번째 문자가 skill 의 첫번째 문자와 같은지를 비교 하는 방법이다.
        for(int i=0; i<skill_trees.length; i++) {
            if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]","")) != 0) {
                answer--;
            }
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        String [] test = {"BACDE","CBADF","AECB","BDA"};
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD",test));
    }
}
