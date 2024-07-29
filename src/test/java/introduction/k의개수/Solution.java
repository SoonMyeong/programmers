package introduction.k의개수;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void k의개수() {
        Assertions.assertThat(solution(1,13,1)).isEqualTo(6);
    }

    /*
        문제 : k의 개수
        https://school.programmers.co.kr/learn/courses/30/lessons/120887
        접근방법 :
        k가 몇번 등장하는지를 구하는거니까 숫자를 문자로 변경한 다음
        contains 로 k 값 들어있는지 체크하면 될 거 같음

        좋아요 많은 풀이:
        아이디어 싸움인데..
        str.length() - str.replace(k+"", "").length();
        loop 돌면서 string 에 다 추가한 다음 k를 없앤 길이만큼 뺀 값을 리턴함, 신박하다.
     */
    public int solution(int i, int j, int k) {
        int answer = 0;

        for(int n = i; n <= j; n++) {
            for(String str : String.valueOf(n).split("")) {
                if(str.contains(String.valueOf(k))) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
