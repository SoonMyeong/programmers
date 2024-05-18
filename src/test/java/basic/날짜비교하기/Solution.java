package basic.날짜비교하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Solution {
    @Test
    void 날짜비교하기() {
        Assertions.assertThat(solution(new int[]{2021,12,28}, new int[]{2021,12,29})).isEqualTo(1);
        Assertions.assertThat(solution(new int[]{1024,10,24}, new int[]{1024,10,24})).isEqualTo(0);
    }

    /*
        문제 : 날짜 비교하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181838

        접근 방법 :
        날짜 비교 문제 이다.
        년/월/일을 따로 주기 때문에 년 비교, 년 같으면 월 비교 월도 같으면 일 비교..
        뭐 이런식으로도 할 수 있을 거같다. 근데 이왕 하는거 LocalDate 로 바꿔서 해보자.

        베스트풀이 확인 :
        내 풀이는 베스트풀이와 동일
        찾다보니까 접근방법에 적은 단순 숫자비교 방법으로 풀어낸 풀이도 있네 ㅋㅋ
     */
    public int solution(int[] date1, int[] date2) {
        LocalDate dateOne = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate dateTwo = LocalDate.of(date2[0], date2[1], date2[2]);

        if(dateOne.isBefore(dateTwo)) {
            return 1;
        }
        return 0;
    }
}
