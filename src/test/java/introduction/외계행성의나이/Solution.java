package introduction.외계행성의나이;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 외계행성의나이() {

    }

    /*
        문제 : 외계행성의 나이
        https://school.programmers.co.kr/learn/courses/30/lessons/120834
        접근 방법 :
        a = 0, b= 1 , c= 2...
        a 아스키 값이 97 니까 age 를 짜른 숫자 + 97 를 char 로 바꿔주면 됨
     */
    public String solution(int age) {
        var answer = "";
        var strArr = String.valueOf(age).split("");
        for(String str : strArr) {
            answer += (char) (Integer.parseInt(str) + 97);
        }

        return answer;
    }
}
