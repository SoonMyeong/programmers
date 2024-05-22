package basic.배열만들기5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 배열만들기_5() {
        Assertions.assertThat(solution(new String[] {"0123456789","9876543210","9999999999999"}, 50000, 5, 5))
                .isEqualTo(new int[] {56789, 99999});
    }

    /*
        문제 : 배열 만들기 5
        https://school.programmers.co.kr/learn/courses/30/lessons/181912

        접근 방법 :
        s번 인덱스에서 시작하는 길이 l 의 부분 문자열을 정수로 만들고
        그 정수가 k보다 크면 응답 배열에 담기
        이정도는 스트림으로 한번에 구현해도 될 거 같으니 스트림으로 구현해보기

        베스트풀이 확인:
        역시나 스트림으로 구현한 좋아요 많이 받은 답안 있음..ㅋㅋ
     */
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
                .mapToInt(str ->  Integer.parseInt(str.substring(s, s+l)))
                .filter(num -> num > k)
                .toArray();
    }
}
