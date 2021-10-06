package com.soon.world.level1.삼진법뒤집기;

public class Solution {


    public long solution(int n) {
        long answer = 0;
        long quotient = n/3;
        StringBuilder divided = new StringBuilder();
        divided.append(n%3);

        while(quotient >0) {
            divided.append(quotient%3);
            quotient = quotient/3;
        }

        long convertInt = Long.parseLong(divided.toString());
        answer += (convertInt % 10);
        convertInt = convertInt / 10;

        int count = 1;
        while(convertInt>0) {
            answer+= (convertInt%10) * Math.pow(3,count);
            convertInt = convertInt/10;
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 125;
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}
