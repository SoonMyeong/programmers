package introduction.문자열밀기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자열밀기() {
        Assertions.assertThat(solution("hello", "ohell")).isEqualTo(1);
        Assertions.assertThat(solution("apple", "elppa")).isEqualTo(-1);
        Assertions.assertThat(solution("atat", "tata")).isEqualTo(1);
        Assertions.assertThat(solution("abc", "abc")).isEqualTo(0);
    }

    /*
        문제 : 문자열 밀기
        https://school.programmers.co.kr/learn/courses/30/lessons/120921
        접근방법 :
        각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨앞으로 이동시킨다는건
        마지막 문자만 맨앞으로 이동시켜도 같은 결과가 됨.
        문자열의 길이만큼 밀게되면 다시 원래 문자열로 돌아옴.
        그러니 최대 String A 의 길이만큼만 반복하면서
        temp String 의 값을 바꿔가며 비교해가면 될듯

        베스트풀이 확인 :
        이야.. 단 한 줄인 B.repeat(2).indexOf(A) 로 풀어냈음.
        결과값 B 를 가지고 첫번째 문자를 왼쪽으로 N번 밀면서 규칙을 찾아낸거 같은데 마지막자리를
       기존 B 에다가 붙여놓고 ex) ohell 의 경우
        ohell -> hell[o] -> ello[h] -> lloh[e] -> lohe[l] -> ohel[l] 이 됨
        즉 ohell 를 2번 반복해서 붙이면 ohellohell 이 되고 sliding window 형식으로 이동하면서 찾으면 됨
        o[hello]hell -> oh[elloh]ell -> oh[ellohe]ll -> ohe[llohel]l -> ohell[ohell]
        바로 위 결과를 떠올리긴 쉽지 않을 거 같음.
     */
    public int solution(String A, String B) {
        int answer = -1;
        String temp = A;
        if(temp.equals(B)) {
            return 0;
        }
        for(int i = 0; i<A.length(); i++) {
            temp = temp.charAt(temp.length() -1) + temp.substring(0, temp.length() -1);
            if(temp.equals(B)) {
                return ++i;
            }
        }
        return answer;
    }
}
