package basic.문자열묶기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자열묶기() {
        Assertions.assertThat(solution(new String[] {"a","bc","d","efg","hi"})).isEqualTo(2);
    }

    /*
        문제 : 문자열 묶기
        https://school.programmers.co.kr/learn/courses/30/lessons/181855

        접근방법 :
        문자배열에서 각 원소의 길이들을 저장 할 자료구조를 하나 골라야 함.
        Map 자료구조를 쓰려다가.. 각 원소 길이는 최대 30 밖에 안되니까
        그냥 배열 쓰자
        인덱스 : str 길이 , 인덱스 원소에 들어있는 값 : str 길이가 인덱스인 str 총 개수

        베스트풀이 확인 :
        보통 for 루프 두번 돌게 로직 작성했는데
        내께 for 루프 한번 이라 복잡도 면에서 내가 더 나음
        그래도 나처럼 푼 사람도 있네 굳굳
     */
    public int solution(String[] strArr) {
        int[] temp = new int[30];
        int max = 0;
        for(String str : strArr) {
            temp[str.length() -1]++;
            max = Math.max(max , temp[str.length() -1]);
        }
        return max;
    }
}
