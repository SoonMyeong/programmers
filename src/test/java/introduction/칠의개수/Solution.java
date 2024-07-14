package introduction.칠의개수;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 칠의개수() {
        Assertions.assertThat(solution(new int[] {7,77,17})).isEqualTo(4);
    }

    /*
        문제 : 7의 개수
        https://school.programmers.co.kr/learn/courses/30/lessons/120912
        접근 방법 :
        심플하게 접근해보면 숫자를 문자로 형변환 한 뒤 charArray 로 바꿔서
        7포함 개수 더하면 끝이긴 함..
        아니면 10으로 나누면서 나머지 체크하던지..

        좋아요 많은 풀이 :
        나랑비슷하게 스트림써서 한사람도 있고 나머지 체크로 풀어낸 풀이도 있음
     */
    public int solution(int[] array) {
        int answer = 0;
        for(int n : array) {
            for(char c :String.valueOf(n).toCharArray()) {
                if(c == '7') {
                    answer++;
                }
            }
        }

        return answer;
    }
}
