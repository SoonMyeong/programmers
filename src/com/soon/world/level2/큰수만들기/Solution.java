package com.soon.world.level2.큰수만들기;

import java.util.Stack;

/**
 * 큰 수 만들기
 * 문제 그대로 적용 시 TC 10에서 시간초과가 뜸 -> 질문하기 참고 스택을 이용
 *
 * 1. number 의 길이만큼 순회 하면서 스택에 number 하나를 계속해서 넣어 주는데
 * 만약 현재 스택 가장 위에 있는 숫자보다 넣어야 할 숫자가 더 클 경우
 * 가장 위에 있는 숫자를 빼주고, k값을 줄여 나간다. (k값 만큼 숫자를 제거 하는 문제임)
 * -> 결국 스택에는 아래에서 부터 위로 내림차순 정렬 되어 값이 들어가게 된다.`
 *
 * 2. number 의 순회를 마친 뒤 k 값이 0이 아닐 경우를 대비해 k 번 순회하여 스택에서 값을 빼준다.
 * 3. 스택에서 값을 빼서 builder 에 넣어 주고 리턴 시 reverse 를 활용함
 *
 */
public class Solution {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<number.length(); i++) {

            while(stack.size()>0 && number.charAt(i) > stack.peek()) {
                if(k>0) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            stack.push(number.charAt(i));
        }

        if(k>0) {
            for (int i=0; i<k; i++) {
                stack.pop();
            }
        }

        while(stack.size()>0) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k =4;
        Solution solution = new Solution();
        System.out.println(solution.solution(number,k));
    }
}
