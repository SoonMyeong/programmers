package com.soon.world.level2.주식가격;

import java.util.Arrays;
import java.util.Stack;

/**
 * 문제 해결 과정
 * 문제 이해 부터 잘 되지 않았던 문제 였다. 결국 구글링을 하게 되었다.
 * stack 을 사용한 풀이 법 || 디버깅 해서 이해했다...
 * 1. stack 에는 i 값을 넣는다. 넣는 이유는 while 문에서 지난번 값과 현재 값을 비교하기 위해서!
 * 2. stack 에 값이 존재하며, prices 이전 값이 현재값 보다 크다면, 가격이 하락 한 것이다.
 * 3. 2번 조건에 만족 시 stack 맨위 인덱스 (바로 전 초 시점) 을 꺼내어 현재 시점(i) 에서 빼준 값을 전 시점에 넣어 준다
 * ( 보기의 예를들면, 3초 시점의 3원이 4초 시점에 2원이 되니까 4-3 = 1 , 즉 3초시지점의 3원은 1초뒤 떨어진다. )
 * 4. 스택에 남아 있는 인덱스 들은 변화가 없는 인덱스 들이므로 prices 길이에서 스택인덱스-1을 빼준다.\
 * ----
 * [2중포문]
 * for (i = 0; i < len; i++) {
 *     for (j = i + 1; j < len; j++) {
 *             answer[i]++;
 *             if (prices[i] > prices[j])
 *                     break;
 *      }
 * }
 *
 */
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            while(!stack.empty() && prices[stack.peek()] > prices[i]) {
                int tmp = stack.pop();
                answer[tmp] = i -tmp;
            }
            stack.push(i);
        }

        while(!stack.empty()){
            int tmp = stack.pop();
            answer[tmp] = prices.length-tmp-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}
