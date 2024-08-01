package introduction.숫자찾기;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 숫자찾기() {

    }

    /*
        문제 : 숫자찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/120904
        접근 방법 :
        숫자 짤라서 k랑 같은지 체크하다가 같은 시점의 counting 하던 값을 리턴하면 됨
        좋아요 많은 풀이 :
        ("-"+num).indexOf 를 사용해서 한 줄로 해결
        근데 indexOf 메서드 구현 확인해보니 결국 loop 돔, 별 차이없음
     */
    public int solution(int num, int k) {
        int answer = 1;
        String a = "asd";
        for(String str : String.valueOf(num).split("")) {
            if(str.equals(String.valueOf(k))) {
                return answer;
            }
            answer++;
        }
        return -1;
    }
}
