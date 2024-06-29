package introduction.종이자르기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 종이자르기() {
        Assertions.assertThat(solution(2,2)).isEqualTo(3);
        Assertions.assertThat(solution(2,5)).isEqualTo(9);
        Assertions.assertThat(solution(1,1)).isEqualTo(0);
    }

    /*
        문제 : 종이 자르기
        https://school.programmers.co.kr/learn/courses/30/lessons/120922
        접근 방법 :
        예제로 몇개 그려보면서 일반화 시켜보면 된다.
        공식 : (M-1) + M*(N-1)
        1. 2x2 종이
        [][]
        [][]

        [] | []
        [] | []   열 자르기 1번

        []    []
        --    --   행 자르기 2번
        []    []

        -> 1+2 = 3번

        2. 2x3 종이
        [][]
        [][]
        [][]

        [] | []
        [] | []
        [] | []    열 자르기 1번

        []  []
        -   -      행 자르기 2번
        []  []
        []  []

        []  []

        []  []
        -   -     행 자르기 2번
        []  []

        -> 1+2+2 = 5번

        느낌이 오는가? 행이 2로 고정일 때 열은 2-1인 1번만 자른다.

        이번엔 열을 고정으로 두고 행을 일반화 해보자.

        3. 2x2 종이
        [][]
        [][]

        [] | []
        [] | []   열 자르기 1번

        []    []
        --    --   행 자르기 2번
        []    []
        -> 1+2 = 3번

        4. 3x2 종이
        [][][]
        [][][]

        [] | [] | []
        [] | [] | []    열 자르기 2번

        []   []  []
        -    -    -     행 자르기 3번
        []   []  []

        -> 2+3 =  5번

        열이 2로 고정일 때는 행을 열열 3*(2-1) = 3 만큼 자르게 된다.

        좋아요 많은 풀이 :
        같음
     */
    public int solution(int M, int N) {
        if(M == 1 && N == 1) {
            return 0;
        }
        return (M-1) + M*(N-1);
    }
}
