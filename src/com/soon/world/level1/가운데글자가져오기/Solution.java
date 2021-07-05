package com.soon.world.level1.가운데글자가져오기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int strLength = s.length();
        if(strLength%2 == 0) {
            answer+= s.substring(strLength/2 -1, strLength/2 +1);
        }
        else {
            answer+= s.substring(strLength/2, strLength/2 +1);
        }
        return answer;
    }
    public String solutionString(String s) {
        String answer = "";

        String[] charStr = s.split("");
        int strLength = charStr.length;
        if(strLength%2 == 0) {
            answer+=charStr[strLength/2 -1];
            answer+=charStr[strLength/2];
        }
        else {
            answer+=charStr[strLength/2];
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcde"));
        System.out.println(solution.solutionString("qwer"));
    }
}
