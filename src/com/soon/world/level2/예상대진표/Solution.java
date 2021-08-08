package com.soon.world.level2.예상대진표;

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 1;

        while(n%2==0) {
            //a와 b의 수 차이가 1이면서 각각의 수를 2로 나눈 몫의 차가 1이여야 한다.
            // ex) A : 2, B : 3 일 경우 몫의 차를 생각하지 않을 시 1라운드에서 만날 거라 예측함
            // 두 조건을 만족 시 A 와 B는 대결 하게 된다.
            if(((a-b)==1 || (b-a)==1 ) && ((a/2)-(b/2) ==1 || (b/2)-(a/2)==1)) {
                break;
            }

            if(a%2==0) {
                a = a/2;
            }else {
                a = a/2+1;
            }

            if(b%2==0) {
                b = b/2;
            }else {
                b = b/2+1;
            }
            answer++;


            n = n/2;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution.solution(n,a,b));
    }
}
