package com.soon.world.level2.올바른괄호;

import java.util.*;

/**
 * 문제 해결 과정
 * 괄호 하면 스택! 스택을 써서 구현하였다.
 * 근데 다른사람들 풀이보니까 스택 안 쓰고도 구현하네ㅎㅎ...
 */
public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack();
        char[] cutString = s.toCharArray();

        for(char ch : cutString) {
            if(stack.isEmpty() && ch==')') {
                answer = false;
                break;
            }
            if(ch == ')') {
                char tmp = (char) stack.pop();
                if(tmp!='(') {
                    answer = false;
                    break;
                }
            }else{
                stack.push(ch);
            }
        }

        if(!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
    }
}
