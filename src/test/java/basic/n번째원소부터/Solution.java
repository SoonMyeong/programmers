package basic.n번째원소부터;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void n번째_원소부터() {
        Assertions.assertThat(solution(new int[]{1,2,3,4,5}, 2))
                .isEqualTo(new int[]{2,3,4,5});
    }

    /*
        문제 : n번째 원소부터
        https://school.programmers.co.kr/learn/courses/30/lessons/181892
        접근방법:
        n 부터 마지막 원소까지 담아서.... 리턴...
        System.arraycopy(src, srcPos, dst, dstPos, length) 로 해결
        src: 복사할 원본 배열
        srcPos: 복사할 원본 배열 시작 인덱스
        dst : 복사한 값을 집어넣을 배열
        dstPost: 복사한 값을 집어넣을 배열의 시작 인덱스
        length: srcPos 부터 복사할 배열의 길이

        베스트풀이:
        좀 더 디테일한 복사는 arraycopy 메서드가 좋아보이나
        단순문제에는 Arrays.copyOfRange() 가 더 나아보임
        Arrays.copyOfRange(original, from, to)로 해결
        original : 배열
        from : 시작 인덱스
        to : 종료 인덱스
     */
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length-n +1];
        System.arraycopy(num_list,n-1,answer,0,num_list.length-n +1);
        return answer;
    }
}
