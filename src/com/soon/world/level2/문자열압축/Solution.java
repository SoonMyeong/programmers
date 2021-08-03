package com.soon.world.level2.문자열압축;


/**
 * 문제에도 나와있듯이 압축하는 기준 문자열의 개수는 전체길이의 반까지만 성립 된다.
 * -> 반이 넘어가면 쪼개 지지않음, 최대 반일경우 2개로 쪼개짐
 */
public class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count  = 1;
        StringBuilder stringBuilder = new StringBuilder();

        //i개 단위
        for(int i=1; i<=s.length()/2; i++) {
            String beforeString = s.substring(0,i);
            for (int j = i; j <s.length(); j+=i) {
                String tmp = s.substring(j, Math.min(j + i, s.length()));
                if(beforeString.equals(tmp)) {
                    count++;
                }else {
                    appendString(count,stringBuilder,beforeString);
                    count = 1;
                    beforeString = tmp;
                }

                if(j+i >= s.length()) {
                    appendString(count,stringBuilder,beforeString);
                    count = 1;
                }
            }
            System.out.println(stringBuilder.toString());
            answer = Math.min(answer,stringBuilder.length());
            stringBuilder.delete(0,stringBuilder.length());
        }
        return answer;
    }

    private void appendString(int count, StringBuilder stringBuilder, String beforeString) {
        if(count>1) {
            stringBuilder.append(count);
        }
        stringBuilder.append(beforeString);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaccc"));
    }
}
