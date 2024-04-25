package basic.문자열여러번뒤집기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자열_여러번_뒤집기() {
        Assertions.assertThat(solution("rermgorpsam", new int[][]{{2, 3}, {0, 7}, {5, 9}, {6, 10}}))
                .isEqualTo("programmers");
    }

    /*
        문제: 문자열 여러번 뒤집기
        https://school.programmers.co.kr/learn/courses/30/lessons/181913

        접근방법>
        쿼리에 해당하는 인덱스부분을 짤라서 역순 정렬 하고
        쿼리 시작인덱스 전 String + 역순 데이터 + 후 string 을 붙인다.
        이걸 반복한다.
        가독성은 좋을거 같은데..

        베스트풀이 확인>
        몇개의 풀이를 봤는데 근본은 같음.
        나처럼 StringBuilder 의 역순 메서드를 이용한 사람도 있고
        순수 reverse 메서드를 만들어 처리한 사람도 있고

     */
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;

        for (int[] query : queries) {
            StringBuilder sb = new StringBuilder(answer.substring(query[0], query[1] + 1));
            sb.reverse();
            answer =  answer.substring(0, query[0]) + sb + answer.substring(query[1] + 1);
        }

        return answer;
    }

}
