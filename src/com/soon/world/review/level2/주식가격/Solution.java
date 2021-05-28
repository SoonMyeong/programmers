package com.soon.world.review.level2.주식가격;

import java.util.Arrays;
import java.util.Stack;

/**
 * 리뷰 결과(21.05.28)
 * 문제를 가지고 어떤식으로 접근해야 할지 모르겠음
 * 한번 참고하여 문제를 풀 때 이해하고 그냥 넘어가서 제대로 기억 못하는 걸로 추측 됨.
 * https://gurumee92.tistory.com/170 참고, 해설 잘 되어있음
 */
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();  //stack 에 시간을 저장한다 를 이해 해야 함

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int top =stack.pop();
                answer[top] = i-top;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int top =stack.pop();
            answer[top] = prices.length - top -1;
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}
