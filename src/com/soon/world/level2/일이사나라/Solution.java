package com.soon.world.level2.일이사나라;

public class Solution {

    /**
     * 이 문제의 핵심은 1,2,4 나라는 3진수와 매우 흡사하다는 규칙을 찾아 내는것이 중요.
     *
     * @param n
     * @return
     */

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int quotient = n;
        int reminder = -1;

        while(quotient!=0) {
            reminder = quotient % 3;
            quotient = quotient / 3;

            if(reminder ==0) {
                answer.insert(0, "4");
                quotient--;
            }
            if(reminder ==1) {
                answer.insert(0, "1");
            }
            if(reminder ==2) {
                answer.insert(0, "2");
            }
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 15;
        System.out.println(solution.solution(n));
    }
}
